package kz.sapasoft.emark.app.ui.map

import android.location.Location
import androidx.lifecycle.MutableLiveData
import id.zelory.compressor.Compressor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.sapasoft.emark.app.core.App
import kz.sapasoft.emark.app.core.BaseViewModel
import kz.sapasoft.emark.app.data.cloud.ResultWrapper
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl
import kz.sapasoft.emark.app.data.local.room.image.ImageRepository
import kz.sapasoft.emark.app.data.local.room.marker.MarkerRepository
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncRepository
import kz.sapasoft.emark.app.data.local.room.template.TemplateRepository
import kz.sapasoft.emark.app.domain.model.MarkerModel
import kz.sapasoft.emark.app.domain.model.TemplateModel
import kz.sapasoft.emark.app.utils.Constants
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.UUID
import javax.inject.Inject
import kotlin.coroutines.Continuation
import kotlin.jvm.internal.Intrinsics

class MapViewModel @Inject constructor(
    baseCloudRepository2: BaseCloudRepository,
    templateRepository2: TemplateRepository,
    imageRepository2: ImageRepository,
    markerRepository2: MarkerRepository,
    markerSyncRepository2: MarkerSyncRepository,
    prefsImpl2: PrefsImpl
) : BaseViewModel() {
    private val TAG = javaClass.simpleName

    /* access modifiers changed from: private */
    @JvmField
    val baseCloudRepository: BaseCloudRepository
    private val `error$delegate`: MutableLiveData<ResultWrapper.Error> by lazy {
        MutableLiveData<ResultWrapper.Error>()
    }
    private val imageRepository: ImageRepository

    /* access modifiers changed from: private */
    @JvmField
    val markerListAll: MutableList<MarkerModel> = mutableListOf<MarkerModel>()
    private val `markerModelListData$delegate`: MutableLiveData<List<MarkerModel>> by lazy {
        MutableLiveData<List<MarkerModel>>()
    }

    /* access modifiers changed from: private */
    @JvmField
    val markerRepository: MarkerRepository

    /* access modifiers changed from: private */
    @JvmField
    val markerSyncRepository: MarkerSyncRepository

    /* access modifiers changed from: private */
    @JvmField
    var page = 1

    /* access modifiers changed from: private */
    @JvmField
    val prefsImpl: PrefsImpl
    private val templateRepository: TemplateRepository
    val error: MutableLiveData<ResultWrapper.Error>
        get() = `error$delegate`
    val markerModelListData: MutableLiveData<List<MarkerModel>>
        get() = `markerModelListData$delegate`

    init {
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository")
        Intrinsics.checkParameterIsNotNull(templateRepository2, "templateRepository")
        Intrinsics.checkParameterIsNotNull(imageRepository2, "imageRepository")
        Intrinsics.checkParameterIsNotNull(markerRepository2, "markerRepository")
        Intrinsics.checkParameterIsNotNull(markerSyncRepository2, "markerSyncRepository")
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl")
        baseCloudRepository = baseCloudRepository2
        templateRepository = templateRepository2
        imageRepository = imageRepository2
        markerRepository = markerRepository2
        markerSyncRepository = markerSyncRepository2
        prefsImpl = prefsImpl2
    }

    fun getMarkerList(projectIds: List<String?>) {
        launchIO {
            if (prefsImpl.offline) {
                getMarkerEntityList(projectIds?.get(0)!!)
            } else {
                val result = baseCloudRepository.getMarkerList(page++, projectIds)
                when (result) {
                    is ResultWrapper.Error -> error.postValue(result)
                    is ResultWrapper.Success -> {
                        if (result.value?.isNotEmpty() == true) {
                            markerListAll.addAll(result.value as Collection<MarkerModel>)
                            getMarkerList(projectIds)
                        } else {
                            insertMarkerEntityList(projectIds?.get(0)!!, markerListAll)
                            getMarkerEntityList(projectIds[0]!!)
                        }
                    }
                }
            }
        }
    }

    fun getTemplateList(ids: List<String?>?) {
        launchIO {
            if (!prefsImpl.offline) {
                val result = baseCloudRepository.getTemplateList(ids)
                when (result) {
                    is ResultWrapper.Error -> error.postValue(result)
                    is ResultWrapper.Success -> {
                        val templates = result.value?.filterNotNull() // Remove any nulls if present
                        if (templates?.isNotEmpty() == true) {
                            insertTemplateEntityList(templates)
                        }
                    }
                }
            }
        }
    }

    fun synchronizeMarkers(projectId: String?) {
        requireNotNull(projectId) { "projectId cannot be null" }

        launchIO {
            // First, save the marker list for the given project
            saveMarkerList(projectId)
            // Then retrieve the synchronized marker entity list
            getMarkerEntityList(projectId)
        }
    }

    suspend fun saveMarkerList(projectId: String) {
        val markerSyncList = markerSyncRepository.findByProjectId(projectId)

        for (markerSync in markerSyncList) {
            val markerModel = markerSync.toModel()
            saveMarker(markerModel)
        }
    }

    suspend fun saveMarker(markerModel: MarkerModel) {
        if (!prefsImpl.offline) {
            val markerNullable = markerModel.toNullable()

            // Set ID to null if status is NEW
            if (markerNullable.status == Constants.MarkerStatus.NEW) {
                markerNullable.id = null
            }

            // Generate a random marker ID if none is present
            if (markerNullable.markerId.isNullOrEmpty()) {
                markerNullable.markerId = UUID.randomUUID().toString()
            }

            when (val result = baseCloudRepository.saveMarker(markerNullable)) {
                is ResultWrapper.Error -> error.postValue(result)
                is ResultWrapper.Success -> {
                    deleteMarkerSyncById(markerModel.id)

                    // Save the updated marker data
                    val savedMarker = result.value
                    if (savedMarker != null) {
                        insertMarkerEntity(savedMarker)
                    }

                    // Handle associated images
                    imageRepository.getByLocalIdParent(
                        markerModel.idLocal ?: error("ID Local is null")
                    ).forEach { imageData ->
                        imageData.file?.let { saveImage(it, savedMarker?.id.toString()) }
                    }
                }
            }
        }
    }

    fun getMarkerEntityList(str: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            val markerModels = mutableListOf<MarkerModel>()

            // Get synchronized markers
            val markerSyncList = markerSyncRepository.findByProjectId(str)
            // Get markers from main repository and filter out those already synced
            val unsyncedMarkers = markerRepository.findByProjectId(str).filter { marker ->
                markerSyncList.none { syncMarker -> syncMarker.id == marker.id }
            }

            // Add unique unsynced markers
            markerModels.addAll(unsyncedMarkers)

            // Convert synced markers to MarkerModel and add them
            markerModels.addAll(markerSyncList.map { it.toModel() })

            // Post the result to LiveData
            markerModelListData.postValue(markerModels)
        }
    }

    suspend fun saveImage(file: File, parentId: String) {
        // Compress the image file
        val compressedImageFile = Compressor.compress(App.instance, file)

        // Prepare the multipart body for the request
        val requestFile =
            RequestBody.create(MediaType.parse("multipart/form-data"), compressedImageFile)
        val body = MultipartBody.Part.createFormData("data", compressedImageFile.name, requestFile)

        // Save the image using the BaseCloudRepository
        when (val result = baseCloudRepository.saveImage(parentId, body)) {
            is ResultWrapper.Error -> error.postValue(result)
            is ResultWrapper.Success -> Unit // Handle success if needed
        }
    }

    private fun deleteMarkerSyncById(str: String) {
        markerSyncRepository.deleteById(str)
    }

    /* access modifiers changed from: private */
    fun insertTemplateEntityList(list: List<TemplateModel?>?) {
        templateRepository.addWithReplace(list)
    }

    /* access modifiers changed from: private */
    fun insertMarkerEntityList(str: String?, list: List<MarkerModel?>?) {
        markerRepository.deleteByProjectId(str)
        markerRepository.addWithReplace(list)
    }

    private fun insertMarkerEntity(markerModel: MarkerModel) {
        markerRepository.addWithReplace(markerModel)
    }

    val markerSize: Float
        get() = prefsImpl.markerSize

    fun getMakerModelFromByteStr(str: String?, location: Location?): MarkerModel? {
//        String str2;
//        String str3 = str;
//        Intrinsics.checkParameterIsNotNull(str3, "string");
//        Intrinsics.checkParameterIsNotNull(location, FirebaseAnalytics.Param.LOCATION);
//        Regex regex = new Regex("(?<=ID# : )(.*)");
//        Regex regex2 = new Regex("(?<=Model : )(.*)");
//        CharSequence charSequence = str3;
//        MatchResult find$default = Regex.find$default(regex, charSequence, 0, 2, (Object) null);
//        String value = find$default != null ? find$default.getValue() : null;
//        MatchResult find$default2 = Regex.find$default(regex2, charSequence, 0, 2, (Object) null);
//        if (find$default2 == null || (str2 = find$default2.getValue()) == null) {
//            str2 = "1405-XR";
//        }
//        String str4 = str2;
//        if (value != null && !Pattern.compile("[a-zA-Z0-9]+").matcher(value).find()) {
//            value = UUID.randomUUID().toString();
//        }
//        String str5 = value;
//        String uuid = UUID.randomUUID().toString();
//        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
//        return new MarkerModel(uuid, (Long) null, (String) null, str5, str4, (String) null, (String) null, (List<String>) null, (Double) null, CollectionsKt.arrayListOf(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())), (List<FieldModel>) null, str5, (String) null, (String) null, Constants.MarkerStatus.NEW);
        return null
    }
}

package kz.sapasoft.emark.app.ui.settings

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import kz.sapasoft.emark.app.core.BaseViewModel
import kz.sapasoft.emark.app.data.cloud.ResultWrapper
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl
import kz.sapasoft.emark.app.data.local.room.marker.MarkerRepository
import kz.sapasoft.emark.app.data.local.room.project.ProjectRepository
import kz.sapasoft.emark.app.data.local.room.tag.TagRepository
import kz.sapasoft.emark.app.data.local.room.template.TemplateRepository
import kz.sapasoft.emark.app.domain.model.MarkerModel
import kz.sapasoft.emark.app.domain.model.ProjectModel
import kz.sapasoft.emark.app.domain.model.TagModel
import kz.sapasoft.emark.app.domain.model.TemplateModel
import kz.sapasoft.emark.app.utils.DateConverter
import kz.ss.emark.R
import java.util.Calendar
import javax.inject.Inject
import kotlin.coroutines.Continuation
import kotlin.jvm.internal.Intrinsics

class SettingsViewModel @Inject constructor(
    prefsImpl2: PrefsImpl,
    context2: Context,
    baseCloudRepository2: BaseCloudRepository,
    projectRepository2: ProjectRepository,
    tagRepository2: TagRepository,
    templateRepository2: TemplateRepository,
    markerRepository2: MarkerRepository
) : BaseViewModel() {

    private val TAG = javaClass.simpleName

    /* access modifiers changed from: private */
    @JvmField
    val baseCloudRepository: BaseCloudRepository
    private val context: Context
    private val `dateDb$delegate`: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val `loadButtonEnabled$delegate`: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    /* access modifiers changed from: private */
    val markerRepository: MarkerRepository

    /* access modifiers changed from: private */
    var markersPages: Int
    val offlineMode: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    /* access modifiers changed from: private */
    @JvmField
    val prefsImpl: PrefsImpl
    private val `progress$delegate`: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    private val `progressVisibility$delegate`: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    /* access modifiers changed from: private */
    val projectRepository: ProjectRepository

    /* access modifiers changed from: private */
    var projectsPages: Int

    /* access modifiers changed from: private */
    @JvmField
    val tagRepository: TagRepository

    /* access modifiers changed from: private */
    @JvmField
    var tagsPages: Int

    /* access modifiers changed from: private */
    val templateRepository: TemplateRepository
    val dateDb: MutableLiveData<String>
        get() = `dateDb$delegate`
    val loadButtonEnabled: MutableLiveData<Boolean>
        get() = `loadButtonEnabled$delegate`
    val progress: MutableLiveData<Int>
        get() = `progress$delegate`
    val progressVisibility: MutableLiveData<Boolean>
        get() = `progressVisibility$delegate`

    init {
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl")
        Intrinsics.checkParameterIsNotNull(context2, "context")
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository")
        Intrinsics.checkParameterIsNotNull(projectRepository2, "projectRepository")
        Intrinsics.checkParameterIsNotNull(tagRepository2, "tagRepository")
        Intrinsics.checkParameterIsNotNull(templateRepository2, "templateRepository")
        Intrinsics.checkParameterIsNotNull(markerRepository2, "markerRepository")
        prefsImpl = prefsImpl2
        context = context2
        baseCloudRepository = baseCloudRepository2
        projectRepository = projectRepository2
        tagRepository = tagRepository2
        templateRepository = templateRepository2
        markerRepository = markerRepository2
        setLoadingDate()
        offlineMode.postValue(java.lang.Boolean.valueOf(prefsImpl.offline))
        prefsImpl.dateDB
        progressVisibility.postValue(false)
        projectsPages = 1
        tagsPages = 1
        markersPages = 1
    }

    fun setOfflineMode(z: Boolean) {
        prefsImpl.offline = z
        loadButtonEnabled.postValue(java.lang.Boolean.valueOf(z))
    }

    /* access modifiers changed from: private */
    fun setLoadingDate() {
        val str: String
        if (prefsImpl.dateDB == null) {
            str = ""
        } else {
            str = context.resources.getString(
                R.string.download_date_x, *arrayOf<Any>(
                    prefsImpl.dateDB!!
                )
            )
            Intrinsics.checkExpressionValueIsNotNull(
                str,
                "context.resources.getStr…x, prefsImpl.getDateDB())"
            )
        }
        dateDb.postValue(str)
    }

    fun downloadAllDataFromServer() {
        projectsPages = 1
        tagsPages = 1
        markersPages = 1
        progress.postValue(0)
        progressVisibility.postValue(true)
        projectList
        tags
    }

    val projectList: Unit
        get() {
            launchIO {
                if (projectsPages == 1) {
                    projectRepository.deleteAll()
                }

                val result = baseCloudRepository.getProjectList(projectsPages)
                projectsPages += 1

                when (result) {
                    is ResultWrapper.Success -> {
                        val projects = result.value
                        if (projects?.isNotEmpty() == true) {
                            insertProjectEntityList(projects)
                            projectList // Recursive call to fetch the next page
                        } else {
                            progress.value?.let { currentProgress ->
                                progress.postValue(currentProgress + 100)
                            }
                            templateList
                            markerList
                        }
                    }
                    is ResultWrapper.Error -> {
                        Log.d("emark"," ResultWrapper.Error $result" )
                        //error().postValue(result)
                    }
                }
            }
        }
    val templateList: Unit
        get() {
            launchIO {
                templateRepository.deleteAll()

                val templateIds = ArrayList<String>()
                val projectEntityList = projectRepository.findAll()

                projectEntityList.forEach { project ->
                    templateIds.addAll(project.markerTemplateIds)
                }

                val distinctTemplateIds = templateIds.distinct()
                val result = baseCloudRepository.getTemplateList(distinctTemplateIds)

                if (result is ResultWrapper.Success && result.value?.isNotEmpty() == true) {
                    progress.value?.let { currentProgress ->
                        progress.postValue(currentProgress + 100)
                    }
                    insertTemplateEntityList(result.value)
                } else if (result is ResultWrapper.Error) {
                    //getError().postValue(result)
                }
            }
        }
    val tags: Unit
        get() {
            launchIO {
                if (tagsPages == 1) {
                    tagRepository.deleteAll()
                }

                val currentTagsPage = tagsPages
                tagsPages++

                val result = baseCloudRepository.getTagList(currentTagsPage)
                if (result is ResultWrapper.Success && result.value?.isNotEmpty() == true) {
                    insertTagEntityList(result.value)
                    tags
                } else if (result is ResultWrapper.Success) {
                    progress.value?.let { currentProgress ->
                        progress.postValue(currentProgress + 100)
                    }
                } else if (result is ResultWrapper.Error) {
                   // getError().postValue(result)
                } else {
                }
            }
        }
    val markerList: Unit
        get() {
            launchIO {
                if (markersPages == 1) {
                    markerRepository.deleteAll()
                }

                val projectEntityList = projectRepository.findAll()
                val ids = projectEntityList.map { it.id }
                val currentMarkersPage = markersPages
                markersPages++

                val result = baseCloudRepository.getMarkerList(currentMarkersPage, ids)
                if (result is ResultWrapper.Success && result.value?.isNotEmpty() == true) {
                    insertMarkerEntityList(result.value)
                    markerList // recursively fetch the next page if needed
                } else if (result is ResultWrapper.Success) {
                    progress.value?.let { currentProgress ->
                        progress.postValue(currentProgress + 100)
                    }
                    markerDetails
                } else if (result is ResultWrapper.Error) {
                    //getError().postValue(result)
                }
            }
        }

    val markerDetails: Unit
        get() {
            val arrayList = ArrayList<MarkerModel>()
            var page = 1

            while (true) {
                val findAll: Collection<MarkerModel> = markerRepository.findAll(page)
                if (findAll.isNotEmpty()) {
                    arrayList.addAll(findAll)
                    page++
                } else {
                    break
                }
            }

            arrayList.forEachIndexed { index, item ->
                launchIO {
                    val result = baseCloudRepository.getMarker(item.id)
                    if (result is ResultWrapper.Success) {
                        val progressValue = progress.value ?: 0
                        progress.postValue(progressValue + (10000 - progressValue) / (arrayList.size - index))

                        insertMarkerEntity(result.value as MarkerModel)

                        if (index == arrayList.size - 1) {
                            progressVisibility.postValue(false)

                            val currentTime = Calendar.getInstance().time
                            prefsImpl.dateDB = (DateConverter.dateToString(currentTime, "HH:mm:ss dd.MM.yyyy"))

                            setLoadingDate()
                        }
                    } else if (result is ResultWrapper.Error) {
                       // error.postValue(result)
                    }
                }
            }
        }

    /* access modifiers changed from: private */
    fun insertProjectEntityList(list: List<ProjectModel?>?) {
        projectRepository.addProjectList(list)
    }

    /* access modifiers changed from: private */
    fun insertTagEntityList(list: List<TagModel?>?) {
        tagRepository.addTagList(list)
    }

    /* access modifiers changed from: private */
    fun insertTemplateEntityList(list: List<TemplateModel?>?) {
        templateRepository.addWithReplace(list)
    }

    /* access modifiers changed from: private */
    fun insertMarkerEntityList(list: List<MarkerModel?>?) {
        markerRepository.addWithReplace(list)
    }

    /* access modifiers changed from: private */
    fun insertMarkerEntity(markerModel: MarkerModel?) {
        markerRepository.addWithReplace(markerModel)
    }

    fun saveMarkerSize(f: Float) {
        prefsImpl.markerSize = f
    }

    val markerSize: Float
        get() = prefsImpl.markerSize
}

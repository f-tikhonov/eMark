package kz.sapasoft.emark.app.ui.marker

import androidx.lifecycle.MutableLiveData
import kz.sapasoft.emark.app.core.BaseViewModel
import kz.sapasoft.emark.app.data.cloud.ResultWrapper
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl
import kz.sapasoft.emark.app.data.local.room.image.ImageRepository
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncRepository
import kz.sapasoft.emark.app.data.local.room.tag.TagRepository
import kz.sapasoft.emark.app.data.local.room.template.TemplateRepository
import kz.sapasoft.emark.app.domain.model.ImageDataModel
import kz.sapasoft.emark.app.domain.model.MarkerModel
import kz.sapasoft.emark.app.domain.model.TagModel
import kz.sapasoft.emark.app.domain.model.TemplateModel
import javax.inject.Inject
import kotlin.coroutines.Continuation
import kotlin.jvm.internal.Intrinsics

class MarkerViewModel @Inject constructor(
    baseCloudRepository2: BaseCloudRepository,
    prefsImpl2: PrefsImpl,
    templateRepository2: TemplateRepository,
    imageRepository2: ImageRepository,
    markerSyncRepository2: MarkerSyncRepository,
    tagRepository2: TagRepository
) : BaseViewModel() {
    private val TAG = javaClass.simpleName

    /* access modifiers changed from: private */
    @JvmField
    val baseCloudRepository: BaseCloudRepository
    private val `error$delegate`: MutableLiveData<ResultWrapper.Error> by lazy {
        MutableLiveData<ResultWrapper.Error>()
    }

    /* access modifiers changed from: private */
    @JvmField
    val imageRepository: ImageRepository
    private val `imagesData$delegate`: MutableLiveData<List<ImageDataModel>> by lazy {
        MutableLiveData<List<ImageDataModel>>()
    }
    private val `loading$delegate`: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    private val `localImagesData$delegate`: MutableLiveData<List<ImageDataModel>> by lazy {
        MutableLiveData<List<ImageDataModel>>()
    }
    private val `markerChangeTask$delegate`: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    private val `markerModelData$delegate`: MutableLiveData<MarkerModel> by lazy {
        MutableLiveData<MarkerModel>()
    }

    /* access modifiers changed from: private */
    @JvmField
    val markerSyncRepository: MarkerSyncRepository
    private val prefsImpl: PrefsImpl
    private val `saveImageData$delegate`: MutableLiveData<List<ImageDataModel>> by lazy {
        MutableLiveData<List<ImageDataModel>>()
    }
    private val `tagModelData$delegate`: MutableLiveData<List<TagModel>> by lazy {
        MutableLiveData<List<TagModel>>()
    }
    private val tagRepository: TagRepository
    private val `templateModelData$delegate`: MutableLiveData<List<TemplateModel>> by lazy {
        MutableLiveData<List<TemplateModel>>()
    }
    private val templateRepository: TemplateRepository
    val error: MutableLiveData<ResultWrapper.Error>
        get() = `error$delegate`.value as MutableLiveData<ResultWrapper.Error>
    val imagesData: MutableLiveData<List<Any>>
        get() = `imagesData$delegate`.value as MutableLiveData<List<Any>>
    val loading: MutableLiveData<Boolean>
        get() = `loading$delegate`.value as MutableLiveData<Boolean>
    val localImagesData: MutableLiveData<List<Any>>
        get() = `localImagesData$delegate`.value as MutableLiveData<List<Any>>
    val markerChangeTask: MutableLiveData<Boolean>
        get() = `markerChangeTask$delegate`.value as MutableLiveData<Boolean>
    val markerModelData: MutableLiveData<Any>
        get() = `markerModelData$delegate`.value as MutableLiveData<Any>
    val saveImageData: MutableLiveData<List<Any>>
        get() = `saveImageData$delegate`.value as MutableLiveData<List<Any>>
    val tagModelData: MutableLiveData<List<Any>>
        get() = `tagModelData$delegate`.value as MutableLiveData<List<Any>>
    val templateModelData: MutableLiveData<List<Any>>
        get() = `templateModelData$delegate`.value as MutableLiveData<List<Any>>

    init {
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository")
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl")
        Intrinsics.checkParameterIsNotNull(templateRepository2, "templateRepository")
        Intrinsics.checkParameterIsNotNull(imageRepository2, "imageRepository")
        Intrinsics.checkParameterIsNotNull(markerSyncRepository2, "markerSyncRepository")
        Intrinsics.checkParameterIsNotNull(tagRepository2, "tagRepository")
        baseCloudRepository = baseCloudRepository2
        prefsImpl = prefsImpl2
        templateRepository = templateRepository2
        imageRepository = imageRepository2
        markerSyncRepository = markerSyncRepository2
        tagRepository = tagRepository2
    }

    fun getAllData(markerModel: MarkerModel?, list: List<String?>?) {
        Intrinsics.checkParameterIsNotNull(markerModel, "markerModel")
        Intrinsics.checkParameterIsNotNull(list, "markerTemplateIds")
        loading.postValue(true)
        launchIO(`MarkerViewModel$getAllData$1`(this, list, markerModel, null as Continuation<*>?))
        loading.postValue(false)
    }

    /* access modifiers changed from: package-private */ /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */ /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */ /* JADX WARNING: Removed duplicated region for block: B:24:0x0078  */ /* JADX WARNING: Removed duplicated region for block: B:34:0x00ab  */ /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */ /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ fun getMarker(r5: MarkerModel?, r6: Continuation<Unit>?): Any {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kz.sapasoft.emark.app.ui.marker.MarkerViewModel$getMarker$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            kz.sapasoft.emark.app.ui.marker.MarkerViewModel$getMarker$1 r0 = (kz.sapasoft.emark.app.ui.marker.MarkerViewModel$getMarker$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            kz.sapasoft.emark.app.ui.marker.MarkerViewModel$getMarker$1 r0 = new kz.sapasoft.emark.app.ui.marker.MarkerViewModel$getMarker$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            kz.sapasoft.emark.app.domain.model.MarkerModel r5 = (kz.sapasoft.emark.app.domain.model.MarkerModel) r5
            java.lang.Object r0 = r0.L$0
            kz.sapasoft.emark.app.ui.marker.MarkerViewModel r0 = (kz.sapasoft.emark.app.ui.marker.MarkerViewModel) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x006a
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            kz.sapasoft.emark.app.data.local.prefs.PrefsImpl r6 = r4.prefsImpl
            boolean r6 = r6.getOffline()
            if (r6 == 0) goto L_0x004d
            androidx.lifecycle.MutableLiveData r6 = r4.getMarkerModelData()
            r6.postValue(r5)
            goto L_0x00a4
        L_0x004d:
            kz.sapasoft.emark.app.utils.Constants$MarkerStatus r6 = r5.getStatus()
            if (r6 != 0) goto L_0x008a
            r4.getImages(r5)
            kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository r6 = r4.baseCloudRepository
            java.lang.String r2 = r5.getId()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.getMarker(r2, r0)
            if (r6 != r1) goto L_0x0069
            return r1
        L_0x0069:
            r0 = r4
        L_0x006a:
            kz.sapasoft.emark.app.data.cloud.ResultWrapper r6 = (kz.sapasoft.emark.app.data.cloud.ResultWrapper) r6
            boolean r1 = r6 instanceof kz.sapasoft.emark.app.data.cloud.ResultWrapper.Error
            if (r1 == 0) goto L_0x0078
            androidx.lifecycle.MutableLiveData r1 = r0.getError()
            r1.postValue(r6)
            goto L_0x00a5
        L_0x0078:
            boolean r1 = r6 instanceof kz.sapasoft.emark.app.data.cloud.ResultWrapper.Success
            if (r1 == 0) goto L_0x00a5
            androidx.lifecycle.MutableLiveData r1 = r0.getMarkerModelData()
            kz.sapasoft.emark.app.data.cloud.ResultWrapper$Success r6 = (kz.sapasoft.emark.app.data.cloud.ResultWrapper.Success) r6
            java.lang.Object r6 = r6.getValue()
            r1.postValue(r6)
            goto L_0x00a5
        L_0x008a:
            kz.sapasoft.emark.app.utils.Constants$MarkerStatus r6 = r5.getStatus()
            kz.sapasoft.emark.app.utils.Constants$MarkerStatus r0 = kz.sapasoft.emark.app.utils.Constants.MarkerStatus.EDITED
            if (r6 != r0) goto L_0x009d
            r4.getImages(r5)
            androidx.lifecycle.MutableLiveData r6 = r4.getMarkerModelData()
            r6.postValue(r5)
            goto L_0x00a4
        L_0x009d:
            androidx.lifecycle.MutableLiveData r6 = r4.getMarkerModelData()
            r6.postValue(r5)
        L_0x00a4:
            r0 = r4
        L_0x00a5:
            java.lang.String r6 = r5.getIdLocal()
            if (r6 == 0) goto L_0x00c1
            kz.sapasoft.emark.app.data.local.room.image.ImageRepository r6 = r0.imageRepository
            java.lang.String r5 = r5.getIdLocal()
            if (r5 != 0) goto L_0x00b6
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00b6:
            java.util.List r5 = r6.getByLocalIdParent(r5)
            androidx.lifecycle.MutableLiveData r6 = r0.getLocalImagesData()
            r6.postValue(r5)
        L_0x00c1:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.marker.MarkerViewModel.getMarker(kz.sapasoft.emark.app.domain.model.MarkerModel, kotlin.coroutines.Continuation):java.lang.Object")
    }

    /* access modifiers changed from: private */
    fun getTemplateList(list: List<String?>) {
        val arrayList: ArrayList<TemplateModel> = ArrayList<TemplateModel>()
        for (findById in list) {
            arrayList.addAll(templateRepository.findById(findById))
        }
        templateModelData.postValue(arrayList)
    }

    val tagList: Unit
        /* access modifiers changed from: private */
        get() {
            tagModelData.postValue(tagRepository.findAll())
        }

    fun saveMarkerAndImage(markerModel: MarkerModel?, list: List<ImageDataModel?>?) {
        Intrinsics.checkParameterIsNotNull(markerModel, "markerModel")
        Intrinsics.checkParameterIsNotNull(list, "imageDataModelList")
        launchIO(
            `MarkerViewModel$saveMarkerAndImage$1`(
                this,
                markerModel,
                list,
                null as Continuation<*>?
            )
        )
    }

    fun deleteLocal(markerModel: MarkerModel?) {
        Intrinsics.checkParameterIsNotNull(markerModel, "markerModel")
        launchIO(`MarkerViewModel$deleteLocal$1`(this, markerModel, null as Continuation<*>?))
    }

    private fun getImages(markerModel: MarkerModel) {
        launchIO(`MarkerViewModel$getImages$1`(this, markerModel, null as Continuation<*>?))
    }
}

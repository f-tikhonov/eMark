package kz.sapasoft.emark.app.ui.map

import android.location.Location
import androidx.lifecycle.MutableLiveData
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
import java.io.File
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
    val markerListAll: ArrayList<MarkerModel> = ArrayList<MarkerModel>()
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
        get() = `error$delegate`.value as MutableLiveData<ResultWrapper.Error>
    val markerModelListData: MutableLiveData<List<Any>>
        get() = `markerModelListData$delegate`.value as MutableLiveData<List<Any>>

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

    fun getMarkerList(list: List<String?>?) {
        Intrinsics.checkParameterIsNotNull(list, "projectIds")
        //launchIO(`MapViewModel$getMarkerList$1`(this, list, null as Continuation<*>?))
    }

    fun getTemplateList(list: List<String?>?) {
        Intrinsics.checkParameterIsNotNull(list, "ids")
       // launchIO(`MapViewModel$getTemplateList$1`(this, list, null as Continuation<*>?))
    }

    fun synchronizeMarkers(str: String?) {
        Intrinsics.checkParameterIsNotNull(str, "projectId")
       // launchIO(`MapViewModel$synchronizeMarkers$1`(this, str, null as Continuation<*>?))
    }

    /* access modifiers changed from: package-private */ /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */ /* JADX WARNING: Removed duplicated region for block: B:15:0x0068  */ /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */ /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ fun saveMarkerList(r11: String?, r12: Continuation<Unit>?): Any {
        /*
            r10 = this;
            boolean r0 = r12 instanceof kz.sapasoft.emark.app.ui.map.MapViewModel$saveMarkerList$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            kz.sapasoft.emark.app.ui.map.MapViewModel$saveMarkerList$1 r0 = (kz.sapasoft.emark.app.ui.map.MapViewModel$saveMarkerList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            kz.sapasoft.emark.app.ui.map.MapViewModel$saveMarkerList$1 r0 = new kz.sapasoft.emark.app.ui.map.MapViewModel$saveMarkerList$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 != r3) goto L_0x0045
            java.lang.Object r11 = r0.L$6
            kz.sapasoft.emark.app.domain.model.MarkerModelSync r11 = (kz.sapasoft.emark.app.domain.model.MarkerModelSync) r11
            java.lang.Object r11 = r0.L$5
            java.lang.Object r11 = r0.L$4
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r2 = r0.L$3
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.Object r4 = r0.L$2
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.L$0
            kz.sapasoft.emark.app.ui.map.MapViewModel r6 = (kz.sapasoft.emark.app.ui.map.MapViewModel) r6
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r5
            goto L_0x0062
        L_0x0045:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r12)
            kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncRepository r12 = r10.markerSyncRepository
            java.util.List r12 = r12.findByProjectId(r11)
            r2 = r12
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r4 = r2.iterator()
            r6 = r10
            r9 = r12
            r12 = r11
            r11 = r4
            r4 = r9
        L_0x0062:
            boolean r5 = r11.hasNext()
            if (r5 == 0) goto L_0x008a
            java.lang.Object r5 = r11.next()
            r7 = r5
            kz.sapasoft.emark.app.domain.model.MarkerModelSync r7 = (kz.sapasoft.emark.app.domain.model.MarkerModelSync) r7
            kz.sapasoft.emark.app.domain.model.MarkerModel r8 = r7.toModel()
            r0.L$0 = r6
            r0.L$1 = r12
            r0.L$2 = r4
            r0.L$3 = r2
            r0.L$4 = r11
            r0.L$5 = r5
            r0.L$6 = r7
            r0.label = r3
            java.lang.Object r5 = r6.saveMarker(r8, r0)
            if (r5 != r1) goto L_0x0062
            return r1
        L_0x008a:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.map.MapViewModel.saveMarkerList(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object")
    }

    /* access modifiers changed from: package-private */ /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */ /* JADX WARNING: Removed duplicated region for block: B:31:0x0092  */ /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */ /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */ /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ fun saveMarker(r6: MarkerModel?, r7: Continuation<Unit>?): Any {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kz.sapasoft.emark.app.ui.map.MapViewModel$saveMarker$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            kz.sapasoft.emark.app.ui.map.MapViewModel$saveMarker$1 r0 = (kz.sapasoft.emark.app.ui.map.MapViewModel$saveMarker$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            kz.sapasoft.emark.app.ui.map.MapViewModel$saveMarker$1 r0 = new kz.sapasoft.emark.app.ui.map.MapViewModel$saveMarker$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r6 = r0.L$2
            kz.sapasoft.emark.app.domain.model.MarkerModelNullable r6 = (kz.sapasoft.emark.app.domain.model.MarkerModelNullable) r6
            java.lang.Object r6 = r0.L$1
            kz.sapasoft.emark.app.domain.model.MarkerModel r6 = (kz.sapasoft.emark.app.domain.model.MarkerModel) r6
            java.lang.Object r0 = r0.L$0
            kz.sapasoft.emark.app.ui.map.MapViewModel r0 = (kz.sapasoft.emark.app.ui.map.MapViewModel) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x008c
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            kz.sapasoft.emark.app.data.local.prefs.PrefsImpl r7 = r5.prefsImpl
            boolean r7 = r7.getOffline()
            if (r7 != 0) goto L_0x00e8
            kz.sapasoft.emark.app.domain.model.MarkerModelNullable r7 = r6.toNullable()
            kz.sapasoft.emark.app.utils.Constants$MarkerStatus r2 = r7.getStatus()
            kz.sapasoft.emark.app.utils.Constants$MarkerStatus r4 = kz.sapasoft.emark.app.utils.Constants.MarkerStatus.NEW
            if (r2 != r4) goto L_0x005b
            r2 = 0
            java.lang.String r2 = (java.lang.String) r2
            r7.setId(r2)
        L_0x005b:
            java.lang.String r2 = r7.getMarkerId()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x006c
            int r2 = r2.length()
            if (r2 != 0) goto L_0x006a
            goto L_0x006c
        L_0x006a:
            r2 = 0
            goto L_0x006d
        L_0x006c:
            r2 = 1
        L_0x006d:
            if (r2 == 0) goto L_0x007a
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r2 = r2.toString()
            r7.setMarkerId(r2)
        L_0x007a:
            kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository r2 = r5.baseCloudRepository
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r7 = r2.saveMarker(r7, r0)
            if (r7 != r1) goto L_0x008b
            return r1
        L_0x008b:
            r0 = r5
        L_0x008c:
            kz.sapasoft.emark.app.data.cloud.ResultWrapper r7 = (kz.sapasoft.emark.app.data.cloud.ResultWrapper) r7
            boolean r1 = r7 instanceof kz.sapasoft.emark.app.data.cloud.ResultWrapper.Error
            if (r1 == 0) goto L_0x009a
            androidx.lifecycle.MutableLiveData r6 = r0.getError()
            r6.postValue(r7)
            goto L_0x00e8
        L_0x009a:
            boolean r1 = r7 instanceof kz.sapasoft.emark.app.data.cloud.ResultWrapper.Success
            if (r1 == 0) goto L_0x00e8
            java.lang.String r1 = r6.getId()
            r0.deleteMarkerSyncById(r1)
            kz.sapasoft.emark.app.data.cloud.ResultWrapper$Success r7 = (kz.sapasoft.emark.app.data.cloud.ResultWrapper.Success) r7
            java.lang.Object r1 = r7.getValue()
            kz.sapasoft.emark.app.domain.model.MarkerModel r1 = (kz.sapasoft.emark.app.domain.model.MarkerModel) r1
            r0.insertMarkerEntity(r1)
            kz.sapasoft.emark.app.data.local.room.image.ImageRepository r1 = r0.imageRepository
            java.lang.String r6 = r6.getIdLocal()
            if (r6 != 0) goto L_0x00bb
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00bb:
            java.util.List r6 = r1.getByLocalIdParent(r6)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x00c5:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x00e8
            java.lang.Object r1 = r6.next()
            kz.sapasoft.emark.app.domain.model.ImageDataModel r1 = (kz.sapasoft.emark.app.domain.model.ImageDataModel) r1
            java.lang.Object r2 = r7.getValue()
            kz.sapasoft.emark.app.domain.model.MarkerModel r2 = (kz.sapasoft.emark.app.domain.model.MarkerModel) r2
            java.lang.String r2 = r2.getId()
            java.io.File r1 = r1.getFile()
            if (r1 != 0) goto L_0x00e4
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00e4:
            r0.saveImage(r2, r1)
            goto L_0x00c5
        L_0x00e8:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.map.MapViewModel.saveMarker(kz.sapasoft.emark.app.domain.model.MarkerModel, kotlin.coroutines.Continuation):java.lang.Object")
    }

    fun getMarkerEntityList(str: String?) {
        Intrinsics.checkParameterIsNotNull(str, "projectId")
        launchIO(`MapViewModel$getMarkerEntityList$1`(this, str, null as Continuation<*>?))
    }

    fun saveImage(str: String?, file: File?) {
        Intrinsics.checkParameterIsNotNull(str, "parentId")
        Intrinsics.checkParameterIsNotNull(file, "file")
        launchIO(`MapViewModel$saveImage$1`(this, file, str, null as Continuation<*>?))
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

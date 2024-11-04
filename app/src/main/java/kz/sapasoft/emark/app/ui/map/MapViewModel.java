package kz.sapasoft.emark.app.ui.map;

import android.location.Location;
import androidx.lifecycle.MutableLiveData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kz.sapasoft.emark.app.core.BaseViewModel;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;
import kz.sapasoft.emark.app.data.local.room.image.ImageRepository;
import kz.sapasoft.emark.app.data.local.room.marker.MarkerRepository;
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncRepository;
import kz.sapasoft.emark.app.data.local.room.template.TemplateRepository;
import kz.sapasoft.emark.app.domain.model.FieldModel;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.sapasoft.emark.app.domain.model.TemplateModel;
import kz.sapasoft.emark.app.utils.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0010H\u0002J\u0016\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0010J\u0014\u0010,\u001a\u00020$2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100\u001eJ\u0006\u0010.\u001a\u00020/J\u0014\u00100\u001a\u00020$2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u001eJ\u0010\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\u001bH\u0002J\u001e\u00104\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00102\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001eH\u0002J\u0016\u00105\u001a\u00020$2\f\u00106\u001a\b\u0012\u0004\u0012\u0002070\u001eH\u0002J\u0016\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020;J\u0019\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010>J\u0019\u0010?\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010@J\u000e\u0010A\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0010R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0004¢\u0006\u0002\n\u0000R'\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001e0\u00138FX\u0002¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b\u001f\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lkz/sapasoft/emark/app/ui/map/MapViewModel;", "Lkz/sapasoft/emark/app/core/BaseViewModel;", "baseCloudRepository", "Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;", "templateRepository", "Lkz/sapasoft/emark/app/data/local/room/template/TemplateRepository;", "imageRepository", "Lkz/sapasoft/emark/app/data/local/room/image/ImageRepository;", "markerRepository", "Lkz/sapasoft/emark/app/data/local/room/marker/MarkerRepository;", "markerSyncRepository", "Lkz/sapasoft/emark/app/data/local/room/marker_sync/MarkerSyncRepository;", "prefsImpl", "Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;", "(Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;Lkz/sapasoft/emark/app/data/local/room/template/TemplateRepository;Lkz/sapasoft/emark/app/data/local/room/image/ImageRepository;Lkz/sapasoft/emark/app/data/local/room/marker/MarkerRepository;Lkz/sapasoft/emark/app/data/local/room/marker_sync/MarkerSyncRepository;Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;)V", "TAG", "", "kotlin.jvm.PlatformType", "error", "Landroidx/lifecycle/MutableLiveData;", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Error;", "getError", "()Landroidx/lifecycle/MutableLiveData;", "error$delegate", "Lkotlin/Lazy;", "markerListAll", "Ljava/util/ArrayList;", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "Lkotlin/collections/ArrayList;", "markerModelListData", "", "getMarkerModelListData", "markerModelListData$delegate", "page", "", "deleteMarkerSyncById", "", "markerId", "getMakerModelFromByteStr", "string", "location", "Landroid/location/Location;", "getMarkerEntityList", "projectId", "getMarkerList", "projectIds", "getMarkerSize", "", "getTemplateList", "ids", "insertMarkerEntity", "markerModelList", "insertMarkerEntityList", "insertTemplateEntityList", "templateModelList", "Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "saveImage", "parentId", "file", "Ljava/io/File;", "saveMarker", "markerModel", "(Lkz/sapasoft/emark/app/domain/model/MarkerModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveMarkerList", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "synchronizeMarkers", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MapViewModel.kt */
public final class MapViewModel extends BaseViewModel {
    private final String TAG = getClass().getSimpleName();
    /* access modifiers changed from: private */
    public final BaseCloudRepository baseCloudRepository;
    private final Lazy error$delegate = LazyKt.lazy(MapViewModel$error$2.INSTANCE);
    private final ImageRepository imageRepository;
    /* access modifiers changed from: private */
    public final ArrayList<MarkerModel> markerListAll = new ArrayList<>();
    private final Lazy markerModelListData$delegate = LazyKt.lazy(MapViewModel$markerModelListData$2.INSTANCE);
    /* access modifiers changed from: private */
    public final MarkerRepository markerRepository;
    /* access modifiers changed from: private */
    public final MarkerSyncRepository markerSyncRepository;
    /* access modifiers changed from: private */
    public int page = 1;
    /* access modifiers changed from: private */
    public final PrefsImpl prefsImpl;
    private final TemplateRepository templateRepository;

    public final MutableLiveData<ResultWrapper.Error> getError() {
        return (MutableLiveData) this.error$delegate.getValue();
    }

    public final MutableLiveData<List<MarkerModel>> getMarkerModelListData() {
        return (MutableLiveData) this.markerModelListData$delegate.getValue();
    }

    @Inject
    public MapViewModel(BaseCloudRepository baseCloudRepository2, TemplateRepository templateRepository2, ImageRepository imageRepository2, MarkerRepository markerRepository2, MarkerSyncRepository markerSyncRepository2, PrefsImpl prefsImpl2) {
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository");
        Intrinsics.checkParameterIsNotNull(templateRepository2, "templateRepository");
        Intrinsics.checkParameterIsNotNull(imageRepository2, "imageRepository");
        Intrinsics.checkParameterIsNotNull(markerRepository2, "markerRepository");
        Intrinsics.checkParameterIsNotNull(markerSyncRepository2, "markerSyncRepository");
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl");
        this.baseCloudRepository = baseCloudRepository2;
        this.templateRepository = templateRepository2;
        this.imageRepository = imageRepository2;
        this.markerRepository = markerRepository2;
        this.markerSyncRepository = markerSyncRepository2;
        this.prefsImpl = prefsImpl2;
    }

    public final void getMarkerList(List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "projectIds");
        launchIO(new MapViewModel$getMarkerList$1(this, list, (Continuation) null));
    }

    public final void getTemplateList(List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "ids");
        launchIO(new MapViewModel$getTemplateList$1(this, list, (Continuation) null));
    }

    public final void synchronizeMarkers(String str) {
        Intrinsics.checkParameterIsNotNull(str, "projectId");
        launchIO(new MapViewModel$synchronizeMarkers$1(this, str, (Continuation) null));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ Object saveMarkerList(String r11, Continuation<? super kotlin.Unit> r12) {
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
        throw new UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.map.MapViewModel.saveMarkerList(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ Object saveMarker(MarkerModel r6, Continuation<? super kotlin.Unit> r7) {
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
        throw new UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.map.MapViewModel.saveMarker(kz.sapasoft.emark.app.domain.model.MarkerModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void getMarkerEntityList(String str) {
        Intrinsics.checkParameterIsNotNull(str, "projectId");
        launchIO(new MapViewModel$getMarkerEntityList$1(this, str, (Continuation) null));
    }

    public final void saveImage(String str, File file) {
        Intrinsics.checkParameterIsNotNull(str, "parentId");
        Intrinsics.checkParameterIsNotNull(file, "file");
        launchIO(new MapViewModel$saveImage$1(this, file, str, (Continuation) null));
    }

    private final void deleteMarkerSyncById(String str) {
        this.markerSyncRepository.deleteById(str);
    }

    /* access modifiers changed from: private */
    public final void insertTemplateEntityList(List<TemplateModel> list) {
        this.templateRepository.addWithReplace(list);
    }

    /* access modifiers changed from: private */
    public final void insertMarkerEntityList(String str, List<MarkerModel> list) {
        this.markerRepository.deleteByProjectId(str);
        this.markerRepository.addWithReplace(list);
    }

    private final void insertMarkerEntity(MarkerModel markerModel) {
        this.markerRepository.addWithReplace(markerModel);
    }

    public final float getMarkerSize() {
        return this.prefsImpl.getMarkerSize();
    }

    public final MarkerModel getMakerModelFromByteStr(String str, Location location) {
        String str2;
        String str3 = str;
        Intrinsics.checkParameterIsNotNull(str3, "string");
        Intrinsics.checkParameterIsNotNull(location, FirebaseAnalytics.Param.LOCATION);
        Regex regex = new Regex("(?<=ID# : )(.*)");
        Regex regex2 = new Regex("(?<=Model : )(.*)");
        CharSequence charSequence = str3;
        MatchResult find$default = Regex.find$default(regex, charSequence, 0, 2, (Object) null);
        String value = find$default != null ? find$default.getValue() : null;
        MatchResult find$default2 = Regex.find$default(regex2, charSequence, 0, 2, (Object) null);
        if (find$default2 == null || (str2 = find$default2.getValue()) == null) {
            str2 = "1405-XR";
        }
        String str4 = str2;
        if (value != null && !Pattern.compile("[a-zA-Z0-9]+").matcher(value).find()) {
            value = UUID.randomUUID().toString();
        }
        String str5 = value;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        return new MarkerModel(uuid, (Long) null, (String) null, str5, str4, (String) null, (String) null, (List<String>) null, (Double) null, CollectionsKt.arrayListOf(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())), (List<FieldModel>) null, str5, (String) null, (String) null, Constants.MarkerStatus.NEW);
    }
}

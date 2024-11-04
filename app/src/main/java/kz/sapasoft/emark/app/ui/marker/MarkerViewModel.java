package kz.sapasoft.emark.app.ui.marker;

import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.core.BaseViewModel;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;
import kz.sapasoft.emark.app.data.local.room.image.ImageRepository;
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncRepository;
import kz.sapasoft.emark.app.data.local.room.tag.TagRepository;
import kz.sapasoft.emark.app.data.local.room.template.TemplateRepository;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.sapasoft.emark.app.domain.model.TagModel;
import kz.sapasoft.emark.app.domain.model.TemplateModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020)J\u001c\u0010:\u001a\u0002082\u0006\u00109\u001a\u00020)2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100\u001aJ\u0010\u0010<\u001a\u0002082\u0006\u00109\u001a\u00020)H\u0002J\u0019\u0010=\u001a\u0002082\u0006\u00109\u001a\u00020)H@ø\u0001\u0000¢\u0006\u0002\u0010>J\b\u0010?\u001a\u000208H\u0002J\u0016\u0010@\u001a\u0002082\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100\u001aH\u0002J\u001c\u0010A\u001a\u0002082\u0006\u00109\u001a\u00020)2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R'\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00138FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001c\u0010\u0016R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00138FX\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b \u0010\u0016R'\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00138FX\u0002¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b#\u0010\u0016R!\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00138FX\u0002¢\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b&\u0010\u0016R!\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00138FX\u0002¢\u0006\f\n\u0004\b+\u0010\u0018\u001a\u0004\b*\u0010\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R'\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00138FX\u0002¢\u0006\f\n\u0004\b.\u0010\u0018\u001a\u0004\b-\u0010\u0016R'\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u001a0\u00138FX\u0002¢\u0006\f\n\u0004\b2\u0010\u0018\u001a\u0004\b1\u0010\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R'\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u001a0\u00138FX\u0002¢\u0006\f\n\u0004\b6\u0010\u0018\u001a\u0004\b5\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006C"}, d2 = {"Lkz/sapasoft/emark/app/ui/marker/MarkerViewModel;", "Lkz/sapasoft/emark/app/core/BaseViewModel;", "baseCloudRepository", "Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;", "prefsImpl", "Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;", "templateRepository", "Lkz/sapasoft/emark/app/data/local/room/template/TemplateRepository;", "imageRepository", "Lkz/sapasoft/emark/app/data/local/room/image/ImageRepository;", "markerSyncRepository", "Lkz/sapasoft/emark/app/data/local/room/marker_sync/MarkerSyncRepository;", "tagRepository", "Lkz/sapasoft/emark/app/data/local/room/tag/TagRepository;", "(Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;Lkz/sapasoft/emark/app/data/local/room/template/TemplateRepository;Lkz/sapasoft/emark/app/data/local/room/image/ImageRepository;Lkz/sapasoft/emark/app/data/local/room/marker_sync/MarkerSyncRepository;Lkz/sapasoft/emark/app/data/local/room/tag/TagRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "error", "Landroidx/lifecycle/MutableLiveData;", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Error;", "getError", "()Landroidx/lifecycle/MutableLiveData;", "error$delegate", "Lkotlin/Lazy;", "imagesData", "", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "getImagesData", "imagesData$delegate", "loading", "", "getLoading", "loading$delegate", "localImagesData", "getLocalImagesData", "localImagesData$delegate", "markerChangeTask", "getMarkerChangeTask", "markerChangeTask$delegate", "markerModelData", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "getMarkerModelData", "markerModelData$delegate", "saveImageData", "getSaveImageData", "saveImageData$delegate", "tagModelData", "Lkz/sapasoft/emark/app/domain/model/TagModel;", "getTagModelData", "tagModelData$delegate", "templateModelData", "Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "getTemplateModelData", "templateModelData$delegate", "deleteLocal", "", "markerModel", "getAllData", "markerTemplateIds", "getImages", "getMarker", "(Lkz/sapasoft/emark/app/domain/model/MarkerModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTagList", "getTemplateList", "saveMarkerAndImage", "imageDataModelList", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MarkerViewModel.kt */
public final class MarkerViewModel extends BaseViewModel {
    private final String TAG = getClass().getSimpleName();
    /* access modifiers changed from: private */
    public final BaseCloudRepository baseCloudRepository;
    private final Lazy error$delegate = LazyKt.lazy(MarkerViewModel$error$2.INSTANCE);
    /* access modifiers changed from: private */
    public final ImageRepository imageRepository;
    private final Lazy imagesData$delegate = LazyKt.lazy(MarkerViewModel$imagesData$2.INSTANCE);
    private final Lazy loading$delegate = LazyKt.lazy(MarkerViewModel$loading$2.INSTANCE);
    private final Lazy localImagesData$delegate = LazyKt.lazy(MarkerViewModel$localImagesData$2.INSTANCE);
    private final Lazy markerChangeTask$delegate = LazyKt.lazy(MarkerViewModel$markerChangeTask$2.INSTANCE);
    private final Lazy markerModelData$delegate = LazyKt.lazy(MarkerViewModel$markerModelData$2.INSTANCE);
    /* access modifiers changed from: private */
    public final MarkerSyncRepository markerSyncRepository;
    private final PrefsImpl prefsImpl;
    private final Lazy saveImageData$delegate = LazyKt.lazy(MarkerViewModel$saveImageData$2.INSTANCE);
    private final Lazy tagModelData$delegate = LazyKt.lazy(MarkerViewModel$tagModelData$2.INSTANCE);
    private final TagRepository tagRepository;
    private final Lazy templateModelData$delegate = LazyKt.lazy(MarkerViewModel$templateModelData$2.INSTANCE);
    private final TemplateRepository templateRepository;

    public final MutableLiveData<ResultWrapper.Error> getError() {
        return (MutableLiveData) this.error$delegate.getValue();
    }

    public final MutableLiveData<List<ImageDataModel>> getImagesData() {
        return (MutableLiveData) this.imagesData$delegate.getValue();
    }

    public final MutableLiveData<Boolean> getLoading() {
        return (MutableLiveData) this.loading$delegate.getValue();
    }

    public final MutableLiveData<List<ImageDataModel>> getLocalImagesData() {
        return (MutableLiveData) this.localImagesData$delegate.getValue();
    }

    public final MutableLiveData<Boolean> getMarkerChangeTask() {
        return (MutableLiveData) this.markerChangeTask$delegate.getValue();
    }

    public final MutableLiveData<MarkerModel> getMarkerModelData() {
        return (MutableLiveData) this.markerModelData$delegate.getValue();
    }

    public final MutableLiveData<List<ImageDataModel>> getSaveImageData() {
        return (MutableLiveData) this.saveImageData$delegate.getValue();
    }

    public final MutableLiveData<List<TagModel>> getTagModelData() {
        return (MutableLiveData) this.tagModelData$delegate.getValue();
    }

    public final MutableLiveData<List<TemplateModel>> getTemplateModelData() {
        return (MutableLiveData) this.templateModelData$delegate.getValue();
    }

    @Inject
    public MarkerViewModel(BaseCloudRepository baseCloudRepository2, PrefsImpl prefsImpl2, TemplateRepository templateRepository2, ImageRepository imageRepository2, MarkerSyncRepository markerSyncRepository2, TagRepository tagRepository2) {
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository");
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl");
        Intrinsics.checkParameterIsNotNull(templateRepository2, "templateRepository");
        Intrinsics.checkParameterIsNotNull(imageRepository2, "imageRepository");
        Intrinsics.checkParameterIsNotNull(markerSyncRepository2, "markerSyncRepository");
        Intrinsics.checkParameterIsNotNull(tagRepository2, "tagRepository");
        this.baseCloudRepository = baseCloudRepository2;
        this.prefsImpl = prefsImpl2;
        this.templateRepository = templateRepository2;
        this.imageRepository = imageRepository2;
        this.markerSyncRepository = markerSyncRepository2;
        this.tagRepository = tagRepository2;
    }

    public final void getAllData(MarkerModel markerModel, List<String> list) {
        Intrinsics.checkParameterIsNotNull(markerModel, "markerModel");
        Intrinsics.checkParameterIsNotNull(list, "markerTemplateIds");
        getLoading().postValue(true);
        launchIO(new MarkerViewModel$getAllData$1(this, list, markerModel, (Continuation) null));
        getLoading().postValue(false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ Object getMarker(MarkerModel r5, Continuation<? super kotlin.Unit> r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.marker.MarkerViewModel.getMarker(kz.sapasoft.emark.app.domain.model.MarkerModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void getTemplateList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String findById : list) {
            arrayList.addAll(this.templateRepository.findById(findById));
        }
        getTemplateModelData().postValue(arrayList);
    }

    /* access modifiers changed from: private */
    public final void getTagList() {
        getTagModelData().postValue(this.tagRepository.findAll());
    }

    public final void saveMarkerAndImage(MarkerModel markerModel, List<ImageDataModel> list) {
        Intrinsics.checkParameterIsNotNull(markerModel, "markerModel");
        Intrinsics.checkParameterIsNotNull(list, "imageDataModelList");
        launchIO(new MarkerViewModel$saveMarkerAndImage$1(this, markerModel, list, (Continuation) null));
    }

    public final void deleteLocal(MarkerModel markerModel) {
        Intrinsics.checkParameterIsNotNull(markerModel, "markerModel");
        launchIO(new MarkerViewModel$deleteLocal$1(this, markerModel, (Continuation) null));
    }

    private final void getImages(MarkerModel markerModel) {
        launchIO(new MarkerViewModel$getImages$1(this, markerModel, (Continuation) null));
    }
}

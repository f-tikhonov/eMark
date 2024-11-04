package kz.sapasoft.emark.app.data.cloud.repository;

import androidx.room.RoomDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kz.sapasoft.emark.app.data.cloud.ResponseHandlerKt;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;
import kz.sapasoft.emark.app.data.cloud.rest.ApiService;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.sapasoft.emark.app.domain.model.MarkerModelNullable;
import kz.sapasoft.emark.app.domain.model.ProjectModel;
import kz.sapasoft.emark.app.domain.model.TagModel;
import kz.sapasoft.emark.app.domain.model.TemplateModel;
import kz.sapasoft.emark.app.domain.model.request.GetMarkersRequest;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ%\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\b2\u0006\u0010\u0010\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0012\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ3\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\b2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000e0\b2\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000e0\b2\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ+\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000e0\b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010 J/\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\b2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010&J'\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H@ø\u0001\u0000¢\u0006\u0002\u0010*J\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010.R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lkz/sapasoft/emark/app/data/cloud/repository/CloudRepository;", "Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;", "apIs", "Lkz/sapasoft/emark/app/data/cloud/rest/ApiService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkz/sapasoft/emark/app/data/cloud/rest/ApiService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getImage", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper;", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "queryKey", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageData", "", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "parentId", "getMarker", "id", "getMarkerList", "page", "", "projectIds", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProjectList", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTagList", "Lkz/sapasoft/emark/app/domain/model/TagModel;", "getTemplateList", "Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "ids", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lokhttp3/ResponseBody;", "url", "username", "password", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveImage", "file", "Lokhttp3/MultipartBody$Part;", "(Ljava/lang/String;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveMarker", "markerModel", "Lkz/sapasoft/emark/app/domain/model/MarkerModelNullable;", "(Lkz/sapasoft/emark/app/domain/model/MarkerModelNullable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CloudRepository.kt */
public final class CloudRepository implements BaseCloudRepository {
    /* access modifiers changed from: private */
    public final ApiService apIs;
    private final CoroutineDispatcher dispatcher;

    public CloudRepository(ApiService apiService, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkParameterIsNotNull(apiService, "apIs");
        Intrinsics.checkParameterIsNotNull(coroutineDispatcher, "dispatcher");
        this.apIs = apiService;
        this.dispatcher = coroutineDispatcher;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CloudRepository(ApiService apiService, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(apiService, (i & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public Object login(String str, String str2, String str3, Continuation<? super ResultWrapper<? extends ResponseBody>> continuation) {
        return ResponseHandlerKt.safeApiCall(this.dispatcher, new CloudRepository$login$2(this, str, str2, str3, (Continuation) null), continuation);
    }

    public Object getProjectList(int i, Continuation<? super ResultWrapper<? extends List<ProjectModel>>> continuation) {
        return ResponseHandlerKt.safeApiCall(this.dispatcher, new CloudRepository$getProjectList$2(this, i, (Continuation) null), continuation);
    }

    public Object getTagList(int i, Continuation<? super ResultWrapper<? extends List<TagModel>>> continuation) {
        return ResponseHandlerKt.safeApiCall(this.dispatcher, new CloudRepository$getTagList$2(this, i, (Continuation) null), continuation);
    }

    public Object getTemplateList(List<String> list, Continuation<? super ResultWrapper<? extends List<TemplateModel>>> continuation) {
        return ResponseHandlerKt.safeApiCall(this.dispatcher, new CloudRepository$getTemplateList$2(this, list, (Continuation) null), continuation);
    }

    public Object getMarkerList(int i, List<String> list, Continuation<? super ResultWrapper<? extends List<MarkerModel>>> continuation) {
        return ResponseHandlerKt.safeApiCall(this.dispatcher, new CloudRepository$getMarkerList$2(this, new GetMarkersRequest((i - 1) * RoomDatabase.MAX_BIND_PARAMETER_CNT, RoomDatabase.MAX_BIND_PARAMETER_CNT, "VIEW_MarkerEntity", list, CollectionsKt.emptyList()), (Continuation) null), continuation);
    }

    public Object getMarker(String str, Continuation<? super ResultWrapper<MarkerModel>> continuation) {
        return ResponseHandlerKt.safeApiCall(this.dispatcher, new CloudRepository$getMarker$2(this, str, (Continuation) null), continuation);
    }

    public Object saveMarker(MarkerModelNullable markerModelNullable, Continuation<? super ResultWrapper<MarkerModel>> continuation) {
        return ResponseHandlerKt.safeApiCall(this.dispatcher, new CloudRepository$saveMarker$2(this, markerModelNullable, (Continuation) null), continuation);
    }

    public Object saveImage(String str, MultipartBody.Part part, Continuation<? super ResultWrapper<MarkerModel>> continuation) {
        return ResponseHandlerKt.safeApiCall(this.dispatcher, new CloudRepository$saveImage$2(this, str, part, (Continuation) null), continuation);
    }

    public Object getImageData(String str, Continuation<? super ResultWrapper<? extends List<ImageDataModel>>> continuation) {
        return ResponseHandlerKt.safeApiCall(this.dispatcher, new CloudRepository$getImageData$2(this, str, (Continuation) null), continuation);
    }

    public Object getImage(String str, Continuation<? super ResultWrapper<MarkerModel>> continuation) {
        return ResponseHandlerKt.safeApiCall(this.dispatcher, new CloudRepository$getImage$2(this, str, (Continuation) null), continuation);
    }
}

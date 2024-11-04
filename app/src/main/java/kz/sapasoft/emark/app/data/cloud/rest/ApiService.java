package kz.sapasoft.emark.app.data.cloud.rest;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.sapasoft.emark.app.domain.model.MarkerModelNullable;
import kz.sapasoft.emark.app.domain.model.ProjectModel;
import kz.sapasoft.emark.app.domain.model.TagModel;
import kz.sapasoft.emark.app.domain.model.TemplateModel;
import kz.sapasoft.emark.app.domain.model.request.GetMarkersRequest;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ5\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0001\u0010\u000f\u001a\u00020\n2\b\b\u0001\u0010\u0010\u001a\u00020\n2\b\b\u0001\u0010\u0011\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00032\b\b\u0001\u0010\u0014\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0001\u0010\u0017\u001a\u00020\u0018H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0019JI\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\r2\b\b\u0001\u0010\u001c\u001a\u00020\n2\b\b\u0001\u0010\u001d\u001a\u00020\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u00072\b\b\u0001\u0010\u001f\u001a\u00020\u00052\b\b\u0001\u0010 \u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010!J5\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\r2\b\b\u0001\u0010\u001c\u001a\u00020\n2\b\b\u0001\u0010\u001d\u001a\u00020\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010$J'\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\r2\u000e\b\u0001\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\rH§@ø\u0001\u0000¢\u0006\u0002\u0010(J/\u0010)\u001a\u00020*2\b\b\u0001\u0010+\u001a\u00020\n2\b\b\u0001\u0010,\u001a\u00020\n2\b\b\u0001\u0010-\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012JM\u0010.\u001a\u00020\u00032\b\b\u0001\u0010/\u001a\u00020\n2\b\b\u0001\u00100\u001a\u00020\n2\b\b\u0001\u00101\u001a\u00020\n2\b\b\u0001\u0010\u0010\u001a\u00020\n2\b\b\u0001\u0010\u0011\u001a\u00020\n2\b\b\u0001\u00102\u001a\u000203H§@ø\u0001\u0000¢\u0006\u0002\u00104J\u001b\u00105\u001a\u00020\u00032\b\b\u0001\u00106\u001a\u000207H§@ø\u0001\u0000¢\u0006\u0002\u00108\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lkz/sapasoft/emark/app/data/cloud/rest/ApiService;", "", "getImage", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "useHints", "", "width", "", "height", "queryKey", "", "(ZIILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageData", "", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "privelege", "parentType", "parentId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMarker", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMarkerList", "request", "Lkz/sapasoft/emark/app/domain/model/request/GetMarkersRequest;", "(Lkz/sapasoft/emark/app/domain/model/request/GetMarkersRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProjectList", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "namePart", "offset", "limit", "light", "calculatePermissions", "(Ljava/lang/String;IIZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTagList", "Lkz/sapasoft/emark/app/domain/model/TagModel;", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTemplateList", "Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "ids", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lokhttp3/ResponseBody;", "url", "username", "password", "saveImage", "name", "descr", "contentType", "file", "Lokhttp3/MultipartBody$Part;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveMarker", "markerModel", "Lkz/sapasoft/emark/app/domain/model/MarkerModelNullable;", "(Lkz/sapasoft/emark/app/domain/model/MarkerModelNullable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ApiService.kt */
public interface ApiService {
    @GET("data/getByParent")
    Object getImage(@Query("useHints") boolean z, @Query("width") int i, @Query("height") int i2, @Query("queryKey") String str, Continuation<? super MarkerModel> continuation);

    @POST("data/getByParent")
    Object getImageData(@Query("privelege") String str, @Query("parentType") String str2, @Query("parentId") String str3, Continuation<? super List<ImageDataModel>> continuation);

    @POST("marker/getById")
    Object getMarker(@Query("id") String str, Continuation<? super MarkerModel> continuation);

    @POST("marker/getList")
    Object getMarkerList(@Body GetMarkersRequest getMarkersRequest, Continuation<? super List<MarkerModel>> continuation);

    @POST("project/getByNamePart")
    Object getProjectList(@Query("namePart") String str, @Query("offset") int i, @Query("limit") int i2, @Query("light") boolean z, @Query("calculatePermissions") boolean z2, Continuation<? super List<ProjectModel>> continuation);

    @POST("tag/getByNamePart")
    Object getTagList(@Query("namePart") String str, @Query("offset") int i, @Query("limit") int i2, Continuation<? super List<TagModel>> continuation);

    @POST("markerTemplate/getByIds")
    Object getTemplateList(@Query("ids") List<String> list, Continuation<? super List<TemplateModel>> continuation);

    @POST
    Object login(@Url String str, @Query("username") String str2, @Query("password") String str3, Continuation<? super ResponseBody> continuation);

    @PUT("data/save")
    @Multipart
    Object saveImage(@Query("name") String str, @Query("descr") String str2, @Query("contentType") String str3, @Query("parentType") String str4, @Query("parentId") String str5, @Part MultipartBody.Part part, Continuation<? super MarkerModel> continuation);

    @PUT("marker/save")
    Object saveMarker(@Body MarkerModelNullable markerModelNullable, Continuation<? super MarkerModel> continuation);
}

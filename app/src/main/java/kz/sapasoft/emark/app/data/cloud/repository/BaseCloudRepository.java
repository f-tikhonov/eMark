package kz.sapasoft.emark.app.data.cloud.repository;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.sapasoft.emark.app.domain.model.MarkerModelNullable;
import kz.sapasoft.emark.app.domain.model.ProjectModel;
import kz.sapasoft.emark.app.domain.model.TagModel;
import kz.sapasoft.emark.app.domain.model.TemplateModel;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J%\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00032\u0006\u0010\u000b\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J3\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u00032\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J%\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\u00032\u0006\u0010\u000f\u001a\u00020\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\t0\u00032\u0006\u0010\u000f\u001a\u00020\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J+\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\t0\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ/\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010!J'\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H¦@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010'\u001a\u00020(H¦@ø\u0001\u0000¢\u0006\u0002\u0010)\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;", "", "getImage", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper;", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "queryKey", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageData", "", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "parentId", "getMarker", "id", "getMarkerList", "page", "", "projectIds", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProjectList", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTagList", "Lkz/sapasoft/emark/app/domain/model/TagModel;", "getTemplateList", "Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "ids", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lokhttp3/ResponseBody;", "url", "username", "password", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveImage", "file", "Lokhttp3/MultipartBody$Part;", "(Ljava/lang/String;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveMarker", "markerModel", "Lkz/sapasoft/emark/app/domain/model/MarkerModelNullable;", "(Lkz/sapasoft/emark/app/domain/model/MarkerModelNullable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseCloudRepository.kt */
public interface BaseCloudRepository {
    Object getImage(String str, Continuation<? super ResultWrapper<MarkerModel>> continuation);

    Object getImageData(String str, Continuation<? super ResultWrapper<? extends List<ImageDataModel>>> continuation);

    Object getMarker(String str, Continuation<? super ResultWrapper<MarkerModel>> continuation);

    Object getMarkerList(int i, List<String> list, Continuation<? super ResultWrapper<? extends List<MarkerModel>>> continuation);

    Object getProjectList(int i, Continuation<? super ResultWrapper<? extends List<ProjectModel>>> continuation);

    Object getTagList(int i, Continuation<? super ResultWrapper<? extends List<TagModel>>> continuation);

    Object getTemplateList(List<String> list, Continuation<? super ResultWrapper<? extends List<TemplateModel>>> continuation);

    Object login(String str, String str2, String str3, Continuation<? super ResultWrapper<? extends ResponseBody>> continuation);

    Object saveImage(String str, MultipartBody.Part part, Continuation<? super ResultWrapper<MarkerModel>> continuation);

    Object saveMarker(MarkerModelNullable markerModelNullable, Continuation<? super ResultWrapper<MarkerModel>> continuation);
}

package kz.sapasoft.emark.app.data.local.room.image;

import java.util.List;
import kotlin.Metadata;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lkz/sapasoft/emark/app/data/local/room/image/ImageRepository;", "", "addAll", "", "imageDataModelList", "", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "deleteByLocalIdParent", "localIdParent", "", "getByLocalIdParent", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ImageRepository.kt */
public interface ImageRepository {
    void addAll(List<ImageDataModel> list);

    void deleteByLocalIdParent(String str);

    List<ImageDataModel> getByLocalIdParent(String str);
}

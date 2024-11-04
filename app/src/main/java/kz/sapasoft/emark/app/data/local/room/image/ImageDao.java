package kz.sapasoft.emark.app.data.local.room.image;

import java.util.List;
import kotlin.Metadata;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'¨\u0006\u000b"}, d2 = {"Lkz/sapasoft/emark/app/data/local/room/image/ImageDao;", "", "deleteByLocalIdParent", "", "localIdParent", "", "findByLocalIdParent", "", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "insertWithReplace", "imageDataModelList", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ImageDao.kt */
public interface ImageDao {
    void deleteByLocalIdParent(String str);

    List<ImageDataModel> findByLocalIdParent(String str);

    void insertWithReplace(List<ImageDataModel> list);
}

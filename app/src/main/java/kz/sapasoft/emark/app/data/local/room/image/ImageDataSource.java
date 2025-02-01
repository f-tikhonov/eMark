package kz.sapasoft.emark.app.data.local.room.image;

import android.util.Log;

import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkz/sapasoft/emark/app/data/local/room/image/ImageDataSource;", "Lkz/sapasoft/emark/app/data/local/room/image/ImageRepository;", "imageDao", "Lkz/sapasoft/emark/app/data/local/room/image/ImageDao;", "(Lkz/sapasoft/emark/app/data/local/room/image/ImageDao;)V", "addAll", "", "imageDataModelList", "", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "deleteByLocalIdParent", "localIdParent", "", "getByLocalIdParent", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ImageDataSource.kt */
public final class ImageDataSource implements ImageRepository {
    private final ImageDao imageDao;

    @Inject
    public ImageDataSource(ImageDao imageDao2) {
        Intrinsics.checkParameterIsNotNull(imageDao2, "imageDao");
        this.imageDao = imageDao2;
    }

    public void addAll(List<ImageDataModel> list) {
        Intrinsics.checkParameterIsNotNull(list, "imageDataModelList");
        this.imageDao.insertWithReplace(list);
    }

    public List<ImageDataModel> getByLocalIdParent(String str) {
        Intrinsics.checkParameterIsNotNull(str, "localIdParent");
        return this.imageDao.findByLocalIdParent(str);
    }

    public void deleteByLocalIdParent(String str) {
        Intrinsics.checkParameterIsNotNull(str, "localIdParent");
        this.imageDao.deleteByLocalIdParent(str);
    }
}

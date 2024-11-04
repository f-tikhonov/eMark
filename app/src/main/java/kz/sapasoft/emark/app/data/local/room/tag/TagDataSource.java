package kz.sapasoft.emark.app.data.local.room.tag;

import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.domain.model.TagModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkz/sapasoft/emark/app/data/local/room/tag/TagDataSource;", "Lkz/sapasoft/emark/app/data/local/room/tag/TagRepository;", "tagDao", "Lkz/sapasoft/emark/app/data/local/room/tag/TagDao;", "(Lkz/sapasoft/emark/app/data/local/room/tag/TagDao;)V", "addTagList", "", "tagModelList", "", "Lkz/sapasoft/emark/app/domain/model/TagModel;", "deleteAll", "findAll", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: TagDataSource.kt */
public final class TagDataSource implements TagRepository {
    private final TagDao tagDao;

    @Inject
    public TagDataSource(TagDao tagDao2) {
        Intrinsics.checkParameterIsNotNull(tagDao2, "tagDao");
        this.tagDao = tagDao2;
    }

    public void addTagList(List<TagModel> list) {
        Intrinsics.checkParameterIsNotNull(list, "tagModelList");
        this.tagDao.insert(list);
    }

    public List<TagModel> findAll() {
        return this.tagDao.findAll();
    }

    public void deleteAll() {
        this.tagDao.deleteAll();
    }
}

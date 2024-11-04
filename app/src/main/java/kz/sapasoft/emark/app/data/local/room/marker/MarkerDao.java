package kz.sapasoft.emark.app.data.local.room.marker;

import java.util.List;
import kotlin.Metadata;
import kz.sapasoft.emark.app.domain.model.MarkerModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH'J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0016\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bH'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\tH'¨\u0006\u0011"}, d2 = {"Lkz/sapasoft/emark/app/data/local/room/marker/MarkerDao;", "", "deleteAll", "", "deleteByProjectId", "projectId", "", "findAll", "", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "limit", "", "offset", "findByProjectId", "insertWithReplace", "markerModelList", "markerModel", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MarkerDao.kt */
public interface MarkerDao {
    void deleteAll();

    void deleteByProjectId(String str);

    List<MarkerModel> findAll(int i, int i2);

    List<MarkerModel> findByProjectId(String str);

    void insertWithReplace(List<MarkerModel> list);

    void insertWithReplace(MarkerModel markerModel);
}

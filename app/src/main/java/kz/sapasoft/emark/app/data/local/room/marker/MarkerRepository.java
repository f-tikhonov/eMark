package kz.sapasoft.emark.app.data.local.room.marker;

import java.util.List;
import kotlin.Metadata;
import kz.sapasoft.emark.app.domain.model.MarkerModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0010"}, d2 = {"Lkz/sapasoft/emark/app/data/local/room/marker/MarkerRepository;", "", "addWithReplace", "", "markerModelList", "", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "markerModel", "deleteAll", "deleteByProjectId", "projectId", "", "findAll", "page", "", "findByProjectId", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MarkerRepository.kt */
public interface MarkerRepository {
    void addWithReplace(List<MarkerModel> list);

    void addWithReplace(MarkerModel markerModel);

    void deleteAll();

    void deleteByProjectId(String str);

    List<MarkerModel> findAll(int i);

    List<MarkerModel> findByProjectId(String str);
}

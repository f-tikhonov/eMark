package kz.sapasoft.emark.app.data.local.room.template;

import java.util.List;
import kotlin.Metadata;
import kz.sapasoft.emark.app.domain.model.TemplateModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH'J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'¨\u0006\u000b"}, d2 = {"Lkz/sapasoft/emark/app/data/local/room/template/TemplateDao;", "", "deleteAll", "", "findById", "", "Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "templateId", "", "insert", "templateModelList", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: TemplateDao.kt */
public interface TemplateDao {
    void deleteAll();

    List<TemplateModel> findById(String str);

    void insert(List<TemplateModel> list);
}

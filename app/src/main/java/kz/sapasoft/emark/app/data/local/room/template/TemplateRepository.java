package kz.sapasoft.emark.app.data.local.room.template;

import java.util.List;
import kotlin.Metadata;
import kz.sapasoft.emark.app.domain.model.TemplateModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lkz/sapasoft/emark/app/data/local/room/template/TemplateRepository;", "", "addWithReplace", "", "templateModelList", "", "Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "deleteAll", "findById", "templateId", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: TemplateRepository.kt */
public interface TemplateRepository {
    void addWithReplace(List<TemplateModel> list);

    void deleteAll();

    List<TemplateModel> findById(String str);
}

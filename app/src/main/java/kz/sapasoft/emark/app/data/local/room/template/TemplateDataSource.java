package kz.sapasoft.emark.app.data.local.room.template;

import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.domain.model.TemplateModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkz/sapasoft/emark/app/data/local/room/template/TemplateDataSource;", "Lkz/sapasoft/emark/app/data/local/room/template/TemplateRepository;", "templateDao", "Lkz/sapasoft/emark/app/data/local/room/template/TemplateDao;", "(Lkz/sapasoft/emark/app/data/local/room/template/TemplateDao;)V", "addWithReplace", "", "templateModelList", "", "Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "deleteAll", "findById", "templateId", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: TemplateDataSource.kt */
public final class TemplateDataSource implements TemplateRepository {
    private final TemplateDao templateDao;

    @Inject
    public TemplateDataSource(TemplateDao templateDao2) {
        Intrinsics.checkParameterIsNotNull(templateDao2, "templateDao");
        this.templateDao = templateDao2;
    }

    public void addWithReplace(List<TemplateModel> list) {
        Intrinsics.checkParameterIsNotNull(list, "templateModelList");
        this.templateDao.insert(list);
    }

    public List<TemplateModel> findById(String str) {
        Intrinsics.checkParameterIsNotNull(str, "templateId");
        return this.templateDao.findById(str);
    }

    public void deleteAll() {
        this.templateDao.deleteAll();
    }
}

package kz.sapasoft.emark.app.ui.marker;

import androidx.lifecycle.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.domain.model.FieldModel;
import kz.sapasoft.emark.app.domain.model.TemplateModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "", "Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "kotlin.jvm.PlatformType", "onChanged", "kz/sapasoft/emark/app/ui/marker/MarkerFragment$setObservers$1$8"}, k = 3, mv = {1, 1, 16})
/* compiled from: MarkerFragment.kt */
final class MarkerFragment$setObservers$$inlined$with$lambda$8<T> implements Observer<List<? extends TemplateModel>> {
    final /* synthetic */ MarkerFragment this$0;

    MarkerFragment$setObservers$$inlined$with$lambda$8(MarkerFragment markerFragment) {
        this.this$0 = markerFragment;
    }

    public final void onChanged(List<TemplateModel> list) {
        Object obj;
        List<FieldModel> list2;
        MarkerFragment markerFragment = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(list, "it");
        markerFragment.mTemplateList = list;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((TemplateModel) obj).getId(), (Object) MarkerFragment.access$getMMarkerModel$p(this.this$0).getTemplateId())) {
                break;
            }
        }
        TemplateModel templateModel = (TemplateModel) obj;
        this.this$0.drawMainList(list);
        MarkerFragment markerFragment2 = this.this$0;
        if (templateModel == null || (list2 = templateModel.getFields()) == null) {
            list2 = list.get(0).getFields();
        }
        markerFragment2.drawFieldList(list2);
    }
}

package kz.sapasoft.emark.app.ui.custom_views;

import android.view.View;
import android.widget.AdapterView;
import java.util.List;
import kotlin.Metadata;
import kz.sapasoft.emark.app.domain.model.TemplateModel;
import kz.sapasoft.emark.app.ui.marker.OnMarkerTypeChangeListener;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¨\u0006\r"}, d2 = {"kz/sapasoft/emark/app/ui/custom_views/MarkerTypeView$setData$2", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "p0", "Landroid/widget/AdapterView;", "p1", "Landroid/view/View;", "p2", "", "p3", "", "onNothingSelected", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MarkerTypeView.kt */
public final class MarkerTypeView$setData$2 implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ OnMarkerTypeChangeListener $listener;
    final /* synthetic */ List $templateList;

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    MarkerTypeView$setData$2(OnMarkerTypeChangeListener onMarkerTypeChangeListener, List list) {
        this.$listener = onMarkerTypeChangeListener;
        this.$templateList = list;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.$listener.onMarkerTypeChange((TemplateModel) this.$templateList.get(i));
    }
}

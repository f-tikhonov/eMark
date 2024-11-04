package kz.sapasoft.emark.app.ui.marker;

import android.view.View;
import kotlin.Metadata;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.sapasoft.emark.app.utils.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: MarkerFragment.kt */
final class MarkerFragment$setListeners$1 implements View.OnClickListener {
    final /* synthetic */ MarkerFragment this$0;

    MarkerFragment$setListeners$1(MarkerFragment markerFragment) {
        this.this$0 = markerFragment;
    }

    public final void onClick(View view) {
        MarkerModel access$constructNewMarkerModel = this.this$0.constructNewMarkerModel();
        if (access$constructNewMarkerModel.getStatus() == null) {
            access$constructNewMarkerModel.setStatus(Constants.MarkerStatus.EDITED);
        }
        this.this$0.getViewModel().saveMarkerAndImage(access$constructNewMarkerModel, this.this$0.constructImageDataModel());
    }
}

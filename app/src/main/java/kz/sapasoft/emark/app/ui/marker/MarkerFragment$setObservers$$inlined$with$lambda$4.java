package kz.sapasoft.emark.app.ui.marker;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.R;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Error;", "kotlin.jvm.PlatformType", "onChanged", "kz/sapasoft/emark/app/ui/marker/MarkerFragment$setObservers$1$4"}, k = 3, mv = {1, 1, 16})
/* compiled from: MarkerFragment.kt */
final class MarkerFragment$setObservers$$inlined$with$lambda$4<T> implements Observer<ResultWrapper.Error> {
    final /* synthetic */ MarkerFragment this$0;

    MarkerFragment$setObservers$$inlined$with$lambda$4(MarkerFragment markerFragment) {
        this.this$0 = markerFragment;
    }

    public final void onChanged(ResultWrapper.Error error) {
        ScrollView scrollView = (ScrollView) this.this$0._$_findCachedViewById(R.id.sv_main);
        Intrinsics.checkExpressionValueIsNotNull(scrollView, "sv_main");
        scrollView.setVisibility(0);
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(R.id.pb_main);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "pb_main");
        progressBar.setVisibility(8);
        Snackbar.make((View) (Toolbar) this.this$0._$_findCachedViewById(R.id.toolbar), (CharSequence) String.valueOf(error != null ? error.getError() : null), 0).show();
    }
}

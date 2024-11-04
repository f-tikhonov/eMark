package kz.sapasoft.emark.app.ui.welcome;

import android.view.View;
import androidx.lifecycle.Observer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kz.sapasoft.emark.app.R;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Error;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
/* compiled from: WelcomeActivity.kt */
final class WelcomeActivity$setObservers$3<T> implements Observer<ResultWrapper.Error> {
    final /* synthetic */ WelcomeActivity this$0;

    WelcomeActivity$setObservers$3(WelcomeActivity welcomeActivity) {
        this.this$0 = welcomeActivity;
    }

    public final void onChanged(ResultWrapper.Error error) {
        MaterialButton materialButton = (MaterialButton) this.this$0._$_findCachedViewById(R.id.btn_start);
        String error2 = error.getError();
        if (error2 == null) {
            error2 = this.this$0.getString(kz.ss.emark.R.string.error);
        }
        Snackbar.make((View) materialButton, (CharSequence) error2, 0).show();
    }
}

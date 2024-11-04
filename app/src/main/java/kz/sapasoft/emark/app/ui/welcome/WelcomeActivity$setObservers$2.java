package kz.sapasoft.emark.app.ui.welcome;

import android.content.Intent;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kz.sapasoft.emark.app.ui.MainActivity;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 16})
/* compiled from: WelcomeActivity.kt */
final class WelcomeActivity$setObservers$2<T> implements Observer<Boolean> {
    final /* synthetic */ WelcomeActivity this$0;

    WelcomeActivity$setObservers$2(WelcomeActivity welcomeActivity) {
        this.this$0 = welcomeActivity;
    }

    public final void onChanged(Boolean bool) {
        this.this$0.startActivity(new Intent(this.this$0, MainActivity.class));
        this.this$0.finish();
    }
}

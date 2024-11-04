package kz.sapasoft.emark.app.utils;

import android.content.res.Resources;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\f"}, d2 = {"Lkz/sapasoft/emark/app/utils/Utils;", "", "()V", "dpToPx", "", "dp", "hideKeyboard", "", "view", "Landroid/view/View;", "pxToDp", "px", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Utils.kt */
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    public final float dpToPx(float f) {
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        return f * (((float) system.getDisplayMetrics().densityDpi) / ((float) Opcodes.IF_ICMPNE));
    }

    public final float pxToDp(float f) {
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        return f / (((float) system.getDisplayMetrics().densityDpi) / ((float) Opcodes.IF_ICMPNE));
    }

    public final void hideKeyboard(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(view.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}

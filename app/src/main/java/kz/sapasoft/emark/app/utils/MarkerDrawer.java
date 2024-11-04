package kz.sapasoft.emark.app.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lkz/sapasoft/emark/app/utils/MarkerDrawer;", "", "()V", "darkenColor", "", "color", "factor", "", "makeCircle", "Landroid/graphics/drawable/Drawable;", "sizeDp", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MarkerDrawer.kt */
public final class MarkerDrawer {
    public static final MarkerDrawer INSTANCE = new MarkerDrawer();

    private MarkerDrawer() {
    }

    public final Drawable makeCircle(int i, float f) {
        float dpToPx = Utils.INSTANCE.dpToPx(f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setAlpha(100);
        gradientDrawable.setShape(1);
        gradientDrawable.setStroke((int) Utils.INSTANCE.dpToPx(4.0f), darkenColor(i, 0.8f));
        int i2 = (int) dpToPx;
        gradientDrawable.setSize(i2, i2);
        gradientDrawable.setGradientType(1);
        return gradientDrawable;
    }

    private final int darkenColor(int i, float f) {
        return Color.argb(Color.alpha(i), Math.min(MathKt.roundToInt(((float) Color.red(i)) * f), 255), Math.min(MathKt.roundToInt(((float) Color.green(i)) * f), 255), Math.min(MathKt.roundToInt(((float) Color.blue(i)) * f), 255));
    }
}

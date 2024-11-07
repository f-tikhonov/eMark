package kz.sapasoft.emark.app.ui.custom_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kz.sapasoft.emark.app.ui.marker.OnFieldValueChangeListener;
import kz.ss.emark.R;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u000fJ\r\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u001d\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001cR\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001d"}, d2 = {"Lkz/sapasoft/emark/app/ui/custom_views/MarkerDepthView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mValue", "", "Ljava/lang/Double;", "doubleToString", "", "double", "(Ljava/lang/Double;)Ljava/lang/String;", "getValue", "()Ljava/lang/Double;", "hasValue", "", "setData", "", "value", "listener", "Lkz/sapasoft/emark/app/ui/marker/OnFieldValueChangeListener;", "(Ljava/lang/Double;Lkz/sapasoft/emark/app/ui/marker/OnFieldValueChangeListener;)V", "stringToDouble", "string", "(Ljava/lang/String;)Ljava/lang/Double;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MarkerDepthView.kt */
public final class MarkerDepthView extends LinearLayout {
    private HashMap _$_findViewCache;
    private Double mValue;

    public MarkerDepthView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public MarkerDepthView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MarkerDepthView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkerDepthView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (layoutInflater != null) {
            layoutInflater.inflate(R.layout.view_marker_depth, this);
        }
    }

    public final void setData(Double d, OnFieldValueChangeListener onFieldValueChangeListener) {
        Intrinsics.checkParameterIsNotNull(onFieldValueChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mValue = d;
        ((EditText) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.et_text)).setText(doubleToString(d));
        EditText editText = (EditText) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.et_text);
        Intrinsics.checkExpressionValueIsNotNull(editText, "et_text");
        editText.addTextChangedListener(new MarkerDepthView$setData$$inlined$addTextChangedListener$1(onFieldValueChangeListener));
    }

    public final Double getValue() {
        EditText editText = (EditText) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.et_text);
        Intrinsics.checkExpressionValueIsNotNull(editText, "et_text");
        return stringToDouble(editText.getText().toString());
    }

    public final boolean hasValue() {
        EditText editText = (EditText) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.et_text);
        Intrinsics.checkExpressionValueIsNotNull(editText, "et_text");
        CharSequence text = editText.getText();
        return !(text == null || text.length() == 0);
    }

    private final Double stringToDouble(String str) {
        if (str.length() == 0) {
            return null;
        }
        return StringsKt.toDoubleOrNull(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r3 = java.lang.String.valueOf(r3.doubleValue());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final String doubleToString(Double r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x000d
            double r0 = r3.doubleValue()
            java.lang.String r3 = java.lang.String.valueOf(r0)
            if (r3 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            java.lang.String r3 = ""
        L_0x000f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.custom_views.MarkerDepthView.doubleToString(java.lang.Double):java.lang.String");
    }
}

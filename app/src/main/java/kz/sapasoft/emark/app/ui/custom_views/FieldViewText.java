package kz.sapasoft.emark.app.ui.custom_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.R;
import kz.sapasoft.emark.app.domain.model.FieldModel;
import kz.sapasoft.emark.app.domain.model.TagModel;
import kz.sapasoft.emark.app.ui.marker.OnFieldValueChangeListener;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkz/sapasoft/emark/app/ui/custom_views/FieldViewText;", "Lkz/sapasoft/emark/app/ui/custom_views/FieldView;", "context", "Landroid/content/Context;", "field", "Lkz/sapasoft/emark/app/domain/model/FieldModel;", "listener", "Lkz/sapasoft/emark/app/ui/marker/OnFieldValueChangeListener;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Lkz/sapasoft/emark/app/domain/model/FieldModel;Lkz/sapasoft/emark/app/ui/marker/OnFieldValueChangeListener;Landroid/util/AttributeSet;I)V", "mField", "getFieldModel", "hasValue", "", "isRequired", "setFieldModel", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FieldViewText.kt */
public final class FieldViewText extends FieldView {
    private HashMap _$_findViewCache;
    private FieldModel mField;

    public FieldViewText(Context context, FieldModel fieldModel, OnFieldValueChangeListener onFieldValueChangeListener) {
        this(context, fieldModel, onFieldValueChangeListener, (AttributeSet) null, 0, 24, (DefaultConstructorMarker) null);
    }

    public FieldViewText(Context context, FieldModel fieldModel, OnFieldValueChangeListener onFieldValueChangeListener, AttributeSet attributeSet) {
        this(context, fieldModel, onFieldValueChangeListener, attributeSet, 0, 16, (DefaultConstructorMarker) null);
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
    public /* synthetic */ FieldViewText(Context context, FieldModel fieldModel, OnFieldValueChangeListener onFieldValueChangeListener, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, fieldModel, onFieldValueChangeListener, (i2 & 8) != 0 ? null : attributeSet, (i2 & 16) != 0 ? 0 : i);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FieldViewText(Context r28, FieldModel r29, OnFieldValueChangeListener r30, AttributeSet r31, int r32) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r30
            java.lang.String r3 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r3)
            java.lang.String r3 = "field"
            r4 = r29
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r3)
            java.lang.String r3 = "listener"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r3)
            r3 = r31
            r5 = r32
            r0.<init>(r1, r3, r5)
            java.lang.String r3 = "layout_inflater"
            java.lang.Object r1 = r1.getSystemService(r3)
            android.view.LayoutInflater r1 = (android.view.LayoutInflater) r1
            if (r1 == 0) goto L_0x0031
            r3 = 2131558531(0x7f0d0083, float:1.874238E38)
            r5 = r0
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            r1.inflate(r3, r5)
        L_0x0031:
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r26 = 0
            r4 = r29
            kz.sapasoft.emark.app.domain.model.FieldModel r1 = kz.sapasoft.emark.app.domain.model.FieldModel.copy$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r0.mField = r1
            int r1 = kz.sapasoft.emark.app.R.id.tv_title
            android.view.View r1 = r0._$_findCachedViewById(r1)
            com.google.android.material.textview.MaterialTextView r1 = (com.google.android.material.textview.MaterialTextView) r1
            java.lang.String r3 = "tv_title"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            java.lang.String r3 = r29.getName()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            int r1 = kz.sapasoft.emark.app.R.id.et_text
            android.view.View r1 = r0._$_findCachedViewById(r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            java.lang.String r3 = r29.getTextValue()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            int r1 = kz.sapasoft.emark.app.R.id.et_text
            android.view.View r1 = r0._$_findCachedViewById(r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            java.lang.String r3 = "et_text"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kz.sapasoft.emark.app.ui.custom_views.FieldViewText$$special$$inlined$addTextChangedListener$1 r3 = new kz.sapasoft.emark.app.ui.custom_views.FieldViewText$$special$$inlined$addTextChangedListener$1
            r3.<init>(r2)
            android.text.TextWatcher r3 = (android.text.TextWatcher) r3
            r1.addTextChangedListener(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.custom_views.FieldViewText.<init>(android.content.Context, kz.sapasoft.emark.app.domain.model.FieldModel, kz.sapasoft.emark.app.ui.marker.OnFieldValueChangeListener, android.util.AttributeSet, int):void");
    }

    public FieldModel getFieldModel() {
        FieldModel fieldModel = this.mField;
        EditText editText = (EditText) _$_findCachedViewById(R.id.et_text);
        Intrinsics.checkExpressionValueIsNotNull(editText, "et_text");
        fieldModel.setTextValue(editText.getText().toString());
        return this.mField;
    }

    public void setFieldModel(FieldModel fieldModel) {
        Intrinsics.checkParameterIsNotNull(fieldModel, "field");
        this.mField = FieldModel.copy$default(fieldModel, (String) null, (Long) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (Long) null, (Double) null, (String) null, (String) null, (TagModel) null, (Long) null, 1048575, (Object) null);
        ((EditText) _$_findCachedViewById(R.id.et_text)).setText(fieldModel.getTextValue());
    }

    public boolean isRequired() {
        Boolean required = this.mField.getRequired();
        if (required != null) {
            return required.booleanValue();
        }
        return false;
    }

    public boolean hasValue() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.et_text);
        Intrinsics.checkExpressionValueIsNotNull(editText, "et_text");
        CharSequence text = editText.getText();
        return !(text == null || text.length() == 0);
    }
}

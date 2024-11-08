package kz.sapasoft.emark.app.ui.custom_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Spinner;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.R;
import kz.sapasoft.emark.app.domain.model.FieldModel;
import kz.sapasoft.emark.app.domain.model.TagModel;
import kz.sapasoft.emark.app.ui.marker.OnFieldValueChangeListener;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkz/sapasoft/emark/app/ui/custom_views/FieldViewSpinner;", "Lkz/sapasoft/emark/app/ui/custom_views/FieldView;", "context", "Landroid/content/Context;", "field", "Lkz/sapasoft/emark/app/domain/model/FieldModel;", "tagList", "", "Lkz/sapasoft/emark/app/domain/model/TagModel;", "listener", "Lkz/sapasoft/emark/app/ui/marker/OnFieldValueChangeListener;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Lkz/sapasoft/emark/app/domain/model/FieldModel;Ljava/util/List;Lkz/sapasoft/emark/app/ui/marker/OnFieldValueChangeListener;Landroid/util/AttributeSet;I)V", "mField", "mTagList", "getFieldModel", "hasValue", "", "isRequired", "setFieldModel", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FieldViewSpinner.kt */
public final class FieldViewSpinner extends FieldView {
    private HashMap _$_findViewCache;
    private FieldModel mField;
    private List<TagModel> mTagList;

    public FieldViewSpinner(Context context, FieldModel fieldModel, List<TagModel> list, OnFieldValueChangeListener onFieldValueChangeListener) {
        this(context, fieldModel, list, onFieldValueChangeListener, (AttributeSet) null, 0, 48, (DefaultConstructorMarker) null);
    }

    public FieldViewSpinner(Context context, FieldModel fieldModel, List<TagModel> list, OnFieldValueChangeListener onFieldValueChangeListener, AttributeSet attributeSet) {
        this(context, fieldModel, list, onFieldValueChangeListener, attributeSet, 0, 32, (DefaultConstructorMarker) null);
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

    public boolean hasValue() {
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FieldViewSpinner(Context context, FieldModel fieldModel, List list, OnFieldValueChangeListener onFieldValueChangeListener, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, fieldModel, list, onFieldValueChangeListener, (i2 & 16) != 0 ? null : attributeSet, (i2 & 32) != 0 ? 0 : i);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FieldViewSpinner(Context r29, FieldModel r30, List<TagModel> r31, OnFieldValueChangeListener r32, AttributeSet r33, int r34) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r31
            r3 = r32
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r4)
            java.lang.String r4 = "field"
            r5 = r30
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r4)
            java.lang.String r4 = "tagList"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r4)
            java.lang.String r4 = "listener"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r4)
            r4 = r33
            r6 = r34
            r0.<init>(r1, r4, r6)
            java.lang.String r4 = "layout_inflater"
            java.lang.Object r4 = r1.getSystemService(r4)
            android.view.LayoutInflater r4 = (android.view.LayoutInflater) r4
            if (r4 == 0) goto L_0x0038
            r6 = 2131558530(0x7f0d0082, float:1.8742378E38)
            r7 = r0
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            r4.inflate(r6, r7)
        L_0x0038:
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
            r25 = 0
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r27 = 0
            r5 = r30
            kz.sapasoft.emark.app.domain.model.FieldModel r4 = kz.sapasoft.emark.app.domain.model.FieldModel.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r0.mField = r4
            int r4 = kz.sapasoft.emark.app.R.id.tv_title
            android.view.View r4 = r0._$_findCachedViewById(r4)
            com.google.android.material.textview.MaterialTextView r4 = (com.google.android.material.textview.MaterialTextView) r4
            java.lang.String r5 = "tv_title"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            java.lang.String r5 = r30.getName()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r2 = r2.iterator()
        L_0x0086:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x00a5
            java.lang.Object r5 = r2.next()
            r6 = r5
            kz.sapasoft.emark.app.domain.model.TagModel r6 = (kz.sapasoft.emark.app.domain.model.TagModel) r6
            java.lang.String r6 = r6.getTemplateId()
            java.lang.String r7 = r30.getTagTemplateId()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0086
            r4.add(r5)
            goto L_0x0086
        L_0x00a5:
            java.util.List r4 = (java.util.List) r4
            r0.mTagList = r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r2 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r5)
            r2.<init>(r5)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r4 = r4.iterator()
        L_0x00bc:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00d0
            java.lang.Object r5 = r4.next()
            kz.sapasoft.emark.app.domain.model.TagModel r5 = (kz.sapasoft.emark.app.domain.model.TagModel) r5
            java.lang.String r5 = r5.getName()
            r2.add(r5)
            goto L_0x00bc
        L_0x00d0:
            java.util.List r2 = (java.util.List) r2
            android.widget.ArrayAdapter r4 = new android.widget.ArrayAdapter
            r5 = 2131558459(0x7f0d003b, float:1.8742234E38)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.toMutableList(r2)
            r4.<init>(r1, r5, r2)
            int r1 = kz.sapasoft.emark.app.R.id.spinner
            android.view.View r1 = r0._$_findCachedViewById(r1)
            android.widget.Spinner r1 = (android.widget.Spinner) r1
            java.lang.String r2 = "spinner"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            android.widget.SpinnerAdapter r4 = (android.widget.SpinnerAdapter) r4
            r1.setAdapter(r4)
            java.util.List<kz.sapasoft.emark.app.domain.model.TagModel> r1 = r0.mTagList
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x00fa:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0116
            java.lang.Object r4 = r1.next()
            r5 = r4
            kz.sapasoft.emark.app.domain.model.TagModel r5 = (kz.sapasoft.emark.app.domain.model.TagModel) r5
            java.lang.String r5 = r5.getTemplateId()
            java.lang.String r6 = r30.getTagTemplateId()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x00fa
            goto L_0x0117
        L_0x0116:
            r4 = 0
        L_0x0117:
            kz.sapasoft.emark.app.domain.model.TagModel r4 = (kz.sapasoft.emark.app.domain.model.TagModel) r4
            int r1 = kz.sapasoft.emark.app.R.id.spinner
            android.view.View r1 = r0._$_findCachedViewById(r1)
            android.widget.Spinner r1 = (android.widget.Spinner) r1
            java.util.List<kz.sapasoft.emark.app.domain.model.TagModel> r5 = r0.mTagList
            int r4 = kotlin.collections.CollectionsKt.indexOf(r5, r4)
            r1.setSelection(r4)
            int r1 = kz.sapasoft.emark.app.R.id.spinner
            android.view.View r1 = r0._$_findCachedViewById(r1)
            android.widget.Spinner r1 = (android.widget.Spinner) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            kz.sapasoft.emark.app.ui.custom_views.FieldViewSpinner$2 r2 = new kz.sapasoft.emark.app.ui.custom_views.FieldViewSpinner$2
            r2.<init>(r3)
            android.widget.AdapterView$OnItemSelectedListener r2 = (android.widget.AdapterView.OnItemSelectedListener) r2
            r1.setOnItemSelectedListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.custom_views.FieldViewSpinner.<init>(android.content.Context, kz.sapasoft.emark.app.domain.model.FieldModel, java.util.List, kz.sapasoft.emark.app.ui.marker.OnFieldValueChangeListener, android.util.AttributeSet, int):void");
    }

    public FieldModel getFieldModel() {
        Spinner spinner = (Spinner) _$_findCachedViewById(R.id.spinner);
        Intrinsics.checkExpressionValueIsNotNull(spinner, "spinner");
        if (spinner.getSelectedItemPosition() != -1) {
            FieldModel fieldModel = this.mField;
            List<TagModel> list = this.mTagList;
            Spinner spinner2 = (Spinner) _$_findCachedViewById(R.id.spinner);
            Intrinsics.checkExpressionValueIsNotNull(spinner2, "spinner");
            fieldModel.tagValue = list.get(spinner2.getSelectedItemPosition());
        }
        return this.mField;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: kz.sapasoft.emark.app.domain.model.TagModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setFieldModel(FieldModel r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            java.lang.String r2 = "field"
            r15 = r25
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r15, r2)
            r2 = 0
            r3 = 0
            r4 = 0
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
            r16 = 0
            r15 = r16
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 1048575(0xfffff, float:1.469367E-39)
            r23 = 0
            kz.sapasoft.emark.app.domain.model.FieldModel r1 = kz.sapasoft.emark.app.domain.model.FieldModel.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r0.mField = r1
            java.util.List<kz.sapasoft.emark.app.domain.model.TagModel> r1 = r0.mTagList
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0039:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x005c
            java.lang.Object r2 = r1.next()
            r4 = r2
            kz.sapasoft.emark.app.domain.model.TagModel r4 = (kz.sapasoft.emark.app.domain.model.TagModel) r4
            java.lang.String r4 = r4.getId()
            kz.sapasoft.emark.app.domain.model.TagModel r5 = r25.getTagValue()
            if (r5 == 0) goto L_0x0055
            java.lang.String r3 = r5.getId()
        L_0x0055:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0039
            r3 = r2
        L_0x005c:
            kz.sapasoft.emark.app.domain.model.TagModel r3 = (kz.sapasoft.emark.app.domain.model.TagModel) r3
            int r1 = kz.sapasoft.emark.app.R.id.spinner
            android.view.View r1 = r0._$_findCachedViewById(r1)
            android.widget.Spinner r1 = (android.widget.Spinner) r1
            java.util.List<kz.sapasoft.emark.app.domain.model.TagModel> r2 = r0.mTagList
            int r2 = kotlin.collections.CollectionsKt.indexOf(r2, r3)
            r1.setSelection(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.custom_views.FieldViewSpinner.setFieldModel(kz.sapasoft.emark.app.domain.model.FieldModel):void");
    }

    public boolean isRequired() {
        Boolean required = this.mField.required;
        if (required != null) {
            return required.booleanValue();
        }
        return false;
    }
}

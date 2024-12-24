package kz.sapasoft.emark.app.ui.custom_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.decompiledapk.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.domain.model.TemplateModel;
import kz.sapasoft.emark.app.ui.marker.OnMarkerTypeChangeListener;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ$\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkz/sapasoft/emark/app/ui/custom_views/MarkerTypeView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTemplateList", "", "Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "getMarkerType", "", "getTemplateId", "setData", "", "templateList", "selectedTemplateId", "listener", "Lkz/sapasoft/emark/app/ui/marker/OnMarkerTypeChangeListener;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MarkerTypeView.kt */
public final class MarkerTypeView extends LinearLayout {
    private HashMap _$_findViewCache;
    private List<TemplateModel> mTemplateList;

    public MarkerTypeView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public MarkerTypeView(Context context, AttributeSet attributeSet) {
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
    public /* synthetic */ MarkerTypeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkerTypeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (layoutInflater != null) {
            layoutInflater.inflate(R.layout.view_marker_type, this);
        }
    }

    public final void setData(List<TemplateModel> list, String str, OnMarkerTypeChangeListener onMarkerTypeChangeListener) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(list, "templateList");
        Intrinsics.checkParameterIsNotNull(str, "selectedTemplateId");
        Intrinsics.checkParameterIsNotNull(onMarkerTypeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mTemplateList = list;
        Iterable<TemplateModel> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (TemplateModel name : iterable) {
            arrayList.add(name.getName());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.item_spinner, CollectionsKt.toMutableList((List) arrayList));
        Spinner spinner = (Spinner) _$_findCachedViewById(R.id.spinner);
        Intrinsics.checkExpressionValueIsNotNull(spinner, "spinner");
        spinner.setAdapter(arrayAdapter);
        Spinner spinner2 = (Spinner) _$_findCachedViewById(R.id.spinner);
        Iterator it = iterable.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((TemplateModel) obj).getId(), (Object) str)) {
                break;
            }
        }
        spinner2.setSelection(CollectionsKt.indexOf(list, obj));
        Spinner spinner3 = (Spinner) _$_findCachedViewById(R.id.spinner);
        Intrinsics.checkExpressionValueIsNotNull(spinner3, "spinner");
        spinner3.setOnItemSelectedListener(new MarkerTypeView$setData$2(onMarkerTypeChangeListener, list));
    }

    public final String getMarkerType() {
        List<TemplateModel> list = this.mTemplateList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTemplateList");
        }
        Spinner spinner = (Spinner) _$_findCachedViewById(R.id.spinner);
        Intrinsics.checkExpressionValueIsNotNull(spinner, "spinner");
        return list.get(spinner.getSelectedItemPosition()).getMarkerTypes().get(0);
    }

    public final String getTemplateId() {
        List<TemplateModel> list = this.mTemplateList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTemplateList");
        }
        Spinner spinner = (Spinner) _$_findCachedViewById(R.id.spinner);
        Intrinsics.checkExpressionValueIsNotNull(spinner, "spinner");
        return list.get(spinner.getSelectedItemPosition()).getId();
    }
}

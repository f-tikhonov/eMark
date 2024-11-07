package kz.sapasoft.emark.app.ui.marker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.databinding.FragmentMarkerBinding;
import kz.sapasoft.emark.app.domain.model.FieldModel;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.sapasoft.emark.app.domain.model.ProjectModel;
import kz.sapasoft.emark.app.domain.model.TagModel;
import kz.sapasoft.emark.app.domain.model.TemplateModel;
import kz.sapasoft.emark.app.ui.MainActivity;
import kz.sapasoft.emark.app.ui.base.DaggerFragmentExtended;
import kz.sapasoft.emark.app.ui.custom_views.FieldView;
import kz.sapasoft.emark.app.ui.custom_views.FieldViewDate;
import kz.sapasoft.emark.app.ui.custom_views.FieldViewDouble;
import kz.sapasoft.emark.app.ui.custom_views.FieldViewLong;
import kz.sapasoft.emark.app.ui.custom_views.FieldViewSpinner;
import kz.sapasoft.emark.app.ui.custom_views.FieldViewText;
import kz.sapasoft.emark.app.ui.custom_views.MarkerDepthView;
import kz.sapasoft.emark.app.ui.custom_views.MarkerIdentifierView;
import kz.sapasoft.emark.app.ui.custom_views.MarkerModelView;
import kz.sapasoft.emark.app.ui.custom_views.MarkerPhotoView;
import kz.sapasoft.emark.app.ui.custom_views.MarkerTypeView;
import kz.sapasoft.emark.app.utils.Constants;
import kz.ss.emark.R;
import pl.aprilapps.easyphotopicker.EasyImage;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001aB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0002J\b\u0010.\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020,H\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cH\u0002J\b\u00101\u001a\u00020\u0016H\u0002J\u0010\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u000204H\u0002J\u0016\u00105\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u0002040\u001cH\u0002J\u0016\u00108\u001a\u0002062\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cH\u0002J\u0018\u0010:\u001a\u0002062\u000e\u00107\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u001cH\u0002J\u0010\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020\u0016H\u0002J\b\u0010=\u001a\u000206H\u0002J\"\u0010>\u001a\u0002062\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u000206H\u0016J\u0018\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016J&\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010G\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010P\u001a\u000206H\u0016J\u0010\u0010Q\u001a\u0002062\u0006\u0010R\u001a\u00020\u001fH\u0016J\u0010\u0010S\u001a\u00020,2\u0006\u0010T\u001a\u00020UH\u0016J-\u0010V\u001a\u0002062\u0006\u0010?\u001a\u00020\u00072\u000e\u0010W\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0X2\u0006\u0010Y\u001a\u00020ZH\u0016¢\u0006\u0002\u0010[J\u001a\u0010\\\u001a\u0002062\u0006\u0010]\u001a\u00020J2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010^\u001a\u000206H\u0002J\b\u0010_\u001a\u000206H\u0002J\b\u0010`\u001a\u000206H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cX.¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u000f\u001a\u0004\b\"\u0010#R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006b"}, d2 = {"Lkz/sapasoft/emark/app/ui/marker/MarkerFragment;", "Lkz/sapasoft/emark/app/ui/base/DaggerFragmentExtended;", "Lkz/sapasoft/emark/app/ui/marker/OnFieldValueChangeListener;", "Lkz/sapasoft/emark/app/ui/marker/OnMarkerTypeChangeListener;", "Lkz/sapasoft/emark/app/ui/marker/OnImageClickListener;", "()V", "REQUEST_CAMERA_PERMISSION", "", "TAG", "", "easyImage", "Lpl/aprilapps/easyphotopicker/EasyImage;", "getEasyImage", "()Lpl/aprilapps/easyphotopicker/EasyImage;", "easyImage$delegate", "Lkotlin/Lazy;", "localImageList", "Ljava/util/ArrayList;", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "mFieldViewList", "Lkz/sapasoft/emark/app/ui/custom_views/FieldView;", "mMarkerModel", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "mOnMarkerChangeListener", "Lkz/sapasoft/emark/app/ui/marker/OnMarkerChangeListener;", "mProjectModel", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "mTagList", "", "Lkz/sapasoft/emark/app/domain/model/TagModel;", "mTemplateList", "Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "viewModel", "Lkz/sapasoft/emark/app/ui/marker/MarkerViewModel;", "getViewModel", "()Lkz/sapasoft/emark/app/ui/marker/MarkerViewModel;", "viewModel$delegate", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "checkAllRequiredFilled", "", "checkCameraPermission", "checkFieldsHasChanges", "checkMainHasChanges", "constructImageDataModel", "constructNewMarkerModel", "drawField", "fieldModel", "Lkz/sapasoft/emark/app/domain/model/FieldModel;", "drawFieldList", "", "fieldModelList", "drawMainList", "templateList", "fillFields", "fillMain", "markerModel", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAddPhotoClick", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFieldValueChange", "onMarkerTypeChange", "templateModel", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "view", "requestCameraPermission", "setListeners", "setObservers", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MarkerFragment.kt */
public final class MarkerFragment extends DaggerFragmentExtended implements OnFieldValueChangeListener, OnMarkerTypeChangeListener, OnImageClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int REQUEST_CAMERA_PERMISSION = 1;
    private final String TAG;
    private HashMap _$_findViewCache;
    private final Lazy easyImage$delegate = LazyKt.lazy(new MarkerFragment$easyImage$2(this));
    /* access modifiers changed from: private */
    public final ArrayList<ImageDataModel> localImageList = new ArrayList<>();
    private final ArrayList<FieldView> mFieldViewList = new ArrayList<>();
    /* access modifiers changed from: private */
    public MarkerModel mMarkerModel;
    /* access modifiers changed from: private */
    public OnMarkerChangeListener mOnMarkerChangeListener;
    private ProjectModel mProjectModel;
    /* access modifiers changed from: private */
    public List<TagModel> mTagList;
    /* access modifiers changed from: private */
    public List<TemplateModel> mTemplateList;
    private final Lazy viewModel$delegate = LazyKt.lazy(new MarkerFragment$viewModel$2(this));
    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    private final EasyImage getEasyImage() {
        return (EasyImage) this.easyImage$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MarkerViewModel getViewModel() {
        return (MarkerViewModel) this.viewModel$delegate.getValue();
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
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public MarkerFragment() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this::class.java.simpleName");
        this.TAG = simpleName;
    }

    public static final /* synthetic */ MarkerModel access$getMMarkerModel$p(MarkerFragment markerFragment) {
        MarkerModel markerModel = markerFragment.mMarkerModel;
        if (markerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        return markerModel;
    }

    public static final /* synthetic */ OnMarkerChangeListener access$getMOnMarkerChangeListener$p(MarkerFragment markerFragment) {
        OnMarkerChangeListener onMarkerChangeListener = markerFragment.mOnMarkerChangeListener;
        if (onMarkerChangeListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOnMarkerChangeListener");
        }
        return onMarkerChangeListener;
    }

    public static final /* synthetic */ List access$getMTagList$p(MarkerFragment markerFragment) {
        List<TagModel> list = markerFragment.mTagList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTagList");
        }
        return list;
    }

    public static final /* synthetic */ List access$getMTemplateList$p(MarkerFragment markerFragment) {
        List<TemplateModel> list = markerFragment.mTemplateList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTemplateList");
        }
        return list;
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return factory;
    }

    public final void setViewModelFactory(ViewModelProvider.Factory factory) {
        Intrinsics.checkParameterIsNotNull(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lkz/sapasoft/emark/app/ui/marker/MarkerFragment$Companion;", "", "()V", "newInstance", "Lkz/sapasoft/emark/app/ui/marker/MarkerFragment;", "projectModel", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "markerModel", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "listener", "Lkz/sapasoft/emark/app/ui/marker/OnMarkerChangeListener;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MarkerFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MarkerFragment newInstance(ProjectModel projectModel, MarkerModel markerModel, OnMarkerChangeListener onMarkerChangeListener) {
            Intrinsics.checkParameterIsNotNull(projectModel, "projectModel");
            Intrinsics.checkParameterIsNotNull(markerModel, "markerModel");
            Intrinsics.checkParameterIsNotNull(onMarkerChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            MarkerFragment markerFragment = new MarkerFragment();
            markerFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("projectModel", projectModel), TuplesKt.to("marker", markerModel)));
            markerFragment.mOnMarkerChangeListener = onMarkerChangeListener;
            return markerFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        FragmentMarkerBinding fragmentMarkerBinding = (FragmentMarkerBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_marker, viewGroup, false);
        Serializable serializable = requireArguments().getSerializable("projectModel");
        if (serializable != null) {
            this.mProjectModel = (ProjectModel) serializable;
            Serializable serializable2 = requireArguments().getSerializable("marker");
            if (serializable2 != null) {
                this.mMarkerModel = (MarkerModel) serializable2;
                setHasOptionsMenu(true);
                Intrinsics.checkExpressionValueIsNotNull(fragmentMarkerBinding, "binding");
                MarkerModel markerModel = this.mMarkerModel;
                if (markerModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
                }
                fragmentMarkerBinding.setItem(markerModel);
                return fragmentMarkerBinding.getRoot();
            }
            throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.domain.model.MarkerModel");
        }
        throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.domain.model.ProjectModel");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        MarkerViewModel viewModel = getViewModel();
        MarkerModel markerModel = this.mMarkerModel;
        if (markerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        ProjectModel projectModel = this.mProjectModel;
        if (projectModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProjectModel");
        }
        viewModel.getAllData(markerModel, projectModel.getMarkerTemplateIds());
        initView();
        setListeners();
        setObservers();
    }

    private final void initView() {
        TextView textView = (TextView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.tv_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_toolbar");
        textView.setText(getString(R.string.marker));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((MainActivity) activity).setSupportActionBar((Toolbar) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.toolbar));
            MarkerModel markerModel = this.mMarkerModel;
            if (markerModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
            }
            if (markerModel.getStatus() == null) {
                MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.btn_save);
                Intrinsics.checkExpressionValueIsNotNull(materialButton, "btn_save");
                materialButton.setVisibility(8);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity");
    }

    private final void setListeners() {
        ((MaterialButton) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.btn_save)).setOnClickListener(new MarkerFragment$setListeners$1(this));
    }

    private final void setObservers() {
        MarkerViewModel viewModel = getViewModel();
        viewModel.getMarkerModelData().observe(getViewLifecycleOwner(), new MarkerFragment$setObservers$$inlined$with$lambda$1(this));
        viewModel.getImagesData().observe(getViewLifecycleOwner(), new MarkerFragment$setObservers$$inlined$with$lambda$2(this));
        viewModel.getLocalImagesData().observe(getViewLifecycleOwner(), new MarkerFragment$setObservers$$inlined$with$lambda$3(this));
        viewModel.getError().observe(getViewLifecycleOwner(), new MarkerFragment$setObservers$$inlined$with$lambda$4(this));
        viewModel.getLoading().observe(getViewLifecycleOwner(), new MarkerFragment$setObservers$$inlined$with$lambda$5(this));
        viewModel.getMarkerChangeTask().observe(getViewLifecycleOwner(), new MarkerFragment$setObservers$$inlined$with$lambda$6(this));
        viewModel.getTagModelData().observe(getViewLifecycleOwner(), new MarkerFragment$setObservers$$inlined$with$lambda$7(this));
        viewModel.getTemplateModelData().observe(getViewLifecycleOwner(), new MarkerFragment$setObservers$$inlined$with$lambda$8(this));
    }

    /* access modifiers changed from: private */
    public final void drawMainList(List<TemplateModel> list) {
        MarkerTypeView markerTypeView = (MarkerTypeView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_type);
        MarkerModel markerModel = this.mMarkerModel;
        if (markerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        String templateId = markerModel.getTemplateId();
        if (templateId == null) {
            templateId = list.get(0).getId();
        }
        markerTypeView.setData(list, templateId, this);
        MarkerIdentifierView markerIdentifierView = (MarkerIdentifierView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_identifier);
        MarkerModel markerModel2 = this.mMarkerModel;
        if (markerModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        OnFieldValueChangeListener onFieldValueChangeListener = this;
        markerIdentifierView.setData(markerModel2.getGeneralId(), onFieldValueChangeListener);
        MarkerModelView markerModelView = (MarkerModelView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_model);
        MarkerModel markerModel3 = this.mMarkerModel;
        if (markerModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        markerModelView.setData(markerModel3.getMarkerModel());
        ((MarkerDepthView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_depth)).setData((Double) null, onFieldValueChangeListener);
        ((MarkerPhotoView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_photo)).setListeners(this, onFieldValueChangeListener);
    }

    /* access modifiers changed from: private */
    public final void drawFieldList(List<FieldModel> list) {
        ((LinearLayout) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.ll_additional_fields)).removeAllViews();
        this.mFieldViewList.clear();
        for (FieldModel drawField : list) {
            FieldView drawField2 = drawField(drawField);
            this.mFieldViewList.add(drawField2);
            ((LinearLayout) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.ll_additional_fields)).addView(drawField2);
        }
    }

    private final FieldView drawField(FieldModel fieldModel) {
        String valueType = fieldModel.getValueType();
        if (valueType != null) {
            switch (valueType.hashCode()) {
                case -1626611680:
                    if (valueType.equals(Constants.FieldTypes.DOUBLE)) {
                        Context requireContext = requireContext();
                        Intrinsics.checkExpressionValueIsNotNull(requireContext, "requireContext()");
                        return new FieldViewDouble(requireContext, fieldModel, this, (AttributeSet) null, 0, 24, (DefaultConstructorMarker) null);
                    }
                    break;
                case -1046441916:
                    if (valueType.equals(Constants.FieldTypes.TEXT)) {
                        Context requireContext2 = requireContext();
                        Intrinsics.checkExpressionValueIsNotNull(requireContext2, "requireContext()");
                        return new FieldViewText(requireContext2, fieldModel, this, (AttributeSet) null, 0, 24, (DefaultConstructorMarker) null);
                    }
                    break;
                case -772697609:
                    if (valueType.equals(Constants.FieldTypes.TAG)) {
                        Context requireContext3 = requireContext();
                        Intrinsics.checkExpressionValueIsNotNull(requireContext3, "requireContext()");
                        List<TagModel> list = this.mTagList;
                        if (list == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTagList");
                        }
                        return new FieldViewSpinner(requireContext3, fieldModel, list, this, (AttributeSet) null, 0, 48, (DefaultConstructorMarker) null);
                    }
                    break;
                case -257733021:
                    if (valueType.equals(Constants.FieldTypes.DATE)) {
                        Context requireContext4 = requireContext();
                        Intrinsics.checkExpressionValueIsNotNull(requireContext4, "requireContext()");
                        return new FieldViewDate(requireContext4, fieldModel, this, (AttributeSet) null, 0, 24, (DefaultConstructorMarker) null);
                    }
                    break;
                case 119244885:
                    if (valueType.equals(Constants.FieldTypes.LONG)) {
                        Context requireContext5 = requireContext();
                        Intrinsics.checkExpressionValueIsNotNull(requireContext5, "requireContext()");
                        return new FieldViewLong(requireContext5, fieldModel, this, (AttributeSet) null, 0, 24, (DefaultConstructorMarker) null);
                    }
                    break;
                case 2044569767:
                    if (valueType.equals(Constants.FieldTypes.BOOL)) {
                        Context requireContext6 = requireContext();
                        Intrinsics.checkExpressionValueIsNotNull(requireContext6, "requireContext()");
                        List<TagModel> list2 = this.mTagList;
                        if (list2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTagList");
                        }
                        return new FieldViewSpinner(requireContext6, fieldModel, list2, this, (AttributeSet) null, 0, 48, (DefaultConstructorMarker) null);
                    }
                    break;
            }
        }
        Context requireContext7 = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(requireContext7, "requireContext()");
        return new FieldViewText(requireContext7, fieldModel, this, (AttributeSet) null, 0, 24, (DefaultConstructorMarker) null);
    }

    public void onAddPhotoClick() {
        if (checkCameraPermission()) {
            getEasyImage().openCameraForImage((Fragment) this);
        } else {
            requestCameraPermission();
        }
    }

    private final boolean checkCameraPermission() {
        return ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") == 0;
    }

    private final void requestCameraPermission() {
        requestPermissions(new String[]{"android.permission.CAMERA"}, this.REQUEST_CAMERA_PERMISSION);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        EasyImage easyImage = getEasyImage();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        easyImage.handleActivityResult(i, i2, intent, requireActivity, new MarkerFragment$onActivityResult$1(this));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == this.REQUEST_CAMERA_PERMISSION) {
            if ((iArr.length == 0) || iArr[0] != 0) {
                Snackbar.make((View) (Toolbar) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.toolbar), (CharSequence) getString(R.string.permission_camera_needed), -1).show();
            } else {
                getEasyImage().openCameraForImage((Fragment) this);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void fillMain(MarkerModel markerModel) {
        OnFieldValueChangeListener onFieldValueChangeListener = this;
        ((MarkerIdentifierView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_identifier)).setData(markerModel.getGeneralId(), onFieldValueChangeListener);
        ((MarkerModelView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_model)).setData(markerModel.getMarkerModel());
        ((MarkerDepthView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_depth)).setData(markerModel.getDepth(), onFieldValueChangeListener);
    }

    /* access modifiers changed from: private */
    public final void fillFields(List<FieldModel> list) {
        Object obj;
        if (list != null) {
            for (FieldModel next : list) {
                Iterator it = this.mFieldViewList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((FieldView) obj).getFieldModel().getId(), (Object) next.getId())) {
                        break;
                    }
                }
                FieldView fieldView = (FieldView) obj;
                if (fieldView != null) {
                    fieldView.setFieldModel(next);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final MarkerModel constructNewMarkerModel() {
        MarkerModel markerModel = this.mMarkerModel;
        if (markerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        String[] strArr = new String[1];
        ProjectModel projectModel = this.mProjectModel;
        if (projectModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProjectModel");
        }
        strArr[0] = projectModel.getId();
        markerModel.setProjectIds(CollectionsKt.arrayListOf(strArr));
        MarkerModel markerModel2 = this.mMarkerModel;
        if (markerModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        markerModel2.setMarkerModel(((MarkerModelView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_model)).getMarkerModel());
        MarkerModel markerModel3 = this.mMarkerModel;
        if (markerModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        markerModel3.setMarkerType(((MarkerTypeView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_type)).getMarkerType());
        MarkerModel markerModel4 = this.mMarkerModel;
        if (markerModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        markerModel4.setTemplateId(((MarkerTypeView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_type)).getTemplateId());
        MarkerModel markerModel5 = this.mMarkerModel;
        if (markerModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        markerModel5.setDepth(((MarkerDepthView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_depth)).getValue());
        MarkerModel markerModel6 = this.mMarkerModel;
        if (markerModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        MarkerModel markerModel7 = this.mMarkerModel;
        if (markerModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        markerModel6.setLocation(markerModel7.getLocation());
        ArrayList arrayList = new ArrayList();
        Iterator<FieldView> it = this.mFieldViewList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFieldModel());
        }
        MarkerModel markerModel8 = this.mMarkerModel;
        if (markerModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        markerModel8.setFields(arrayList);
        MarkerModel markerModel9 = this.mMarkerModel;
        if (markerModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        MarkerModel markerModel10 = this.mMarkerModel;
        if (markerModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        String idLocal = markerModel10.getIdLocal();
        if (idLocal == null) {
            idLocal = UUID.randomUUID().toString();
        }
        markerModel9.setIdLocal(idLocal);
        MarkerModel markerModel11 = this.mMarkerModel;
        if (markerModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        return markerModel11;
    }

    /* access modifiers changed from: private */
    public final List<ImageDataModel> constructImageDataModel() {
        List<ImageDataModel> changedModelList = ((MarkerPhotoView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_photo)).getChangedModelList();
        for (ImageDataModel imageDataModel : changedModelList) {
            MarkerModel markerModel = this.mMarkerModel;
            if (markerModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
            }
            imageDataModel.setLocalIdParent(markerModel.getIdLocal());
        }
        return changedModelList;
    }

    public void onMarkerTypeChange(TemplateModel templateModel) {
        Intrinsics.checkParameterIsNotNull(templateModel, "templateModel");
        drawFieldList(templateModel.getFields());
        MarkerModel markerModel = this.mMarkerModel;
        if (markerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        fillFields(markerModel.getFields());
    }

    public void onFieldValueChange() {
        boolean checkMainHasChanges = checkMainHasChanges();
        boolean checkFieldsHasChanges = checkFieldsHasChanges();
        boolean checkAllRequiredFilled = checkAllRequiredFilled();
        MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.btn_save);
        Intrinsics.checkExpressionValueIsNotNull(materialButton, "btn_save");
        materialButton.setEnabled((checkMainHasChanges || checkFieldsHasChanges) && checkAllRequiredFilled);
    }

    private final boolean checkMainHasChanges() {
        String markerModel = ((MarkerModelView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_model)).getMarkerModel();
        MarkerModel markerModel2 = this.mMarkerModel;
        if (markerModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        if (!Intrinsics.areEqual((Object) markerModel, (Object) markerModel2.getMarkerModel())) {
            return true;
        }
        Double value = ((MarkerDepthView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_depth)).getValue();
        MarkerModel markerModel3 = this.mMarkerModel;
        if (markerModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        if (!Intrinsics.areEqual(value, markerModel3.getDepth())) {
            return true;
        }
        ArrayList<ImageDataModel> arrayList = this.localImageList;
        List<ImageDataModel> changedModelList = ((MarkerPhotoView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_photo)).getChangedModelList();
        if (!arrayList.containsAll(changedModelList) || !changedModelList.containsAll(arrayList)) {
            return true;
        }
        return false;
    }

    private final boolean checkFieldsHasChanges() {
        FieldModel fieldModel;
        Object obj;
        Iterator<FieldView> it = this.mFieldViewList.iterator();
        while (it.hasNext()) {
            FieldModel fieldModel2 = it.next().getFieldModel();
            MarkerModel markerModel = this.mMarkerModel;
            if (markerModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
            }
            List<FieldModel> fields = markerModel.getFields();
            String str = null;
            if (fields != null) {
                Iterator it2 = fields.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (Intrinsics.areEqual((Object) ((FieldModel) obj).getId(), (Object) fieldModel2.getId())) {
                        break;
                    }
                }
                fieldModel = (FieldModel) obj;
            } else {
                fieldModel = null;
            }
            String fieldModel3 = fieldModel2.toString();
            if (fieldModel != null) {
                str = fieldModel.toString();
            }
            if (!Intrinsics.areEqual((Object) fieldModel3, (Object) str)) {
                return true;
            }
        }
        return false;
    }

    private final boolean checkAllRequiredFilled() {
        if (!((MarkerDepthView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.view_marker_depth)).hasValue()) {
            return false;
        }
        Iterator<FieldView> it = this.mFieldViewList.iterator();
        while (it.hasNext()) {
            FieldView next = it.next();
            if (next.isRequired() && !next.hasValue()) {
                return false;
            }
        }
        return true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkParameterIsNotNull(menu, "menu");
        Intrinsics.checkParameterIsNotNull(menuInflater, "inflater");
        menu.clear();
        MarkerModel markerModel = this.mMarkerModel;
        if (markerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
        }
        if (markerModel.getStatus() != null) {
            menuInflater.inflate(R.menu.marker_menu, menu);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() == R.id.action_delete_local) {
            MarkerViewModel viewModel = getViewModel();
            MarkerModel markerModel = this.mMarkerModel;
            if (markerModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMarkerModel");
            }
            viewModel.deleteLocal(markerModel);
        }
        return super.onOptionsItemSelected(menuItem);
    }
}

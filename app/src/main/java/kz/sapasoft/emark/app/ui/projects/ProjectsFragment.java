package kz.sapasoft.emark.app.ui.projects;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.databinding.FragmentProjectsBinding;
import kz.sapasoft.emark.app.domain.model.ProjectModel;
import kz.sapasoft.emark.app.ui.MainActivity;
import kz.sapasoft.emark.app.ui.base.DaggerFragmentExtended;
import kz.sapasoft.emark.app.ui.map.MapFragment;
import kz.sapasoft.emark.app.ui.projects.adapter.ProjectsAdapter;
import kz.ss.emark.R;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Lkz/sapasoft/emark/app/ui/projects/ProjectsFragment;", "Lkz/sapasoft/emark/app/ui/base/DaggerFragmentExtended;", "Lkz/sapasoft/emark/app/ui/projects/adapter/ProjectsAdapter$OnProjectClickListener;", "()V", "TAG", "", "adapter", "Lkz/sapasoft/emark/app/ui/projects/adapter/ProjectsAdapter;", "getAdapter", "()Lkz/sapasoft/emark/app/ui/projects/adapter/ProjectsAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lkz/sapasoft/emark/app/ui/projects/ProjectsViewModel;", "getViewModel", "()Lkz/sapasoft/emark/app/ui/projects/ProjectsViewModel;", "viewModel$delegate", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "initRecyclerView", "", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onProjectClick", "projectModel", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "onViewCreated", "view", "setListeners", "setObservers", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ProjectsFragment.kt */
public final class ProjectsFragment extends DaggerFragmentExtended implements ProjectsAdapter.OnProjectClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String TAG;
    private HashMap _$_findViewCache;
    private final Lazy adapter$delegate = LazyKt.lazy(new ProjectsFragment$adapter$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new ProjectsFragment$viewModel$2(this));
    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    /* access modifiers changed from: private */
    public final ProjectsAdapter getAdapter() {
        return (ProjectsAdapter) this.adapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ProjectsViewModel getViewModel() {
        return (ProjectsViewModel) this.viewModel$delegate.getValue();
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

    public ProjectsFragment() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this::class.java.simpleName");
        this.TAG = simpleName;
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lkz/sapasoft/emark/app/ui/projects/ProjectsFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ProjectsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Fragment newInstance() {
            ProjectsFragment projectsFragment = new ProjectsFragment();
            projectsFragment.setArguments(new Bundle());
            return projectsFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        FragmentProjectsBinding fragmentProjectsBinding = (FragmentProjectsBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_projects, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(fragmentProjectsBinding, "binding");
        fragmentProjectsBinding.setLifecycleOwner(this);
        fragmentProjectsBinding.setViewModel(getViewModel());
        return fragmentProjectsBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        setObservers();
        setListeners();
    }

    private final void initView() {
        TextView textView = (TextView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.tv_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_toolbar");
        textView.setText(getString(R.string.nav_item_main));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((MainActivity) activity).setSupportActionBar((Toolbar) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.toolbar));
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                ActionBar supportActionBar = ((MainActivity) activity2).getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setDisplayHomeAsUpEnabled(false);
                }
                initRecyclerView();
                ((SwipeRefreshLayout) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.swipe)).setOnRefreshListener(new ProjectsFragment$initView$1(this));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity");
        }
        throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity");
    }

    private final void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.rv_main_home);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rv_main_home");
        recyclerView.setLayoutManager(linearLayoutManager);
        ((RecyclerView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.rv_main_home)).addItemDecoration(new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation()));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.rv_main_home);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rv_main_home");
        recyclerView2.setAdapter(getAdapter());
    }

    private final void setObservers() {
        ProjectsViewModel viewModel = getViewModel();
        viewModel.getSearchString().observe(getViewLifecycleOwner(), new ProjectsFragment$setObservers$$inlined$with$lambda$1(viewModel, this));
        viewModel.getProjectsData().observe(getViewLifecycleOwner(), new ProjectsFragment$setObservers$$inlined$with$lambda$2(this));
        viewModel.getError().observe(getViewLifecycleOwner(), new ProjectsFragment$setObservers$$inlined$with$lambda$3(this));
    }

    private final void setListeners() {
        ((TextView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.tv_retry)).setOnClickListener(new ProjectsFragment$setListeners$1(this));
    }

    public void onProjectClick(ProjectModel projectModel) {
        Intrinsics.checkParameterIsNotNull(projectModel, "projectModel");
        getChildFragmentClickListener().onFragmentAdd(MapFragment.Companion.newInstance(projectModel));
    }
}

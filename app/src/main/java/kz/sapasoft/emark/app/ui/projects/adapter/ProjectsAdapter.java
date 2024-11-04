package kz.sapasoft.emark.app.ui.projects.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.databinding.ItemProjectBinding;
import kz.sapasoft.emark.app.domain.model.ProjectModel;
import kz.sapasoft.emark.app.ui.DataBindingViewHolder;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0018\u0019B'\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u0006\u0010\u000e\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u000b2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lkz/sapasoft/emark/app/ui/projects/adapter/ProjectsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lkz/sapasoft/emark/app/ui/projects/adapter/ProjectsAdapter$SimpleHolder;", "items", "Ljava/util/ArrayList;", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "Lkotlin/collections/ArrayList;", "listener", "Lkz/sapasoft/emark/app/ui/projects/adapter/ProjectsAdapter$OnProjectClickListener;", "(Ljava/util/ArrayList;Lkz/sapasoft/emark/app/ui/projects/adapter/ProjectsAdapter$OnProjectClickListener;)V", "add", "", "list", "", "clear", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnProjectClickListener", "SimpleHolder", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ProjectsAdapter.kt */
public final class ProjectsAdapter extends RecyclerView.Adapter<SimpleHolder> {
    private ArrayList<ProjectModel> items;
    /* access modifiers changed from: private */
    public OnProjectClickListener listener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lkz/sapasoft/emark/app/ui/projects/adapter/ProjectsAdapter$OnProjectClickListener;", "", "onProjectClick", "", "projectModel", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ProjectsAdapter.kt */
    public interface OnProjectClickListener {
        void onProjectClick(ProjectModel projectModel);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProjectsAdapter(ArrayList arrayList, OnProjectClickListener onProjectClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, onProjectClickListener);
    }

    public ProjectsAdapter(ArrayList<ProjectModel> arrayList, OnProjectClickListener onProjectClickListener) {
        Intrinsics.checkParameterIsNotNull(arrayList, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkParameterIsNotNull(onProjectClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.items = arrayList;
        this.listener = onProjectClickListener;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(SimpleHolder simpleHolder, int i) {
        Intrinsics.checkParameterIsNotNull(simpleHolder, "holder");
        ProjectModel projectModel = this.items.get(i);
        Intrinsics.checkExpressionValueIsNotNull(projectModel, "items[position]");
        simpleHolder.onBind(projectModel);
    }

    public SimpleHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ItemProjectBinding inflate = ItemProjectBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemProjectBinding.infla….context), parent, false)");
        return new SimpleHolder(this, inflate);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lkz/sapasoft/emark/app/ui/projects/adapter/ProjectsAdapter$SimpleHolder;", "Lkz/sapasoft/emark/app/ui/DataBindingViewHolder;", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "dataBinding", "Landroidx/databinding/ViewDataBinding;", "(Lkz/sapasoft/emark/app/ui/projects/adapter/ProjectsAdapter;Landroidx/databinding/ViewDataBinding;)V", "onBind", "", "t", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ProjectsAdapter.kt */
    public final class SimpleHolder extends DataBindingViewHolder<ProjectModel> {
        final /* synthetic */ ProjectsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleHolder(ProjectsAdapter projectsAdapter, ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            Intrinsics.checkParameterIsNotNull(viewDataBinding, "dataBinding");
            this.this$0 = projectsAdapter;
        }

        public void onBind(ProjectModel projectModel) {
            Intrinsics.checkParameterIsNotNull(projectModel, "t");
            getDataBinding().setVariable(4, projectModel);
            getDataBinding().getRoot().setOnClickListener(new ProjectsAdapter$SimpleHolder$onBind$$inlined$with$lambda$1(this, projectModel));
        }
    }

    public final void add(List<ProjectModel> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public final void clear() {
        this.items.clear();
        notifyDataSetChanged();
    }
}

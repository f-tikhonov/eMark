package kz.sapasoft.emark.app.ui.projects;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onRefresh"}, k = 3, mv = {1, 1, 16})
/* compiled from: ProjectsFragment.kt */
final class ProjectsFragment$initView$1 implements SwipeRefreshLayout.OnRefreshListener {
    final /* synthetic */ ProjectsFragment this$0;

    ProjectsFragment$initView$1(ProjectsFragment projectsFragment) {
        this.this$0 = projectsFragment;
    }

    public final void onRefresh() {
        this.this$0.getAdapter().clear();
        this.this$0.getViewModel().getProjects();
    }
}

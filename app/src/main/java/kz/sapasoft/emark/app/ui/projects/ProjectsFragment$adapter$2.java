package kz.sapasoft.emark.app.ui.projects;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kz.sapasoft.emark.app.ui.projects.adapter.ProjectsAdapter;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkz/sapasoft/emark/app/ui/projects/adapter/ProjectsAdapter;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: ProjectsFragment.kt */
final class ProjectsFragment$adapter$2 extends Lambda implements Function0<ProjectsAdapter> {
    final /* synthetic */ ProjectsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProjectsFragment$adapter$2(ProjectsFragment projectsFragment) {
        super(0);
        this.this$0 = projectsFragment;
    }

    public final ProjectsAdapter invoke() {
        return new ProjectsAdapter(new ArrayList(), this.this$0);
    }
}

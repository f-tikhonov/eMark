package kz.sapasoft.emark.app.ui.projects;

import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.R;
import kz.sapasoft.emark.app.domain.model.ProjectModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "kotlin.jvm.PlatformType", "onChanged", "kz/sapasoft/emark/app/ui/projects/ProjectsFragment$setObservers$1$2"}, k = 3, mv = {1, 1, 16})
/* compiled from: ProjectsFragment.kt */
final class ProjectsFragment$setObservers$$inlined$with$lambda$2<T> implements Observer<List<ProjectModel>> {
    final /* synthetic */ ProjectsFragment this$0;

    ProjectsFragment$setObservers$$inlined$with$lambda$2(ProjectsFragment projectsFragment) {
        this.this$0 = projectsFragment;
    }

    @Override
    public void onChanged(List<ProjectModel> projectModels) {
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(R.id.ll_connection_error);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "ll_connection_error");
        linearLayout.setVisibility(View.GONE);
        Intrinsics.checkExpressionValueIsNotNull(projectModels, "it");
        if (!projectModels.isEmpty()) {
            this.this$0.getAdapter().add(projectModels);
        }
    }
}

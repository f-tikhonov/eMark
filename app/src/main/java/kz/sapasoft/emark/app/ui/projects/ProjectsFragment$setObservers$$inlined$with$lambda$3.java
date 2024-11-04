package kz.sapasoft.emark.app.ui.projects;

import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.R;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;
import kz.sapasoft.emark.app.domain.model.response.ErrorStatus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Error;", "kotlin.jvm.PlatformType", "onChanged", "kz/sapasoft/emark/app/ui/projects/ProjectsFragment$setObservers$1$3"}, k = 3, mv = {1, 1, 16})
/* compiled from: ProjectsFragment.kt */
final class ProjectsFragment$setObservers$$inlined$with$lambda$3<T> implements Observer<ResultWrapper.Error> {
    final /* synthetic */ ProjectsFragment this$0;

    ProjectsFragment$setObservers$$inlined$with$lambda$3(ProjectsFragment projectsFragment) {
        this.this$0 = projectsFragment;
    }

    public final void onChanged(ResultWrapper.Error error) {
        if (CollectionsKt.contains(CollectionsKt.listOf(ErrorStatus.NO_CONNECTION, ErrorStatus.TIMEOUT), error.getStatus()) && this.this$0.getAdapter().getItemCount() == 0) {
            LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(R.id.ll_connection_error);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "ll_connection_error");
            linearLayout.setVisibility(0);
        }
        Toast.makeText(this.this$0.getContext(), String.valueOf(error != null ? error.getError() : null), 1).show();
    }
}

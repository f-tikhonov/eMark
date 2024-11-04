package kz.sapasoft.emark.app.ui.projects;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.domain.model.ProjectModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kz.sapasoft.emark.app.ui.projects.ProjectsViewModel$getProjects$1", f = "ProjectsViewModel.kt", i = {0}, l = {73}, m = "invokeSuspend", n = {"$this$launchIO"}, s = {"L$0"})
/* compiled from: ProjectsViewModel.kt */
final class ProjectsViewModel$getProjects$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ ProjectsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProjectsViewModel$getProjects$1(ProjectsViewModel projectsViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = projectsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ProjectsViewModel$getProjects$1 projectsViewModel$getProjects$1 = new ProjectsViewModel$getProjects$1(this.this$0, continuation);
        projectsViewModel$getProjects$1.p$ = (CoroutineScope) obj;
        return projectsViewModel$getProjects$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ProjectsViewModel$getProjects$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            this.this$0.isRefreshing().postValue(Boxing.boxBoolean(true));
            if (this.this$0.prefsImpl.getOffline()) {
                List<ProjectModel> findAll = this.this$0.projectRepository.findAll();
                this.this$0.projectsAll.addAll(findAll);
                this.this$0.getProjectsData().postValue(findAll);
                this.this$0.isRefreshing().postValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            BaseCloudRepository access$getBaseCloudRepository$p = this.this$0.baseCloudRepository;
            ProjectsViewModel projectsViewModel = this.this$0;
            int access$getPageProject$p = projectsViewModel.pageProject;
            projectsViewModel.pageProject = access$getPageProject$p + 1;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = access$getBaseCloudRepository$p.getProjectList(access$getPageProject$p, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultWrapper resultWrapper = (ResultWrapper) obj;
        if (resultWrapper instanceof ResultWrapper.Error) {
            this.this$0.getError().postValue(resultWrapper);
        } else if (resultWrapper instanceof ResultWrapper.Success) {
            ResultWrapper.Success success = (ResultWrapper.Success) resultWrapper;
            if (!((Collection) success.getValue()).isEmpty()) {
                this.this$0.projectsAll.addAll((Collection) success.getValue());
                this.this$0.getProjects();
            } else {
                this.this$0.getProjectsData().postValue(this.this$0.projectsAll);
            }
        }
        this.this$0.isRefreshing().postValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}

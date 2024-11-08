/*
package kz.sapasoft.emark.app.ui.settings;

import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "kz.sapasoft.emark.app.ui.settings.SettingsViewModel$getTemplateList$1", f = "SettingsViewModel.kt", i = {0, 0, 0}, l = {99}, m = "invokeSuspend", n = {"$this$launchIO", "templateIds", "projectEntityList"}, s = {"L$0", "L$1", "L$2"})
*/
/* compiled from: SettingsViewModel.kt *//*

final class SettingsViewModel$getTemplateList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private CoroutineScope p$;
    final */
/* synthetic *//*
 SettingsViewModel this$0;

    */
/* JADX INFO: super call moved to the top of the method (can break code semantics) *//*

    SettingsViewModel$getTemplateList$1(SettingsViewModel settingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = settingsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SettingsViewModel$getTemplateList$1 settingsViewModel$getTemplateList$1 = new SettingsViewModel$getTemplateList$1(this.this$0, continuation);
        settingsViewModel$getTemplateList$1.p$ = (CoroutineScope) obj;
        return settingsViewModel$getTemplateList$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SettingsViewModel$getTemplateList$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            this.this$0.templateRepository.deleteAll();
            ArrayList arrayList = new ArrayList();
            List<ProjectModel> findAll = this.this$0.projectRepository.findAll();
            for (ProjectModel markerTemplateIds : findAll) {
                arrayList.addAll(markerTemplateIds.getMarkerTemplateIds());
            }
            BaseCloudRepository access$getBaseCloudRepository$p = this.this$0.baseCloudRepository;
            List distinct = CollectionsKt.distinct(arrayList);
            this.L$0 = coroutineScope;
            this.L$1 = arrayList;
            this.L$2 = findAll;
            this.label = 1;
            obj = access$getBaseCloudRepository$p.getTemplateList(distinct, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            List list = (List) this.L$2;
            ArrayList arrayList2 = (ArrayList) this.L$1;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultWrapper resultWrapper = (ResultWrapper) obj;
        if (!(resultWrapper instanceof ResultWrapper.Error) && (resultWrapper instanceof ResultWrapper.Success)) {
            ResultWrapper.Success success = (ResultWrapper.Success) resultWrapper;
            if (!((Collection) success.getValue()).isEmpty()) {
                MutableLiveData<Integer> progress = this.this$0.getProgress();
                Integer value = this.this$0.getProgress().getValue();
                if (value == null) {
                    Intrinsics.throwNpe();
                }
                progress.postValue(Boxing.boxInt(value.intValue() + 100));
                this.this$0.insertTemplateEntityList((List) success.getValue());
            }
        }
        return Unit.INSTANCE;
    }
}
*/

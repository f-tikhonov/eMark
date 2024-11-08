/*
package kz.sapasoft.emark.app.ui.map;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kz.sapasoft.emark.app.ui.map.MapViewModel$getTemplateList$1", f = "MapViewModel.kt", i = {0}, l = {74}, m = "invokeSuspend", n = {"$this$launchIO"}, s = {"L$0"})
*/
/* compiled from: MapViewModel.kt *//*

final class MapViewModel$getTemplateList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final */
/* synthetic *//*
 List $ids;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final */
/* synthetic *//*
 MapViewModel this$0;

    */
/* JADX INFO: super call moved to the top of the method (can break code semantics) *//*

    MapViewModel$getTemplateList$1(MapViewModel mapViewModel, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mapViewModel;
        this.$ids = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        MapViewModel$getTemplateList$1 mapViewModel$getTemplateList$1 = new MapViewModel$getTemplateList$1(this.this$0, this.$ids, continuation);
        mapViewModel$getTemplateList$1.p$ = (CoroutineScope) obj;
        return mapViewModel$getTemplateList$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MapViewModel$getTemplateList$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            if (!this.this$0.prefsImpl.getOffline()) {
                BaseCloudRepository access$getBaseCloudRepository$p = this.this$0.baseCloudRepository;
                List list = this.$ids;
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = access$getBaseCloudRepository$p.getTemplateList(list, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
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
            if (!((Collection) success.value).isEmpty()) {
                this.this$0.insertTemplateEntityList((List) success.value);
            }
        }
        return Unit.INSTANCE;
    }
}
*/

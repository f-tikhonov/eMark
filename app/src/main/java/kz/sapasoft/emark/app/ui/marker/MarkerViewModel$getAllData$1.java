/*
package kz.sapasoft.emark.app.ui.marker;

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
import kz.sapasoft.emark.app.domain.model.MarkerModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kz.sapasoft.emark.app.ui.marker.MarkerViewModel$getAllData$1", f = "MarkerViewModel.kt", i = {0}, l = {50}, m = "invokeSuspend", n = {"$this$launchIO"}, s = {"L$0"})
*/
/* compiled from: MarkerViewModel.kt *//*

final class MarkerViewModel$getAllData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final */
/* synthetic *//*
 MarkerModel $markerModel;
    final */
/* synthetic *//*
 List $markerTemplateIds;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final */
/* synthetic *//*
 MarkerViewModel this$0;

    */
/* JADX INFO: super call moved to the top of the method (can break code semantics) *//*

    MarkerViewModel$getAllData$1(MarkerViewModel markerViewModel, List list, MarkerModel markerModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = markerViewModel;
        this.$markerTemplateIds = list;
        this.$markerModel = markerModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        MarkerViewModel$getAllData$1 markerViewModel$getAllData$1 = new MarkerViewModel$getAllData$1(this.this$0, this.$markerTemplateIds, this.$markerModel, continuation);
        markerViewModel$getAllData$1.p$ = (CoroutineScope) obj;
        return markerViewModel$getAllData$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MarkerViewModel$getAllData$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            this.this$0.getTagList();
            this.this$0.getTemplateList(this.$markerTemplateIds);
            MarkerViewModel markerViewModel = this.this$0;
            MarkerModel markerModel = this.$markerModel;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (markerViewModel.getMarker(markerModel, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
*/

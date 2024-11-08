/*
package kz.sapasoft.emark.app.ui.marker;

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
import kz.sapasoft.emark.app.data.local.room.image.ImageRepository;
import kz.sapasoft.emark.app.domain.model.MarkerModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kz.sapasoft.emark.app.ui.marker.MarkerViewModel$deleteLocal$1", f = "MarkerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
*/
/* compiled from: MarkerViewModel.kt *//*

final class MarkerViewModel$deleteLocal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final */
/* synthetic *//*
 MarkerModel $markerModel;
    int label;
    private CoroutineScope p$;
    final */
/* synthetic *//*
 MarkerViewModel this$0;

    */
/* JADX INFO: super call moved to the top of the method (can break code semantics) *//*

    MarkerViewModel$deleteLocal$1(MarkerViewModel markerViewModel, MarkerModel markerModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = markerViewModel;
        this.$markerModel = markerModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        MarkerViewModel$deleteLocal$1 markerViewModel$deleteLocal$1 = new MarkerViewModel$deleteLocal$1(this.this$0, this.$markerModel, continuation);
        markerViewModel$deleteLocal$1.p$ = (CoroutineScope) obj;
        return markerViewModel$deleteLocal$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MarkerViewModel$deleteLocal$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.markerSyncRepository.deleteById(this.$markerModel.getId());
            ImageRepository access$getImageRepository$p = this.this$0.imageRepository;
            String idLocal = this.$markerModel.idLocal;
            if (idLocal == null) {
                Intrinsics.throwNpe();
            }
            access$getImageRepository$p.deleteByLocalIdParent(idLocal);
            this.this$0.getMarkerChangeTask().postValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
*/

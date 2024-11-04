package kz.sapasoft.emark.app.data.cloud.repository;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.data.cloud.rest.ApiService;
import kz.sapasoft.emark.app.domain.model.MarkerModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kz.sapasoft.emark.app.data.cloud.repository.CloudRepository$getMarker$2", f = "CloudRepository.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CloudRepository.kt */
final class CloudRepository$getMarker$2 extends SuspendLambda implements Function1<Continuation<? super MarkerModel>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ CloudRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudRepository$getMarker$2(CloudRepository cloudRepository, String str, Continuation continuation) {
        super(1, continuation);
        this.this$0 = cloudRepository;
        this.$id = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        return new CloudRepository$getMarker$2(this.this$0, this.$id, continuation);
    }

    public final Object invoke(Object obj) {
        return ((CloudRepository$getMarker$2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ApiService access$getApIs$p = this.this$0.apIs;
            String str = this.$id;
            this.label = 1;
            obj = access$getApIs$p.getMarker(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}

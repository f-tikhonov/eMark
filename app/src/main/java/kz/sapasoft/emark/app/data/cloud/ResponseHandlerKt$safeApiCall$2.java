package kz.sapasoft.emark.app.data.cloud;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kz.sapasoft.emark.app.core.App;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;
import kz.sapasoft.emark.app.domain.model.response.ErrorStatus;
import kz.ss.emark.R;
import retrofit2.HttpException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper;", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kz.sapasoft.emark.app.data.cloud.ResponseHandlerKt$safeApiCall$2", f = "ResponseHandler.kt", i = {0}, l = {20}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
/* compiled from: ResponseHandler.kt */
abstract class ResponseHandlerKt$safeApiCall$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResultWrapper<? extends T>>, Object> {
    final /* synthetic */ Function1 $apiCall;
    Object L$0;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ResponseHandlerKt$safeApiCall$2(Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.$apiCall = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ResponseHandlerKt$safeApiCall$2 responseHandlerKt$safeApiCall$2 = new ResponseHandlerKt$safeApiCall$2(this.$apiCall, continuation);
        responseHandlerKt$safeApiCall$2.p$ = (CoroutineScope) obj;
        return responseHandlerKt$safeApiCall$2;
    }

    public final Object invokeSuspend(Object obj) {
        ResultWrapper.Error error;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            Function1 function1 = this.$apiCall;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                if (th instanceof UnknownHostException) {
                    error = new ResultWrapper.Error(ErrorStatus.NO_CONNECTION, (Integer) null, App.Companion.getInstance().getString(R.string.no_internet_connection));
                } else if (th instanceof HttpException) {
                    HttpException httpException = th;
                    int code = httpException.code();
                    error = new ResultWrapper.Error(ErrorStatus.BAD_RESPONSE, Boxing.boxInt(code), ResponseHandlerKt.convertErrorBody(httpException));
                } else if (th instanceof SocketTimeoutException) {
                    error = new ResultWrapper.Error(ErrorStatus.TIMEOUT, (Integer) null, App.Companion.getInstance().getString(R.string.socket_timeout_exception));
                } else {
                    error = new ResultWrapper.Error(ErrorStatus.NOT_DEFINED, (Integer) null, th.getMessage());
                }
                return error;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return new ResultWrapper.Success(obj);
    }
}

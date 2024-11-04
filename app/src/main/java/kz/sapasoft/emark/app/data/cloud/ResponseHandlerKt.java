package kz.sapasoft.emark.app.data.cloud;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001aC\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"convertErrorBody", "", "throwable", "Lretrofit2/HttpException;", "safeApiCall", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper;", "T", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "apiCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: ResponseHandler.kt */
public final class ResponseHandlerKt {
    public static final <T> Object safeApiCall(CoroutineDispatcher coroutineDispatcher, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super ResultWrapper<? extends T>> continuation) {
        return BuildersKt.withContext(coroutineDispatcher, new ResponseHandlerKt$safeApiCall$2(function1, (Continuation) null), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r6 = r6.errorBody();
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d A[Catch:{ Exception -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e A[Catch:{ Exception -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A[Catch:{ Exception -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final String convertErrorBody(retrofit2.HttpException r6) {
        /*
            r0 = 0
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0064 }
            r1.<init>()     // Catch:{ Exception -> 0x0064 }
            retrofit2.Response r6 = r6.response()     // Catch:{ Exception -> 0x0064 }
            if (r6 == 0) goto L_0x0017
            okhttp3.ResponseBody r6 = r6.errorBody()     // Catch:{ Exception -> 0x0064 }
            if (r6 == 0) goto L_0x0017
            java.lang.String r6 = r6.string()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0018
        L_0x0017:
            r6 = r0
        L_0x0018:
            java.lang.Class<kz.sapasoft.emark.app.domain.model.response.ErrorResponse> r2 = kz.sapasoft.emark.app.domain.model.response.ErrorResponse.class
            java.lang.Object r6 = r1.fromJson((java.lang.String) r6, r2)     // Catch:{ Exception -> 0x0064 }
            kz.sapasoft.emark.app.domain.model.response.ErrorResponse r6 = (kz.sapasoft.emark.app.domain.model.response.ErrorResponse) r6     // Catch:{ Exception -> 0x0064 }
            java.lang.String r1 = r6.getCode()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r6 = r6.getDetails()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r2 = ""
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0064 }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x003a
            int r3 = r3.length()     // Catch:{ Exception -> 0x0064 }
            if (r3 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r3 = 0
            goto L_0x003b
        L_0x003a:
            r3 = 1
        L_0x003b:
            if (r3 != 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0064 }
            if (r2 == 0) goto L_0x004a
            int r2 = r2.length()     // Catch:{ Exception -> 0x0064 }
            if (r2 != 0) goto L_0x004b
        L_0x004a:
            r4 = 1
        L_0x004b:
            if (r4 != 0) goto L_0x0063
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0064 }
            r2.<init>()     // Catch:{ Exception -> 0x0064 }
            r2.append(r1)     // Catch:{ Exception -> 0x0064 }
            r1 = 32
            r2.append(r1)     // Catch:{ Exception -> 0x0064 }
            r2.append(r6)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r6 = r2.toString()     // Catch:{ Exception -> 0x0064 }
            r0 = r6
            goto L_0x0064
        L_0x0063:
            r0 = r1
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.data.cloud.ResponseHandlerKt.convertErrorBody(retrofit2.HttpException):java.lang.String");
    }
}

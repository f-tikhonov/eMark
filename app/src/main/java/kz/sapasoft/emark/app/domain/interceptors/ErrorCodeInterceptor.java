package kz.sapasoft.emark.app.domain.interceptors;

import android.content.Context;
import android.content.Intent;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.ui.welcome.WelcomeActivity;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lkz/sapasoft/emark/app/domain/interceptors/ErrorCodeInterceptor;", "Lokhttp3/Interceptor;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ErrorCodeInterceptor.kt */
public final class ErrorCodeInterceptor implements Interceptor {
    private final Context context;

    public ErrorCodeInterceptor(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        if (proceed.code() == 403) {
            Intent intent = new Intent(this.context, WelcomeActivity.class);
            intent.addFlags(268468224);
            this.context.startActivity(intent);
        }
        return proceed;
    }
}

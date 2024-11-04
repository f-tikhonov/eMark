package kz.sapasoft.emark.app.domain.interceptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kz.sapasoft.emark.app.core.Config;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lkz/sapasoft/emark/app/domain/interceptors/ChangeableBaseUrlInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ChangeableBaseUrlInterceptor.kt */
public final class ChangeableBaseUrlInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Request request = chain.request();
        if (StringsKt.endsWith$default(request.url().encodedPath(), FirebaseAnalytics.Event.LOGIN, false, 2, (Object) null)) {
            return chain.proceed(request);
        }
        HttpUrl parse = HttpUrl.Companion.parse(Config.INSTANCE.getDOMAIN());
        HttpUrl.Builder newBuilder = chain.request().url().newBuilder();
        if (parse == null) {
            Intrinsics.throwNpe();
        }
        URI uri = parse.url().toURI();
        Intrinsics.checkExpressionValueIsNotNull(uri, "domain!!.toUrl().toURI()");
        String host = uri.getHost();
        Intrinsics.checkExpressionValueIsNotNull(host, "domain!!.toUrl().toURI().host");
        HttpUrl.Builder scheme = newBuilder.host(host).port(parse.port()).scheme(parse.scheme());
        StringBuilder sb = new StringBuilder();
        URI uri2 = parse.url().toURI();
        Intrinsics.checkExpressionValueIsNotNull(uri2, "domain.toUrl().toURI()");
        sb.append(uri2.getPath());
        sb.append(request.url().encodedPath());
        return chain.proceed(chain.request().newBuilder().url(scheme.encodedPath(sb.toString()).build()).build());
    }
}

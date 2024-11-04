package kz.sapasoft.emark.app.di.module;

import android.content.Context;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kz.sapasoft.emark.app.core.Config;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.cloud.repository.CloudRepository;
import kz.sapasoft.emark.app.data.cloud.rest.ApiService;
import kz.sapasoft.emark.app.domain.interceptors.ChangeableBaseUrlInterceptor;
import kz.sapasoft.emark.app.domain.interceptors.ErrorCodeInterceptor;
import kz.sapasoft.emark.app.domain.interceptors.SessionCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000fH\u0007¨\u0006\u0015"}, d2 = {"Lkz/sapasoft/emark/app/di/module/NetworkModule;", "", "()V", "provideCloudRepository", "Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;", "apIs", "Lkz/sapasoft/emark/app/data/cloud/rest/ApiService;", "provideService", "retrofit", "Lretrofit2/Retrofit;", "providesGson", "Lcom/google/gson/Gson;", "providesGsonConverterFactory", "Lretrofit2/converter/gson/GsonConverterFactory;", "providesOkHttpClient", "Lokhttp3/OkHttpClient;", "context", "Landroid/content/Context;", "providesRetrofit", "gsonConverterFactory", "okHttpClient", "app_release"}, k = 1, mv = {1, 1, 16})
@Module
/* compiled from: NetworkModule.kt */
public final class NetworkModule {
    @Singleton
    @Provides
    public final Retrofit providesRetrofit(GsonConverterFactory gsonConverterFactory, OkHttpClient okHttpClient) {
        Intrinsics.checkParameterIsNotNull(gsonConverterFactory, "gsonConverterFactory");
        Intrinsics.checkParameterIsNotNull(okHttpClient, "okHttpClient");
        Retrofit build = new Retrofit.Builder().baseUrl(Config.INSTANCE.getDOMAIN()).addConverterFactory(gsonConverterFactory).client(okHttpClient).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Retrofit.Builder()\n     …ent)\n            .build()");
        return build;
    }

    @Singleton
    @Provides
    public final OkHttpClient providesOkHttpClient(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).addInterceptor(new ErrorCodeInterceptor(context)).addInterceptor(new ChangeableBaseUrlInterceptor()).addInterceptor(httpLoggingInterceptor).cookieJar(new SessionCookieJar(context)).build();
    }

    @Singleton
    @Provides
    public final Gson providesGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    public final GsonConverterFactory providesGsonConverterFactory() {
        GsonConverterFactory create = GsonConverterFactory.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "GsonConverterFactory.create()");
        return create;
    }

    @Singleton
    @Provides
    public final ApiService provideService(Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(ApiService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(ApiService::class.java)");
        return (ApiService) create;
    }

    @Singleton
    @Provides
    public final BaseCloudRepository provideCloudRepository(ApiService apiService) {
        Intrinsics.checkParameterIsNotNull(apiService, "apIs");
        return new CloudRepository(apiService, (CoroutineDispatcher) null, 2, (DefaultConstructorMarker) null);
    }
}

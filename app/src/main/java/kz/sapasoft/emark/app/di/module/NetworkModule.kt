package kz.sapasoft.emark.app.di.module

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kz.sapasoft.emark.app.core.Config
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository
import kz.sapasoft.emark.app.data.cloud.repository.CloudRepository
import kz.sapasoft.emark.app.data.cloud.rest.ApiService
import kz.sapasoft.emark.app.domain.interceptors.ChangeableBaseUrlInterceptor
import kz.sapasoft.emark.app.domain.interceptors.ErrorCodeInterceptor
import kz.sapasoft.emark.app.domain.interceptors.SessionCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Config.DOMAIN)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(context: Context): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(ErrorCodeInterceptor(context))
            .addInterceptor(ChangeableBaseUrlInterceptor())
            .addInterceptor(httpLoggingInterceptor)
            .cookieJar(SessionCookieJar(context))
            .build()
    }

    @Singleton
    @Provides
    fun providesGson(): Gson = Gson()

    @Singleton
    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideCloudRepository(apiService: ApiService): BaseCloudRepository {
        return CloudRepository(apiService, Dispatchers.IO)
    }
}
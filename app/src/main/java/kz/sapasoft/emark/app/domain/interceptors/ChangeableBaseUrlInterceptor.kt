package kz.sapasoft.emark.app.domain.interceptors

import com.google.firebase.analytics.FirebaseAnalytics
import kz.sapasoft.emark.app.core.Config
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.net.URI
import kotlin.text.endsWith

class ChangeableBaseUrlInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        // Proceed without modification if the request is for the login endpoint
        if (request.url().encodedPath().endsWith(FirebaseAnalytics.Event.LOGIN, ignoreCase = true)) {
            return chain.proceed(request)
        }

        val domainUrl = HttpUrl.parse(Config.DOMAIN) ?: throw NullPointerException("Domain URL is null")
        val newUrlBuilder = request.url().newBuilder()

        val domainUri = domainUrl.url().toURI()
        val host = domainUri.host ?: throw NullPointerException("Host is null in Domain URL")

        val updatedUrl = newUrlBuilder
            .host(host)
            .port(domainUrl.port())
            .scheme(domainUrl.scheme())
            .encodedPath(domainUri.path + request.url().encodedPath())
            .build()

        return chain.proceed(request.newBuilder().url(updatedUrl).build())
    }
}
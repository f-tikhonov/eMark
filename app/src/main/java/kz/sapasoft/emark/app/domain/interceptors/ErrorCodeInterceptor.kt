package kz.sapasoft.emark.app.domain.interceptors

import android.content.Context
import android.content.Intent
import kz.sapasoft.emark.app.ui.welcome.WelcomeActivity
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ErrorCodeInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        // If response code is 403, redirect to WelcomeActivity
        if (response.code == 403) {
            val intent = Intent(context, WelcomeActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
            context.startActivity(intent)
        }

        return response
    }
}
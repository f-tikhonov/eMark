package kz.sapasoft.emark.app.domain.interceptors

import android.content.Context
import com.google.android.gms.common.internal.ImagesContract
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class SessionCookieJar(private val context: Context) : CookieJar {

    private val mCookies = mutableListOf<Cookie>()

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        val prefsImpl = PrefsImpl(context)
        val cookieValues = cookies.map { it.value }.toSet()

        // Save cookies to shared preferences
       // prefsImpl.setCookie(cookieValues)

        // Update the in-memory cookies
        mCookies.clear()
        mCookies.addAll(cookies)
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        return mCookies
    }
}
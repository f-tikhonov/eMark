package kz.sapasoft.emark.app.data.local.prefs

import android.content.Context
import dagger.internal.Factory
import javax.inject.Provider

class PrefsImpl_Factory(private val appContextProvider: Provider<Context>) : Factory<PrefsImpl> {
    override fun get(): PrefsImpl {
        return newInstance(appContextProvider.get())
    }

    companion object {
        @JvmStatic
        fun create(provider: Provider<Context>): PrefsImpl_Factory {
            return PrefsImpl_Factory(provider)
        }

        fun newInstance(context: Context?): PrefsImpl {
            return PrefsImpl(context)
        }
    }
}

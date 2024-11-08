package kz.sapasoft.emark.app.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import javax.inject.Inject
import kotlin.jvm.internal.Intrinsics

class PrefsImpl @Inject constructor(context: Context?) : Prefs {
    private val ACTIVE_MARKER = "ACTIVE_MARKER"
    private val COOKIE = "COOKIE"
    private val DATE_DB = "DATE_DB"
    private val MARKER_SIZE = "MARKER_SIZE"
    private val OFFLINE_MODE = "OFFLINE_MODE"
    private val PASSIVE_MARKER = "PASSIVE_MARKER"
    private val PASSWORD = "PASSWORD"
    private val SERVER = "SERVER"
    private val USERNAME = "USERNAME"
    private val prefs: SharedPreferences

    init {
        Intrinsics.checkParameterIsNotNull(context, "appContext")
        val defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        Intrinsics.checkExpressionValueIsNotNull(
            defaultSharedPreferences,
            "PreferenceManager.getDef…edPreferences(appContext)"
        )
        prefs = defaultSharedPreferences
    }

    override var username: String?
        get() = prefs.getString(USERNAME, null as String?)
        set(str) {
            Intrinsics.checkParameterIsNotNull(str, "username")
            val edit = prefs.edit()
            edit.putString(USERNAME, str)
            edit.apply()
        }
    override var password: String?
        get() = prefs.getString(PASSWORD, null as String?)
        set(str) {
            Intrinsics.checkParameterIsNotNull(str, "password")
            val edit = prefs.edit()
            edit.putString(PASSWORD, str)
            edit.apply()
        }
    override var server: String?
        get() = prefs.getString(SERVER, null as String?)
        set(str) {
            Intrinsics.checkParameterIsNotNull(str, "server")
            val edit = prefs.edit()
            edit.putString(SERVER, str)
            edit.apply()
        }
    override var cookie: Set<String?>?
        get() {
            val stringSet = prefs.getStringSet(COOKIE, emptySet())
            return stringSet ?: emptySet<String>()
        }
        set(set) {
            Intrinsics.checkParameterIsNotNull(set, "cookie")
            val edit = prefs.edit()
            edit.putStringSet(COOKIE, set)
            edit.apply()
        }
    override var dateDB: String?
        get() = prefs.getString(DATE_DB, null as String?)
        set(str) {
            Intrinsics.checkParameterIsNotNull(str, "date")
            val edit = prefs.edit()
            edit.putString(DATE_DB, str)
            edit.apply()
        }
    override var active: String?
        get() = prefs.getString(ACTIVE_MARKER, null as String?)
        set(str) {
            Intrinsics.checkParameterIsNotNull(str, "date")
            val edit = prefs.edit()
            edit.putString(ACTIVE_MARKER, str)
            edit.apply()
        }
    override var passive: String?
        get() = prefs.getString(PASSIVE_MARKER, null as String?)
        set(str) {
            Intrinsics.checkParameterIsNotNull(str, "date")
            val edit = prefs.edit()
            edit.putString(PASSIVE_MARKER, str)
            edit.apply()
        }
    override var offline: Boolean
        get() = prefs.getBoolean(OFFLINE_MODE, false)
        set(z) {
            val edit = prefs.edit()
            edit.putBoolean(OFFLINE_MODE, z)
            edit.apply()
        }
    override var markerSize: Float
        get() = prefs.getFloat(MARKER_SIZE, 20.0f)
        set(f) {
            val edit = prefs.edit()
            edit.putFloat(MARKER_SIZE, f)
            edit.apply()
        }
}

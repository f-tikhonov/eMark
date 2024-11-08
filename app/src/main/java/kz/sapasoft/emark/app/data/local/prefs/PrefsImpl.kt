package kz.sapasoft.emark.app.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0016\u0010 \u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0016H\u0016J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0018H\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0006H\u0016J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;", "Lkz/sapasoft/emark/app/data/local/prefs/Prefs;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "ACTIVE_MARKER", "", "COOKIE", "DATE_DB", "MARKER_SIZE", "OFFLINE_MODE", "PASSIVE_MARKER", "PASSWORD", "SERVER", "USERNAME", "prefs", "Landroid/content/SharedPreferences;", "getActive", "getCookie", "", "getDateDB", "getMarkerSize", "", "getOffline", "", "getPassive", "getPassword", "getServer", "getUsername", "setActive", "", "date", "setCookie", "cookie", "setDateDB", "setMarkerSize", "size", "setOffline", "isOffline", "setPassive", "setPassword", "password", "setServer", "server", "setUsername", "username", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PrefsImpl.kt */
public final class PrefsImpl implements Prefs {
    private final String ACTIVE_MARKER = "ACTIVE_MARKER";
    private final String COOKIE = "COOKIE";
    private final String DATE_DB = "DATE_DB";
    private final String MARKER_SIZE = "MARKER_SIZE";
    private final String OFFLINE_MODE = "OFFLINE_MODE";
    private final String PASSIVE_MARKER = "PASSIVE_MARKER";
    private final String PASSWORD = "PASSWORD";
    private final String SERVER = "SERVER";
    private final String USERNAME = "USERNAME";
    private final SharedPreferences prefs;

    @Inject
    public PrefsImpl(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "appContext");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, "PreferenceManager.getDef…edPreferences(appContext)");
        this.prefs = defaultSharedPreferences;
    }

    public void setUsername(String str) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putString(this.USERNAME, str);
        edit.apply();
    }

    public String getUsername() {
        return this.prefs.getString(this.USERNAME, (String) null);
    }

    public void setPassword(String str) {
        Intrinsics.checkParameterIsNotNull(str, "password");
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putString(this.PASSWORD, str);
        edit.apply();
    }

    public String getPassword() {
        return this.prefs.getString(this.PASSWORD, (String) null);
    }

    public void setServer(String str) {
        Intrinsics.checkParameterIsNotNull(str, "server");
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putString(this.SERVER, str);
        edit.apply();
    }

    public String getServer() {
        return this.prefs.getString(this.SERVER, (String) null);
    }

    public void setCookie(Set<String> set) {
        Intrinsics.checkParameterIsNotNull(set, "cookie");
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putStringSet(this.COOKIE, set);
        edit.apply();
    }

    public Set<String> getCookie() {
        Set<String> stringSet = this.prefs.getStringSet(this.COOKIE, SetsKt.emptySet());
        return stringSet != null ? stringSet : SetsKt.emptySet();
    }

    public void setDateDB(String str) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putString(this.DATE_DB, str);
        edit.apply();
    }

    public String getDateDB() {
        return this.prefs.getString(this.DATE_DB, (String) null);
    }

    public void setActive(String str) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putString(this.ACTIVE_MARKER, str);
        edit.apply();
    }

    public String getActive() {
        return this.prefs.getString(this.ACTIVE_MARKER, (String) null);
    }

    public void setPassive(String str) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putString(this.PASSIVE_MARKER, str);
        edit.apply();
    }

    public String getPassive() {
        return this.prefs.getString(this.PASSIVE_MARKER, (String) null);
    }

    public void setOffline(boolean z) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putBoolean(this.OFFLINE_MODE, z);
        edit.apply();
    }

    public boolean getOffline() {
        return this.prefs.getBoolean(this.OFFLINE_MODE, false);
    }

    public void setMarkerSize(float f) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putFloat(this.MARKER_SIZE, f);
        edit.apply();
    }

    public float getMarkerSize() {
        return this.prefs.getFloat(this.MARKER_SIZE, 20.0f);
    }
}

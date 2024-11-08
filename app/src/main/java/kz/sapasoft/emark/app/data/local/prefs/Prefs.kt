package kz.sapasoft.emark.app.data.local.prefs;

import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H&J\u0016\u0010\u0012\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\bH&J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\nH&J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0003H&J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0003H&J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0003H&¨\u0006 "}, d2 = {"Lkz/sapasoft/emark/app/data/local/prefs/Prefs;", "", "getActive", "", "getCookie", "", "getDateDB", "getMarkerSize", "", "getOffline", "", "getPassive", "getPassword", "getServer", "getUsername", "setActive", "", "date", "setCookie", "cookie", "setDateDB", "setMarkerSize", "size", "setOffline", "isOffline", "setPassive", "setPassword", "password", "setServer", "server", "setUsername", "username", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Prefs.kt */
public interface Prefs {
    String getActive();

    Set<String> getCookie();

    String getDateDB();

    float getMarkerSize();

    boolean getOffline();

    String getPassive();

    String getPassword();

    String getServer();

    String getUsername();

    void setActive(String str);

    void setCookie(Set<String> set);

    void setDateDB(String str);

    void setMarkerSize(float f);

    void setOffline(boolean z);

    void setPassive(String str);

    void setPassword(String str);

    void setServer(String str);

    void setUsername(String str);
}

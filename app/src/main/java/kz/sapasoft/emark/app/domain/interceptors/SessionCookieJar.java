package kz.sapasoft.emark.app.domain.interceptors;

import android.content.Context;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkz/sapasoft/emark/app/domain/interceptors/SessionCookieJar;", "Lokhttp3/CookieJar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mCookies", "Ljava/util/ArrayList;", "Lokhttp3/Cookie;", "Lkotlin/collections/ArrayList;", "loadForRequest", "", "url", "Lokhttp3/HttpUrl;", "saveFromResponse", "", "cookies", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SessionCookieJar.kt */
public final class SessionCookieJar implements CookieJar {
    private final Context context;
    private final ArrayList<Cookie> mCookies = new ArrayList<>();

    public SessionCookieJar(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        Intrinsics.checkParameterIsNotNull(httpUrl, ImagesContract.URL);
        Intrinsics.checkParameterIsNotNull(list, "cookies");
        PrefsImpl prefsImpl = new PrefsImpl(this.context);
        Iterable<Cookie> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Cookie value : iterable) {
            arrayList.add(value.value());
        }
        prefsImpl.setCookie(CollectionsKt.toSet((List) arrayList));
        this.mCookies.clear();
        this.mCookies.addAll(list);
    }

    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        Intrinsics.checkParameterIsNotNull(httpUrl, ImagesContract.URL);
        return this.mCookies;
    }
}

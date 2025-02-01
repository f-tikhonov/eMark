package kz.sapasoft.emark.app.utils;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lkz/sapasoft/emark/app/utils/GlideUrlHelper;", "", "()V", "getUrl", "Lcom/bumptech/glide/load/model/GlideUrl;", "url", "", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GlideUrlHelper.kt */
public final class GlideUrlHelper {
    public static final GlideUrlHelper INSTANCE = new GlideUrlHelper();

    private GlideUrlHelper() {
    }

    public final GlideUrl getUrl(String str, Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        PrefsImpl prefsImpl = new PrefsImpl(context);
        LazyHeaders.Builder builder = new LazyHeaders.Builder();
        for (String str2 : prefsImpl.getCookie()) {
            builder.addHeader("Cookie", "JSESSIONID=" + str2);
        }
        return new GlideUrl(str, (Headers) builder.build());
    }
}

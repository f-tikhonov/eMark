package kz.sapasoft.emark.app.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkz/sapasoft/emark/app/core/Config;", "", "()V", "DOMAIN", "", "getDOMAIN", "()Ljava/lang/String;", "setDOMAIN", "(Ljava/lang/String;)V", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Config.kt */
public final class Config {
    private static String DOMAIN = "http://asdf.kz:80";
    public static final Config INSTANCE = new Config();

    private Config() {
    }

    public final String getDOMAIN() {
        return DOMAIN;
    }

    public final void setDOMAIN(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        DOMAIN = str;
    }
}

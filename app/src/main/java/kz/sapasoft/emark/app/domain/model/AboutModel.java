package kz.sapasoft.emark.app.domain.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/AboutModel;", "", "info", "", "(Ljava/lang/String;)V", "getInfo", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AboutModel.kt */
public final class AboutModel {
    @SerializedName("info")
    private final String info;

    public static /* synthetic */ AboutModel copy$default(AboutModel aboutModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aboutModel.info;
        }
        return aboutModel.copy(str);
    }

    public final String component1() {
        return this.info;
    }

    public final AboutModel copy(String str) {
        return new AboutModel(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof AboutModel) && Intrinsics.areEqual((Object) this.info, (Object) ((AboutModel) obj).info);
        }
        return true;
    }

    public int hashCode() {
        String str = this.info;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AboutModel(info=" + this.info + ")";
    }

    public AboutModel(String str) {
        this.info = str;
    }

    public final String getInfo() {
        return this.info;
    }
}

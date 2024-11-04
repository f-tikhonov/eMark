package kz.sapasoft.emark.app.domain.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/LoginModel;", "Ljava/io/Serializable;", "status", "", "error", "", "message", "(ILjava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getMessage", "getStatus", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LoginModel.kt */
public final class LoginModel implements Serializable {
    @SerializedName("error")
    private final String error;
    @SerializedName("message")
    private final String message;
    @SerializedName("status")
    private final int status;

    public static /* synthetic */ LoginModel copy$default(LoginModel loginModel, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = loginModel.status;
        }
        if ((i2 & 2) != 0) {
            str = loginModel.error;
        }
        if ((i2 & 4) != 0) {
            str2 = loginModel.message;
        }
        return loginModel.copy(i, str, str2);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.error;
    }

    public final String component3() {
        return this.message;
    }

    public final LoginModel copy(int i, String str, String str2) {
        return new LoginModel(i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginModel)) {
            return false;
        }
        LoginModel loginModel = (LoginModel) obj;
        return this.status == loginModel.status && Intrinsics.areEqual((Object) this.error, (Object) loginModel.error) && Intrinsics.areEqual((Object) this.message, (Object) loginModel.message);
    }

    public int hashCode() {
        int i = this.status * 31;
        String str = this.error;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "LoginModel(status=" + this.status + ", error=" + this.error + ", message=" + this.message + ")";
    }

    public LoginModel(int i, String str, String str2) {
        this.status = i;
        this.error = str;
        this.message = str2;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getError() {
        return this.error;
    }

    public final String getMessage() {
        return this.message;
    }
}

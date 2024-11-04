package kz.sapasoft.emark.app.domain.model.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J0\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/response/ErrorModel;", "", "message", "", "code", "", "errorStatus", "Lkz/sapasoft/emark/app/domain/model/response/ErrorStatus;", "(Ljava/lang/String;Ljava/lang/Integer;Lkz/sapasoft/emark/app/domain/model/response/ErrorStatus;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorStatus", "()Lkz/sapasoft/emark/app/domain/model/response/ErrorStatus;", "setErrorStatus", "(Lkz/sapasoft/emark/app/domain/model/response/ErrorStatus;)V", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lkz/sapasoft/emark/app/domain/model/response/ErrorStatus;)Lkz/sapasoft/emark/app/domain/model/response/ErrorModel;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ErrorModel.kt */
public final class ErrorModel {
    private final Integer code;
    private transient ErrorStatus errorStatus;
    private final String message;

    public static /* synthetic */ ErrorModel copy$default(ErrorModel errorModel, String str, Integer num, ErrorStatus errorStatus2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorModel.message;
        }
        if ((i & 2) != 0) {
            num = errorModel.code;
        }
        if ((i & 4) != 0) {
            errorStatus2 = errorModel.errorStatus;
        }
        return errorModel.copy(str, num, errorStatus2);
    }

    public final String component1() {
        return this.message;
    }

    public final Integer component2() {
        return this.code;
    }

    public final ErrorStatus component3() {
        return this.errorStatus;
    }

    public final ErrorModel copy(String str, Integer num, ErrorStatus errorStatus2) {
        Intrinsics.checkParameterIsNotNull(errorStatus2, "errorStatus");
        return new ErrorModel(str, num, errorStatus2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorModel)) {
            return false;
        }
        ErrorModel errorModel = (ErrorModel) obj;
        return Intrinsics.areEqual((Object) this.message, (Object) errorModel.message) && Intrinsics.areEqual((Object) this.code, (Object) errorModel.code) && Intrinsics.areEqual((Object) this.errorStatus, (Object) errorModel.errorStatus);
    }

    public int hashCode() {
        String str = this.message;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.code;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        ErrorStatus errorStatus2 = this.errorStatus;
        if (errorStatus2 != null) {
            i = errorStatus2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ErrorModel(message=" + this.message + ", code=" + this.code + ", errorStatus=" + this.errorStatus + ")";
    }

    public ErrorModel(String str, Integer num, ErrorStatus errorStatus2) {
        Intrinsics.checkParameterIsNotNull(errorStatus2, "errorStatus");
        this.message = str;
        this.code = num;
        this.errorStatus = errorStatus2;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final ErrorStatus getErrorStatus() {
        return this.errorStatus;
    }

    public final void setErrorStatus(ErrorStatus errorStatus2) {
        Intrinsics.checkParameterIsNotNull(errorStatus2, "<set-?>");
        this.errorStatus = errorStatus2;
    }
}

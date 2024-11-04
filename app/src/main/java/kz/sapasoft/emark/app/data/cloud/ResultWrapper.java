package kz.sapasoft.emark.app.data.cloud;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.domain.model.response.ErrorStatus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lkz/sapasoft/emark/app/data/cloud/ResultWrapper;", "T", "", "()V", "Error", "Success", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Success;", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Error;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ResultWrapper.kt */
public abstract class ResultWrapper<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Success;", "T", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ResultWrapper.kt */
    public static final class Success<T> extends ResultWrapper<T> {
        private final T value;

        public static /* synthetic */ Success copy$default(Success success, T t, int i, Object obj) {
            if ((i & 1) != 0) {
                t = success.value;
            }
            return success.copy(t);
        }

        public final T component1() {
            return this.value;
        }

        public final Success<T> copy(T t) {
            return new Success<>(t);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Success) && Intrinsics.areEqual((Object) this.value, (Object) ((Success) obj).value);
            }
            return true;
        }

        public int hashCode() {
            T t = this.value;
            if (t != null) {
                return t.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Success(value=" + this.value + ")";
        }

        public Success(T t) {
            super((DefaultConstructorMarker) null);
            this.value = t;
        }

        public final T getValue() {
            return this.value;
        }
    }

    private ResultWrapper() {
    }

    public /* synthetic */ ResultWrapper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Error;", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper;", "", "status", "Lkz/sapasoft/emark/app/domain/model/response/ErrorStatus;", "code", "", "error", "", "(Lkz/sapasoft/emark/app/domain/model/response/ErrorStatus;Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getError", "()Ljava/lang/String;", "getStatus", "()Lkz/sapasoft/emark/app/domain/model/response/ErrorStatus;", "component1", "component2", "component3", "copy", "(Lkz/sapasoft/emark/app/domain/model/response/ErrorStatus;Ljava/lang/Integer;Ljava/lang/String;)Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Error;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ResultWrapper.kt */
    public static final class Error extends ResultWrapper {
        private final Integer code;
        private final String error;
        private final ErrorStatus status;

        public Error() {
            this((ErrorStatus) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Error copy$default(Error error2, ErrorStatus errorStatus, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                errorStatus = error2.status;
            }
            if ((i & 2) != 0) {
                num = error2.code;
            }
            if ((i & 4) != 0) {
                str = error2.error;
            }
            return error2.copy(errorStatus, num, str);
        }

        public final ErrorStatus component1() {
            return this.status;
        }

        public final Integer component2() {
            return this.code;
        }

        public final String component3() {
            return this.error;
        }

        public final Error copy(ErrorStatus errorStatus, Integer num, String str) {
            return new Error(errorStatus, num, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error2 = (Error) obj;
            return Intrinsics.areEqual((Object) this.status, (Object) error2.status) && Intrinsics.areEqual((Object) this.code, (Object) error2.code) && Intrinsics.areEqual((Object) this.error, (Object) error2.error);
        }

        public int hashCode() {
            ErrorStatus errorStatus = this.status;
            int i = 0;
            int hashCode = (errorStatus != null ? errorStatus.hashCode() : 0) * 31;
            Integer num = this.code;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.error;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Error(status=" + this.status + ", code=" + this.code + ", error=" + this.error + ")";
        }

        public Error(ErrorStatus errorStatus, Integer num, String str) {
            super((DefaultConstructorMarker) null);
            this.status = errorStatus;
            this.code = num;
            this.error = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Error(ErrorStatus errorStatus, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : errorStatus, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str);
        }

        public final Integer getCode() {
            return this.code;
        }

        public final String getError() {
            return this.error;
        }

        public final ErrorStatus getStatus() {
            return this.status;
        }
    }
}

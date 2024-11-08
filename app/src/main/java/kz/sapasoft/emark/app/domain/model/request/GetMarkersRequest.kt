package kz.sapasoft.emark.app.domain.model.request;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/request/GetMarkersRequest;", "", "offset", "", "limit", "privilege", "", "projectIds", "", "lineIds", "(IILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getLimit", "()I", "getLineIds", "()Ljava/util/List;", "getOffset", "getPrivilege", "()Ljava/lang/String;", "getProjectIds", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GetMarkersRequest.kt */
public final class GetMarkersRequest {
    private final int limit;
    private final List<String> lineIds;
    private final int offset;
    private final String privilege;
    private final List<String> projectIds;

    public static /* synthetic */ GetMarkersRequest copy$default(GetMarkersRequest getMarkersRequest, int i, int i2, String str, List<String> list, List<String> list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = getMarkersRequest.offset;
        }
        if ((i3 & 2) != 0) {
            i2 = getMarkersRequest.limit;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = getMarkersRequest.privilege;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            list = getMarkersRequest.projectIds;
        }
        List<String> list3 = list;
        if ((i3 & 16) != 0) {
            list2 = getMarkersRequest.lineIds;
        }
        return getMarkersRequest.copy(i, i4, str2, list3, list2);
    }

    public final int component1() {
        return this.offset;
    }

    public final int component2() {
        return this.limit;
    }

    public final String component3() {
        return this.privilege;
    }

    public final List<String> component4() {
        return this.projectIds;
    }

    public final List<String> component5() {
        return this.lineIds;
    }

    public final GetMarkersRequest copy(int i, int i2, String str, List<String> list, List<String> list2) {
        Intrinsics.checkParameterIsNotNull(str, "privilege");
        Intrinsics.checkParameterIsNotNull(list, "projectIds");
        Intrinsics.checkParameterIsNotNull(list2, "lineIds");
        return new GetMarkersRequest(i, i2, str, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetMarkersRequest)) {
            return false;
        }
        GetMarkersRequest getMarkersRequest = (GetMarkersRequest) obj;
        return this.offset == getMarkersRequest.offset && this.limit == getMarkersRequest.limit && Intrinsics.areEqual((Object) this.privilege, (Object) getMarkersRequest.privilege) && Intrinsics.areEqual((Object) this.projectIds, (Object) getMarkersRequest.projectIds) && Intrinsics.areEqual((Object) this.lineIds, (Object) getMarkersRequest.lineIds);
    }

    public int hashCode() {
        int i = ((this.offset * 31) + this.limit) * 31;
        String str = this.privilege;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<String> list = this.projectIds;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.lineIds;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "GetMarkersRequest(offset=" + this.offset + ", limit=" + this.limit + ", privilege=" + this.privilege + ", projectIds=" + this.projectIds + ", lineIds=" + this.lineIds + ")";
    }

    public GetMarkersRequest(int i, int i2, String str, List<String> list, List<String> list2) {
        Intrinsics.checkParameterIsNotNull(str, "privilege");
        Intrinsics.checkParameterIsNotNull(list, "projectIds");
        Intrinsics.checkParameterIsNotNull(list2, "lineIds");
        this.offset = i;
        this.limit = i2;
        this.privilege = str;
        this.projectIds = list;
        this.lineIds = list2;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getPrivilege() {
        return this.privilege;
    }

    public final List<String> getProjectIds() {
        return this.projectIds;
    }

    public final List<String> getLineIds() {
        return this.lineIds;
    }
}

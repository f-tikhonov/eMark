package kz.sapasoft.emark.app.domain.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u001d"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/PhotoModel;", "Ljava/io/Serializable;", "id", "", "markerTemplateIds", "", "url", "regionName", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getMarkerTemplateIds", "()Ljava/util/List;", "getRegionName", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PhotoModel.kt */
public final class PhotoModel implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private String f47id;
    private final List<String> markerTemplateIds;
    private final String regionName;
    private final String url;

    public static /* synthetic */ PhotoModel copy$default(PhotoModel photoModel, String str, List<String> list, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = photoModel.f47id;
        }
        if ((i & 2) != 0) {
            list = photoModel.markerTemplateIds;
        }
        if ((i & 4) != 0) {
            str2 = photoModel.url;
        }
        if ((i & 8) != 0) {
            str3 = photoModel.regionName;
        }
        return photoModel.copy(str, list, str2, str3);
    }

    public final String component1() {
        return this.f47id;
    }

    public final List<String> component2() {
        return this.markerTemplateIds;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.regionName;
    }

    public final PhotoModel copy(String str, List<String> list, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        return new PhotoModel(str, list, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoModel)) {
            return false;
        }
        PhotoModel photoModel = (PhotoModel) obj;
        return Intrinsics.areEqual((Object) this.f47id, (Object) photoModel.f47id) && Intrinsics.areEqual((Object) this.markerTemplateIds, (Object) photoModel.markerTemplateIds) && Intrinsics.areEqual((Object) this.url, (Object) photoModel.url) && Intrinsics.areEqual((Object) this.regionName, (Object) photoModel.regionName);
    }

    public int hashCode() {
        String str = this.f47id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.markerTemplateIds;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.url;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.regionName;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "PhotoModel(id=" + this.f47id + ", markerTemplateIds=" + this.markerTemplateIds + ", url=" + this.url + ", regionName=" + this.regionName + ")";
    }

    public PhotoModel(String str, List<String> list, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        this.f47id = str;
        this.markerTemplateIds = list;
        this.url = str2;
        this.regionName = str3;
    }

    public final String getId() {
        return this.f47id;
    }

    public final void setId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f47id = str;
    }

    public final List<String> getMarkerTemplateIds() {
        return this.markerTemplateIds;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getRegionName() {
        return this.regionName;
    }
}

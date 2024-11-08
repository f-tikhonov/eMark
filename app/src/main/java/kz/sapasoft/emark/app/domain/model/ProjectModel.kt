package kz.sapasoft.emark.app.domain.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u001d"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "Ljava/io/Serializable;", "id", "", "markerTemplateIds", "", "name", "regionName", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getMarkerTemplateIds", "()Ljava/util/List;", "getName", "getRegionName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ProjectModel.kt */
public final class ProjectModel implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private String f48id;
    private final List<String> markerTemplateIds;
    private final String name;
    private final String regionName;

    public static /* synthetic */ ProjectModel copy$default(ProjectModel projectModel, String str, List<String> list, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = projectModel.f48id;
        }
        if ((i & 2) != 0) {
            list = projectModel.markerTemplateIds;
        }
        if ((i & 4) != 0) {
            str2 = projectModel.name;
        }
        if ((i & 8) != 0) {
            str3 = projectModel.regionName;
        }
        return projectModel.copy(str, list, str2, str3);
    }

    public final String component1() {
        return this.f48id;
    }

    public final List<String> component2() {
        return this.markerTemplateIds;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.regionName;
    }

    public final ProjectModel copy(String str, List<String> list, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(list, "markerTemplateIds");
        Intrinsics.checkParameterIsNotNull(str2, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(str3, "regionName");
        return new ProjectModel(str, list, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProjectModel)) {
            return false;
        }
        ProjectModel projectModel = (ProjectModel) obj;
        return Intrinsics.areEqual((Object) this.f48id, (Object) projectModel.f48id) && Intrinsics.areEqual((Object) this.markerTemplateIds, (Object) projectModel.markerTemplateIds) && Intrinsics.areEqual((Object) this.name, (Object) projectModel.name) && Intrinsics.areEqual((Object) this.regionName, (Object) projectModel.regionName);
    }

    public int hashCode() {
        String str = this.f48id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.markerTemplateIds;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.regionName;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ProjectModel(id=" + this.f48id + ", markerTemplateIds=" + this.markerTemplateIds + ", name=" + this.name + ", regionName=" + this.regionName + ")";
    }

    public ProjectModel(String str, List<String> list, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(list, "markerTemplateIds");
        Intrinsics.checkParameterIsNotNull(str2, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(str3, "regionName");
        this.f48id = str;
        this.markerTemplateIds = list;
        this.name = str2;
        this.regionName = str3;
    }

    public final String getId() {
        return this.f48id;
    }

    public final void setId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f48id = str;
    }

    public final List<String> getMarkerTemplateIds() {
        return this.markerTemplateIds;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRegionName() {
        return this.regionName;
    }
}

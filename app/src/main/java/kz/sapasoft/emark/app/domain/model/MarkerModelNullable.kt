package kz.sapasoft.emark.app.domain.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.utils.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010C\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fHÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010>J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJÔ\u0001\u0010Q\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010VHÖ\u0003J\t\u0010W\u001a\u00020XHÖ\u0001J\t\u0010Y\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0019\"\u0004\b4\u0010\u001bR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010\u001bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006Z"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/MarkerModelNullable;", "Ljava/io/Serializable;", "id", "", "updated", "", "templateId", "markerId", "markerModel", "color", "passiveId", "projectIds", "", "depth", "", "location", "fields", "Lkz/sapasoft/emark/app/domain/model/FieldModel;", "generalId", "markerType", "idLocal", "status", "Lkz/sapasoft/emark/app/utils/Constants$MarkerStatus;", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkz/sapasoft/emark/app/utils/Constants$MarkerStatus;)V", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "getDepth", "()Ljava/lang/Double;", "setDepth", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getFields", "()Ljava/util/List;", "setFields", "(Ljava/util/List;)V", "getGeneralId", "setGeneralId", "getId", "setId", "getIdLocal", "setIdLocal", "getLocation", "setLocation", "getMarkerId", "setMarkerId", "getMarkerModel", "setMarkerModel", "getMarkerType", "setMarkerType", "getPassiveId", "setPassiveId", "getProjectIds", "setProjectIds", "getStatus", "()Lkz/sapasoft/emark/app/utils/Constants$MarkerStatus;", "setStatus", "(Lkz/sapasoft/emark/app/utils/Constants$MarkerStatus;)V", "getTemplateId", "setTemplateId", "getUpdated", "()Ljava/lang/Long;", "setUpdated", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkz/sapasoft/emark/app/utils/Constants$MarkerStatus;)Lkz/sapasoft/emark/app/domain/model/MarkerModelNullable;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MarkerModelNullable.kt */
public final class MarkerModelNullable implements Serializable {
    private String color;
    private Double depth;
    private List<FieldModel> fields;
    private String generalId;

    /* renamed from: id  reason: collision with root package name */
    private String f45id;
    private String idLocal;
    private List<Double> location;
    private String markerId;
    private String markerModel;
    private String markerType;
    private String passiveId;
    private List<String> projectIds;
    private Constants.MarkerStatus status;
    private String templateId;
    private Long updated;

    public static /* synthetic */ MarkerModelNullable copy$default(MarkerModelNullable markerModelNullable, String str, Long l, String str2, String str3, String str4, String str5, String str6, List list, Double d, List list2, List list3, String str7, String str8, String str9, Constants.MarkerStatus markerStatus, int i, Object obj) {
        MarkerModelNullable markerModelNullable2 = markerModelNullable;
        int i2 = i;
        return markerModelNullable.copy((i2 & 1) != 0 ? markerModelNullable2.f45id : str, (i2 & 2) != 0 ? markerModelNullable2.updated : l, (i2 & 4) != 0 ? markerModelNullable2.templateId : str2, (i2 & 8) != 0 ? markerModelNullable2.markerId : str3, (i2 & 16) != 0 ? markerModelNullable2.markerModel : str4, (i2 & 32) != 0 ? markerModelNullable2.color : str5, (i2 & 64) != 0 ? markerModelNullable2.passiveId : str6, (i2 & 128) != 0 ? markerModelNullable2.projectIds : list, (i2 & 256) != 0 ? markerModelNullable2.depth : d, (i2 & 512) != 0 ? markerModelNullable2.location : list2, (i2 & 1024) != 0 ? markerModelNullable2.fields : list3, (i2 & 2048) != 0 ? markerModelNullable2.generalId : str7, (i2 & 4096) != 0 ? markerModelNullable2.markerType : str8, (i2 & 8192) != 0 ? markerModelNullable2.idLocal : str9, (i2 & 16384) != 0 ? markerModelNullable2.status : markerStatus);
    }

    public final String component1() {
        return this.f45id;
    }

    public final List<Double> component10() {
        return this.location;
    }

    public final List<FieldModel> component11() {
        return this.fields;
    }

    public final String component12() {
        return this.generalId;
    }

    public final String component13() {
        return this.markerType;
    }

    public final String component14() {
        return this.idLocal;
    }

    public final Constants.MarkerStatus component15() {
        return this.status;
    }

    public final Long component2() {
        return this.updated;
    }

    public final String component3() {
        return this.templateId;
    }

    public final String component4() {
        return this.markerId;
    }

    public final String component5() {
        return this.markerModel;
    }

    public final String component6() {
        return this.color;
    }

    public final String component7() {
        return this.passiveId;
    }

    public final List<String> component8() {
        return this.projectIds;
    }

    public final Double component9() {
        return this.depth;
    }

    public final MarkerModelNullable copy(String str, Long l, String str2, String str3, String str4, String str5, String str6, List<String> list, Double d, List<Double> list2, List<FieldModel> list3, String str7, String str8, String str9, Constants.MarkerStatus markerStatus) {
        return new MarkerModelNullable(str, l, str2, str3, str4, str5, str6, list, d, list2, list3, str7, str8, str9, markerStatus);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MarkerModelNullable)) {
            return false;
        }
        MarkerModelNullable markerModelNullable = (MarkerModelNullable) obj;
        return Intrinsics.areEqual((Object) this.f45id, (Object) markerModelNullable.f45id) && Intrinsics.areEqual((Object) this.updated, (Object) markerModelNullable.updated) && Intrinsics.areEqual((Object) this.templateId, (Object) markerModelNullable.templateId) && Intrinsics.areEqual((Object) this.markerId, (Object) markerModelNullable.markerId) && Intrinsics.areEqual((Object) this.markerModel, (Object) markerModelNullable.markerModel) && Intrinsics.areEqual((Object) this.color, (Object) markerModelNullable.color) && Intrinsics.areEqual((Object) this.passiveId, (Object) markerModelNullable.passiveId) && Intrinsics.areEqual((Object) this.projectIds, (Object) markerModelNullable.projectIds) && Intrinsics.areEqual((Object) this.depth, (Object) markerModelNullable.depth) && Intrinsics.areEqual((Object) this.location, (Object) markerModelNullable.location) && Intrinsics.areEqual((Object) this.fields, (Object) markerModelNullable.fields) && Intrinsics.areEqual((Object) this.generalId, (Object) markerModelNullable.generalId) && Intrinsics.areEqual((Object) this.markerType, (Object) markerModelNullable.markerType) && Intrinsics.areEqual((Object) this.idLocal, (Object) markerModelNullable.idLocal) && Intrinsics.areEqual((Object) this.status, (Object) markerModelNullable.status);
    }

    public int hashCode() {
        String str = this.f45id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.updated;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.templateId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.markerId;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.markerModel;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.color;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.passiveId;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        List<String> list = this.projectIds;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        Double d = this.depth;
        int hashCode9 = (hashCode8 + (d != null ? d.hashCode() : 0)) * 31;
        List<Double> list2 = this.location;
        int hashCode10 = (hashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<FieldModel> list3 = this.fields;
        int hashCode11 = (hashCode10 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str7 = this.generalId;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.markerType;
        int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.idLocal;
        int hashCode14 = (hashCode13 + (str9 != null ? str9.hashCode() : 0)) * 31;
        Constants.MarkerStatus markerStatus = this.status;
        if (markerStatus != null) {
            i = markerStatus.hashCode();
        }
        return hashCode14 + i;
    }

    public String toString() {
        return "MarkerModelNullable(id=" + this.f45id + ", updated=" + this.updated + ", templateId=" + this.templateId + ", markerId=" + this.markerId + ", markerModel=" + this.markerModel + ", color=" + this.color + ", passiveId=" + this.passiveId + ", projectIds=" + this.projectIds + ", depth=" + this.depth + ", location=" + this.location + ", fields=" + this.fields + ", generalId=" + this.generalId + ", markerType=" + this.markerType + ", idLocal=" + this.idLocal + ", status=" + this.status + ")";
    }

    public MarkerModelNullable(String str, Long l, String str2, String str3, String str4, String str5, String str6, List<String> list, Double d, List<Double> list2, List<FieldModel> list3, String str7, String str8, String str9, Constants.MarkerStatus markerStatus) {
        this.f45id = str;
        this.updated = l;
        this.templateId = str2;
        this.markerId = str3;
        this.markerModel = str4;
        this.color = str5;
        this.passiveId = str6;
        this.projectIds = list;
        this.depth = d;
        this.location = list2;
        this.fields = list3;
        this.generalId = str7;
        this.markerType = str8;
        this.idLocal = str9;
        this.status = markerStatus;
    }

    public final String getId() {
        return this.f45id;
    }

    public final void setId(String str) {
        this.f45id = str;
    }

    public final Long getUpdated() {
        return this.updated;
    }

    public final void setUpdated(Long l) {
        this.updated = l;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void setTemplateId(String str) {
        this.templateId = str;
    }

    public final String getMarkerId() {
        return this.markerId;
    }

    public final void setMarkerId(String str) {
        this.markerId = str;
    }

    public final String getMarkerModel() {
        return this.markerModel;
    }

    public final void setMarkerModel(String str) {
        this.markerModel = str;
    }

    public final String getColor() {
        return this.color;
    }

    public final void setColor(String str) {
        this.color = str;
    }

    public final String getPassiveId() {
        return this.passiveId;
    }

    public final void setPassiveId(String str) {
        this.passiveId = str;
    }

    public final List<String> getProjectIds() {
        return this.projectIds;
    }

    public final void setProjectIds(List<String> list) {
        this.projectIds = list;
    }

    public final Double getDepth() {
        return this.depth;
    }

    public final void setDepth(Double d) {
        this.depth = d;
    }

    public final List<Double> getLocation() {
        return this.location;
    }

    public final void setLocation(List<Double> list) {
        this.location = list;
    }

    public final List<FieldModel> getFields() {
        return this.fields;
    }

    public final void setFields(List<FieldModel> list) {
        this.fields = list;
    }

    public final String getGeneralId() {
        return this.generalId;
    }

    public final void setGeneralId(String str) {
        this.generalId = str;
    }

    public final String getMarkerType() {
        return this.markerType;
    }

    public final void setMarkerType(String str) {
        this.markerType = str;
    }

    public final String getIdLocal() {
        return this.idLocal;
    }

    public final void setIdLocal(String str) {
        this.idLocal = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MarkerModelNullable(String str, Long l, String str2, String str3, String str4, String str5, String str6, List list, Double d, List list2, List list3, String str7, String str8, String str9, Constants.MarkerStatus markerStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l, str2, str3, str4, str5, str6, list, d, list2, list3, str7, str8, str9, (i & 16384) != 0 ? Constants.MarkerStatus.NORMAL : markerStatus);
    }

    public final Constants.MarkerStatus getStatus() {
        return this.status;
    }

    public final void setStatus(Constants.MarkerStatus markerStatus) {
        this.status = markerStatus;
    }
}

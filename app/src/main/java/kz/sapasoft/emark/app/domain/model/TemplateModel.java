package kz.sapasoft.emark.app.domain.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0002\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\nHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J«\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006;"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "Ljava/io/Serializable;", "id", "", "createdById", "created", "", "updatedById", "updated", "privileges", "", "frontData", "name", "descr", "fields", "Lkz/sapasoft/emark/app/domain/model/FieldModel;", "color", "markerModels", "", "markerTypes", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "getColor", "()Ljava/lang/String;", "getCreated", "()J", "getCreatedById", "getDescr", "getFields", "()Ljava/util/List;", "getFrontData", "getId", "getMarkerModels", "()Ljava/util/Map;", "getMarkerTypes", "getName", "getPrivileges", "getUpdated", "getUpdatedById", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: TemplateModel.kt */
public final class TemplateModel implements Serializable {
    private final String color;
    private final long created;
    private final String createdById;
    private final String descr;
    private final List<FieldModel> fields;
    private final String frontData;

    /* renamed from: id  reason: collision with root package name */
    private final String f50id;
    private final Map<String, String> markerModels;
    private final List<String> markerTypes;
    private final String name;
    private final List<String> privileges;
    private final long updated;
    private final String updatedById;

    public static /* synthetic */ TemplateModel copy$default(TemplateModel templateModel, String str, String str2, long j, String str3, long j2, List list, String str4, String str5, String str6, List list2, String str7, Map map, List list3, int i, Object obj) {
        TemplateModel templateModel2 = templateModel;
        int i2 = i;
        return templateModel.copy((i2 & 1) != 0 ? templateModel2.f50id : str, (i2 & 2) != 0 ? templateModel2.createdById : str2, (i2 & 4) != 0 ? templateModel2.created : j, (i2 & 8) != 0 ? templateModel2.updatedById : str3, (i2 & 16) != 0 ? templateModel2.updated : j2, (i2 & 32) != 0 ? templateModel2.privileges : list, (i2 & 64) != 0 ? templateModel2.frontData : str4, (i2 & 128) != 0 ? templateModel2.name : str5, (i2 & 256) != 0 ? templateModel2.descr : str6, (i2 & 512) != 0 ? templateModel2.fields : list2, (i2 & 1024) != 0 ? templateModel2.color : str7, (i2 & 2048) != 0 ? templateModel2.markerModels : map, (i2 & 4096) != 0 ? templateModel2.markerTypes : list3);
    }

    public final String component1() {
        return this.f50id;
    }

    public final List<FieldModel> component10() {
        return this.fields;
    }

    public final String component11() {
        return this.color;
    }

    public final Map<String, String> component12() {
        return this.markerModels;
    }

    public final List<String> component13() {
        return this.markerTypes;
    }

    public final String component2() {
        return this.createdById;
    }

    public final long component3() {
        return this.created;
    }

    public final String component4() {
        return this.updatedById;
    }

    public final long component5() {
        return this.updated;
    }

    public final List<String> component6() {
        return this.privileges;
    }

    public final String component7() {
        return this.frontData;
    }

    public final String component8() {
        return this.name;
    }

    public final String component9() {
        return this.descr;
    }

    public final TemplateModel copy(String str, String str2, long j, String str3, long j2, List<String> list, String str4, String str5, String str6, List<FieldModel> list2, String str7, Map<String, String> map, List<String> list3) {
        String str8 = str;
        Intrinsics.checkParameterIsNotNull(str8, "id");
        String str9 = str2;
        Intrinsics.checkParameterIsNotNull(str9, "createdById");
        List<String> list4 = list;
        Intrinsics.checkParameterIsNotNull(list4, "privileges");
        String str10 = str4;
        Intrinsics.checkParameterIsNotNull(str10, "frontData");
        String str11 = str5;
        Intrinsics.checkParameterIsNotNull(str11, AppMeasurementSdk.ConditionalUserProperty.NAME);
        String str12 = str6;
        Intrinsics.checkParameterIsNotNull(str12, "descr");
        List<FieldModel> list5 = list2;
        Intrinsics.checkParameterIsNotNull(list5, "fields");
        String str13 = str7;
        Intrinsics.checkParameterIsNotNull(str13, "color");
        Map<String, String> map2 = map;
        Intrinsics.checkParameterIsNotNull(map2, "markerModels");
        Intrinsics.checkParameterIsNotNull(list3, "markerTypes");
        return new TemplateModel(str8, str9, j, str3, j2, list4, str10, str11, str12, list5, str13, map2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TemplateModel)) {
            return false;
        }
        TemplateModel templateModel = (TemplateModel) obj;
        return Intrinsics.areEqual((Object) this.f50id, (Object) templateModel.f50id) && Intrinsics.areEqual((Object) this.createdById, (Object) templateModel.createdById) && this.created == templateModel.created && Intrinsics.areEqual((Object) this.updatedById, (Object) templateModel.updatedById) && this.updated == templateModel.updated && Intrinsics.areEqual((Object) this.privileges, (Object) templateModel.privileges) && Intrinsics.areEqual((Object) this.frontData, (Object) templateModel.frontData) && Intrinsics.areEqual((Object) this.name, (Object) templateModel.name) && Intrinsics.areEqual((Object) this.descr, (Object) templateModel.descr) && Intrinsics.areEqual((Object) this.fields, (Object) templateModel.fields) && Intrinsics.areEqual((Object) this.color, (Object) templateModel.color) && Intrinsics.areEqual((Object) this.markerModels, (Object) templateModel.markerModels) && Intrinsics.areEqual((Object) this.markerTypes, (Object) templateModel.markerTypes);
    }

    public int hashCode() {
        String str = this.f50id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.createdById;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.created)) * 31;
        String str3 = this.updatedById;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.updated)) * 31;
        List<String> list = this.privileges;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str4 = this.frontData;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.name;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.descr;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        List<FieldModel> list2 = this.fields;
        int hashCode8 = (hashCode7 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str7 = this.color;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Map<String, String> map = this.markerModels;
        int hashCode10 = (hashCode9 + (map != null ? map.hashCode() : 0)) * 31;
        List<String> list3 = this.markerTypes;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        return "TemplateModel(id=" + this.f50id + ", createdById=" + this.createdById + ", created=" + this.created + ", updatedById=" + this.updatedById + ", updated=" + this.updated + ", privileges=" + this.privileges + ", frontData=" + this.frontData + ", name=" + this.name + ", descr=" + this.descr + ", fields=" + this.fields + ", color=" + this.color + ", markerModels=" + this.markerModels + ", markerTypes=" + this.markerTypes + ")";
    }

    public TemplateModel(String str, String str2, long j, String str3, long j2, List<String> list, String str4, String str5, String str6, List<FieldModel> list2, String str7, Map<String, String> map, List<String> list3) {
        List<String> list4 = list;
        String str8 = str4;
        String str9 = str5;
        String str10 = str6;
        List<FieldModel> list5 = list2;
        String str11 = str7;
        Map<String, String> map2 = map;
        List<String> list6 = list3;
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "createdById");
        Intrinsics.checkParameterIsNotNull(list4, "privileges");
        Intrinsics.checkParameterIsNotNull(str8, "frontData");
        Intrinsics.checkParameterIsNotNull(str9, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(str10, "descr");
        Intrinsics.checkParameterIsNotNull(list5, "fields");
        Intrinsics.checkParameterIsNotNull(str11, "color");
        Intrinsics.checkParameterIsNotNull(map2, "markerModels");
        Intrinsics.checkParameterIsNotNull(list6, "markerTypes");
        this.f50id = str;
        this.createdById = str2;
        this.created = j;
        this.updatedById = str3;
        this.updated = j2;
        this.privileges = list4;
        this.frontData = str8;
        this.name = str9;
        this.descr = str10;
        this.fields = list5;
        this.color = str11;
        this.markerModels = map2;
        this.markerTypes = list6;
    }

    public final String getId() {
        return this.f50id;
    }

    public final String getCreatedById() {
        return this.createdById;
    }

    public final long getCreated() {
        return this.created;
    }

    public final String getUpdatedById() {
        return this.updatedById;
    }

    public final long getUpdated() {
        return this.updated;
    }

    public final List<String> getPrivileges() {
        return this.privileges;
    }

    public final String getFrontData() {
        return this.frontData;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescr() {
        return this.descr;
    }

    public final List<FieldModel> getFields() {
        return this.fields;
    }

    public final String getColor() {
        return this.color;
    }

    public final Map<String, String> getMarkerModels() {
        return this.markerModels;
    }

    public final List<String> getMarkerTypes() {
        return this.markerTypes;
    }
}

package kz.sapasoft.emark.app.domain.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BÍ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001bJ\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010D\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010I\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jþ\u0001\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u000e2\b\u0010Y\u001a\u0004\u0018\u00010ZHÖ\u0003J\t\u0010[\u001a\u00020\\HÖ\u0001J\b\u0010]\u001a\u00020\u0003H\u0016R \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\"\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b$\u0010!\"\u0004\b%\u0010&R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b0\u0010!\"\u0004\b1\u0010&R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b7\u00105R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001dR \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010\u001fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b?\u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001dR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001d¨\u0006^"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/FieldModel;", "Ljava/io/Serializable;", "createdById", "", "created", "", "updatedById", "updated", "privileges", "frontData", "id", "name", "descr", "required", "", "readonly", "fieldWidget", "valueType", "textValue", "longValue", "doubleValue", "", "boolValue", "tagTemplateId", "tagValue", "Lkz/sapasoft/emark/app/domain/model/TagModel;", "dateValue", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Lkz/sapasoft/emark/app/domain/model/TagModel;Ljava/lang/Long;)V", "getBoolValue", "()Ljava/lang/String;", "setBoolValue", "(Ljava/lang/String;)V", "getCreated", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreatedById", "getDateValue", "setDateValue", "(Ljava/lang/Long;)V", "getDescr", "getDoubleValue", "()Ljava/lang/Double;", "setDoubleValue", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getFieldWidget", "getFrontData", "getId", "getLongValue", "setLongValue", "getName", "getPrivileges", "getReadonly", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRequired", "getTagTemplateId", "getTagValue", "()Lkz/sapasoft/emark/app/domain/model/TagModel;", "setTagValue", "(Lkz/sapasoft/emark/app/domain/model/TagModel;)V", "getTextValue", "setTextValue", "getUpdated", "getUpdatedById", "getValueType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Lkz/sapasoft/emark/app/domain/model/TagModel;Ljava/lang/Long;)Lkz/sapasoft/emark/app/domain/model/FieldModel;", "equals", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FieldModel.kt */
public final class FieldModel implements Serializable {
    @SerializedName("boolValue")
    private String boolValue;
    @SerializedName("created")
    private final Long created;
    @SerializedName("createdById")
    private final String createdById;
    @SerializedName("dateValue")
    private Long dateValue;
    @SerializedName("descr")
    private final String descr;
    @SerializedName("doubleValue")
    private Double doubleValue;
    @SerializedName("fieldWidget")
    private final String fieldWidget;
    @SerializedName("frontData")
    private final String frontData;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    private final String f42id;
    @SerializedName("longValue")
    private Long longValue;
    @SerializedName("name")
    private final String name;
    @SerializedName("privileges")
    private final String privileges;
    @SerializedName("readonly")
    private final Boolean readonly;
    @SerializedName("required")
    private final Boolean required;
    @SerializedName("tagTemplateId")
    private final String tagTemplateId;
    @SerializedName("tagValue")
    private TagModel tagValue;
    @SerializedName("textValue")
    private String textValue;
    @SerializedName("updated")
    private final Long updated;
    @SerializedName("updatedById")
    private final String updatedById;
    @SerializedName("valueType")
    private final String valueType;

    public static /* synthetic */ FieldModel copy$default(FieldModel fieldModel, String str, Long l, String str2, Long l2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, String str8, String str9, String str10, Long l3, Double d, String str11, String str12, TagModel tagModel, Long l4, int i, Object obj) {
        FieldModel fieldModel2 = fieldModel;
        int i2 = i;
        return fieldModel.copy((i2 & 1) != 0 ? fieldModel2.createdById : str, (i2 & 2) != 0 ? fieldModel2.created : l, (i2 & 4) != 0 ? fieldModel2.updatedById : str2, (i2 & 8) != 0 ? fieldModel2.updated : l2, (i2 & 16) != 0 ? fieldModel2.privileges : str3, (i2 & 32) != 0 ? fieldModel2.frontData : str4, (i2 & 64) != 0 ? fieldModel2.f42id : str5, (i2 & 128) != 0 ? fieldModel2.name : str6, (i2 & 256) != 0 ? fieldModel2.descr : str7, (i2 & 512) != 0 ? fieldModel2.required : bool, (i2 & 1024) != 0 ? fieldModel2.readonly : bool2, (i2 & 2048) != 0 ? fieldModel2.fieldWidget : str8, (i2 & 4096) != 0 ? fieldModel2.valueType : str9, (i2 & 8192) != 0 ? fieldModel2.textValue : str10, (i2 & 16384) != 0 ? fieldModel2.longValue : l3, (i2 & 32768) != 0 ? fieldModel2.doubleValue : d, (i2 & 65536) != 0 ? fieldModel2.boolValue : str11, (i2 & 131072) != 0 ? fieldModel2.tagTemplateId : str12, (i2 & 262144) != 0 ? fieldModel2.tagValue : tagModel, (i2 & 524288) != 0 ? fieldModel2.dateValue : l4);
    }

    public final String component1() {
        return this.createdById;
    }

    public final Boolean component10() {
        return this.required;
    }

    public final Boolean component11() {
        return this.readonly;
    }

    public final String component12() {
        return this.fieldWidget;
    }

    public final String component13() {
        return this.valueType;
    }

    public final String component14() {
        return this.textValue;
    }

    public final Long component15() {
        return this.longValue;
    }

    public final Double component16() {
        return this.doubleValue;
    }

    public final String component17() {
        return this.boolValue;
    }

    public final String component18() {
        return this.tagTemplateId;
    }

    public final TagModel component19() {
        return this.tagValue;
    }

    public final Long component2() {
        return this.created;
    }

    public final Long component20() {
        return this.dateValue;
    }

    public final String component3() {
        return this.updatedById;
    }

    public final Long component4() {
        return this.updated;
    }

    public final String component5() {
        return this.privileges;
    }

    public final String component6() {
        return this.frontData;
    }

    public final String component7() {
        return this.f42id;
    }

    public final String component8() {
        return this.name;
    }

    public final String component9() {
        return this.descr;
    }

    public final FieldModel copy(String str, Long l, String str2, Long l2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, String str8, String str9, String str10, Long l3, Double d, String str11, String str12, TagModel tagModel, Long l4) {
        return new FieldModel(str, l, str2, l2, str3, str4, str5, str6, str7, bool, bool2, str8, str9, str10, l3, d, str11, str12, tagModel, l4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldModel)) {
            return false;
        }
        FieldModel fieldModel = (FieldModel) obj;
        return Intrinsics.areEqual((Object) this.createdById, (Object) fieldModel.createdById) && Intrinsics.areEqual((Object) this.created, (Object) fieldModel.created) && Intrinsics.areEqual((Object) this.updatedById, (Object) fieldModel.updatedById) && Intrinsics.areEqual((Object) this.updated, (Object) fieldModel.updated) && Intrinsics.areEqual((Object) this.privileges, (Object) fieldModel.privileges) && Intrinsics.areEqual((Object) this.frontData, (Object) fieldModel.frontData) && Intrinsics.areEqual((Object) this.f42id, (Object) fieldModel.f42id) && Intrinsics.areEqual((Object) this.name, (Object) fieldModel.name) && Intrinsics.areEqual((Object) this.descr, (Object) fieldModel.descr) && Intrinsics.areEqual((Object) this.required, (Object) fieldModel.required) && Intrinsics.areEqual((Object) this.readonly, (Object) fieldModel.readonly) && Intrinsics.areEqual((Object) this.fieldWidget, (Object) fieldModel.fieldWidget) && Intrinsics.areEqual((Object) this.valueType, (Object) fieldModel.valueType) && Intrinsics.areEqual((Object) this.textValue, (Object) fieldModel.textValue) && Intrinsics.areEqual((Object) this.longValue, (Object) fieldModel.longValue) && Intrinsics.areEqual((Object) this.doubleValue, (Object) fieldModel.doubleValue) && Intrinsics.areEqual((Object) this.boolValue, (Object) fieldModel.boolValue) && Intrinsics.areEqual((Object) this.tagTemplateId, (Object) fieldModel.tagTemplateId) && Intrinsics.areEqual((Object) this.tagValue, (Object) fieldModel.tagValue) && Intrinsics.areEqual((Object) this.dateValue, (Object) fieldModel.dateValue);
    }

    public int hashCode() {
        String str = this.createdById;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.created;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.updatedById;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l2 = this.updated;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str3 = this.privileges;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.frontData;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f42id;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.name;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.descr;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Boolean bool = this.required;
        int hashCode10 = (hashCode9 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.readonly;
        int hashCode11 = (hashCode10 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str8 = this.fieldWidget;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.valueType;
        int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.textValue;
        int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 31;
        Long l3 = this.longValue;
        int hashCode15 = (hashCode14 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Double d = this.doubleValue;
        int hashCode16 = (hashCode15 + (d != null ? d.hashCode() : 0)) * 31;
        String str11 = this.boolValue;
        int hashCode17 = (hashCode16 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.tagTemplateId;
        int hashCode18 = (hashCode17 + (str12 != null ? str12.hashCode() : 0)) * 31;
        TagModel tagModel = this.tagValue;
        int hashCode19 = (hashCode18 + (tagModel != null ? tagModel.hashCode() : 0)) * 31;
        Long l4 = this.dateValue;
        if (l4 != null) {
            i = l4.hashCode();
        }
        return hashCode19 + i;
    }

    public FieldModel(String str, Long l, String str2, Long l2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, String str8, String str9, String str10, Long l3, Double d, String str11, String str12, TagModel tagModel, Long l4) {
        this.createdById = str;
        this.created = l;
        this.updatedById = str2;
        this.updated = l2;
        this.privileges = str3;
        this.frontData = str4;
        this.f42id = str5;
        this.name = str6;
        this.descr = str7;
        this.required = bool;
        this.readonly = bool2;
        this.fieldWidget = str8;
        this.valueType = str9;
        this.textValue = str10;
        this.longValue = l3;
        this.doubleValue = d;
        this.boolValue = str11;
        this.tagTemplateId = str12;
        this.tagValue = tagModel;
        this.dateValue = l4;
    }

    public final String getCreatedById() {
        return this.createdById;
    }

    public final Long getCreated() {
        return this.created;
    }

    public final String getUpdatedById() {
        return this.updatedById;
    }

    public final Long getUpdated() {
        return this.updated;
    }

    public final String getPrivileges() {
        return this.privileges;
    }

    public final String getFrontData() {
        return this.frontData;
    }

    public final String getId() {
        return this.f42id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescr() {
        return this.descr;
    }

    public final Boolean getRequired() {
        return this.required;
    }

    public final Boolean getReadonly() {
        return this.readonly;
    }

    public final String getFieldWidget() {
        return this.fieldWidget;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public final String getTextValue() {
        return this.textValue;
    }

    public final void setTextValue(String str) {
        this.textValue = str;
    }

    public final Long getLongValue() {
        return this.longValue;
    }

    public final void setLongValue(Long l) {
        this.longValue = l;
    }

    public final Double getDoubleValue() {
        return this.doubleValue;
    }

    public final void setDoubleValue(Double d) {
        this.doubleValue = d;
    }

    public final String getBoolValue() {
        return this.boolValue;
    }

    public final void setBoolValue(String str) {
        this.boolValue = str;
    }

    public final String getTagTemplateId() {
        return this.tagTemplateId;
    }

    public final TagModel getTagValue() {
        return this.tagValue;
    }

    public final void setTagValue(TagModel tagModel) {
        this.tagValue = tagModel;
    }

    public final Long getDateValue() {
        return this.dateValue;
    }

    public final void setDateValue(Long l) {
        this.dateValue = l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.textValue);
        sb.append(this.longValue);
        sb.append(this.doubleValue);
        sb.append(this.boolValue);
        TagModel tagModel = this.tagValue;
        sb.append(tagModel != null ? tagModel.getId() : null);
        sb.append(this.dateValue);
        return sb.toString();
    }
}

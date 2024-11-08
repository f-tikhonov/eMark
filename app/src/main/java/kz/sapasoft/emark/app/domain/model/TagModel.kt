package kz.sapasoft.emark.app.domain.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jl\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006)"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/TagModel;", "Ljava/io/Serializable;", "id", "", "createdById", "created", "", "updatedById", "updated", "frontData", "templateId", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreated", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreatedById", "()Ljava/lang/String;", "getFrontData", "getId", "getName", "getTemplateId", "getUpdated", "getUpdatedById", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkz/sapasoft/emark/app/domain/model/TagModel;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: TagModel.kt */
public final class TagModel implements Serializable {
    private final Long created;
    private final String createdById;
    private final String frontData;

    /* renamed from: id  reason: collision with root package name */
    private final String f49id;
    private final String name;
    private final String templateId;
    private final Long updated;
    private final String updatedById;

    public static /* synthetic */ TagModel copy$default(TagModel tagModel, String str, String str2, Long l, String str3, Long l2, String str4, String str5, String str6, int i, Object obj) {
        TagModel tagModel2 = tagModel;
        int i2 = i;
        return tagModel.copy((i2 & 1) != 0 ? tagModel2.f49id : str, (i2 & 2) != 0 ? tagModel2.createdById : str2, (i2 & 4) != 0 ? tagModel2.created : l, (i2 & 8) != 0 ? tagModel2.updatedById : str3, (i2 & 16) != 0 ? tagModel2.updated : l2, (i2 & 32) != 0 ? tagModel2.frontData : str4, (i2 & 64) != 0 ? tagModel2.templateId : str5, (i2 & 128) != 0 ? tagModel2.name : str6);
    }

    public final String component1() {
        return this.f49id;
    }

    public final String component2() {
        return this.createdById;
    }

    public final Long component3() {
        return this.created;
    }

    public final String component4() {
        return this.updatedById;
    }

    public final Long component5() {
        return this.updated;
    }

    public final String component6() {
        return this.frontData;
    }

    public final String component7() {
        return this.templateId;
    }

    public final String component8() {
        return this.name;
    }

    public final TagModel copy(String str, String str2, Long l, String str3, Long l2, String str4, String str5, String str6) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        return new TagModel(str, str2, l, str3, l2, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TagModel)) {
            return false;
        }
        TagModel tagModel = (TagModel) obj;
        return Intrinsics.areEqual((Object) this.f49id, (Object) tagModel.f49id) && Intrinsics.areEqual((Object) this.createdById, (Object) tagModel.createdById) && Intrinsics.areEqual((Object) this.created, (Object) tagModel.created) && Intrinsics.areEqual((Object) this.updatedById, (Object) tagModel.updatedById) && Intrinsics.areEqual((Object) this.updated, (Object) tagModel.updated) && Intrinsics.areEqual((Object) this.frontData, (Object) tagModel.frontData) && Intrinsics.areEqual((Object) this.templateId, (Object) tagModel.templateId) && Intrinsics.areEqual((Object) this.name, (Object) tagModel.name);
    }

    public int hashCode() {
        String str = this.f49id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.createdById;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.created;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        String str3 = this.updatedById;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l2 = this.updated;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str4 = this.frontData;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.templateId;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.name;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "TagModel(id=" + this.f49id + ", createdById=" + this.createdById + ", created=" + this.created + ", updatedById=" + this.updatedById + ", updated=" + this.updated + ", frontData=" + this.frontData + ", templateId=" + this.templateId + ", name=" + this.name + ")";
    }

    public TagModel(String str, String str2, Long l, String str3, Long l2, String str4, String str5, String str6) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        this.f49id = str;
        this.createdById = str2;
        this.created = l;
        this.updatedById = str3;
        this.updated = l2;
        this.frontData = str4;
        this.templateId = str5;
        this.name = str6;
    }

    public final String getId() {
        return this.f49id;
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

    public final String getFrontData() {
        return this.frontData;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final String getName() {
        return this.name;
    }
}

package kz.sapasoft.emark.app.domain.model;

import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001$B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0000\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0018\u00010\u0006R\u00020\u0000HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R$\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u00008\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "Ljava/io/Serializable;", "id", "", "localIdParent", "metadata", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel$MetaData;", "file", "Ljava/io/File;", "(Ljava/lang/String;Ljava/lang/String;Lkz/sapasoft/emark/app/domain/model/ImageDataModel$MetaData;Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getLocalIdParent", "setLocalIdParent", "getMetadata", "()Lkz/sapasoft/emark/app/domain/model/ImageDataModel$MetaData;", "setMetadata", "(Lkz/sapasoft/emark/app/domain/model/ImageDataModel$MetaData;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "MetaData", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ImageDataModel.kt */
public final class ImageDataModel implements Serializable {
    private File file;

    /* renamed from: id  reason: collision with root package name */
    private String f43id;
    private String localIdParent;
    private MetaData metadata;

    public static /* synthetic */ ImageDataModel copy$default(ImageDataModel imageDataModel, String str, String str2, MetaData metaData, File file2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageDataModel.f43id;
        }
        if ((i & 2) != 0) {
            str2 = imageDataModel.localIdParent;
        }
        if ((i & 4) != 0) {
            metaData = imageDataModel.metadata;
        }
        if ((i & 8) != 0) {
            file2 = imageDataModel.file;
        }
        return imageDataModel.copy(str, str2, metaData, file2);
    }

    public final String component1() {
        return this.f43id;
    }

    public final String component2() {
        return this.localIdParent;
    }

    public final MetaData component3() {
        return this.metadata;
    }

    public final File component4() {
        return this.file;
    }

    public final ImageDataModel copy(String str, String str2, MetaData metaData, File file2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        return new ImageDataModel(str, str2, metaData, file2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageDataModel)) {
            return false;
        }
        ImageDataModel imageDataModel = (ImageDataModel) obj;
        return Intrinsics.areEqual((Object) this.f43id, (Object) imageDataModel.f43id) && Intrinsics.areEqual((Object) this.localIdParent, (Object) imageDataModel.localIdParent) && Intrinsics.areEqual((Object) this.metadata, (Object) imageDataModel.metadata) && Intrinsics.areEqual((Object) this.file, (Object) imageDataModel.file);
    }

    public int hashCode() {
        String str = this.f43id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.localIdParent;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        MetaData metaData = this.metadata;
        int hashCode3 = (hashCode2 + (metaData != null ? metaData.hashCode() : 0)) * 31;
        File file2 = this.file;
        if (file2 != null) {
            i = file2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ImageDataModel(id=" + this.f43id + ", localIdParent=" + this.localIdParent + ", metadata=" + this.metadata + ", file=" + this.file + ")";
    }

    public ImageDataModel(String str, String str2, MetaData metaData, File file2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        this.f43id = str;
        this.localIdParent = str2;
        this.metadata = metaData;
        this.file = file2;
    }

    public final String getId() {
        return this.f43id;
    }

    public final void setId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f43id = str;
    }

    public final String getLocalIdParent() {
        return this.localIdParent;
    }

    public final void setLocalIdParent(String str) {
        this.localIdParent = str;
    }

    public final MetaData getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(MetaData metaData) {
        this.metadata = metaData;
    }

    public final File getFile() {
        return this.file;
    }

    public final void setFile(File file2) {
        this.file = file2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/ImageDataModel$MetaData;", "", "parentId", "", "queryKey", "(Lkz/sapasoft/emark/app/domain/model/ImageDataModel;Ljava/lang/String;Ljava/lang/String;)V", "getParentId", "()Ljava/lang/String;", "setParentId", "(Ljava/lang/String;)V", "getQueryKey", "setQueryKey", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ImageDataModel.kt */
    public final class MetaData {
        private String parentId;
        private String queryKey;

        public MetaData(String str, String str2) {
            this.parentId = str;
            this.queryKey = str2;
        }

        public final String getParentId() {
            return this.parentId;
        }

        public final void setParentId(String str) {
            this.parentId = str;
        }

        public final String getQueryKey() {
            return this.queryKey;
        }

        public final void setQueryKey(String str) {
            this.queryKey = str;
        }
    }
}

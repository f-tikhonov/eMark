package kz.sapasoft.emark.app.domain.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/ImageModel;", "Ljava/io/Serializable;", "id_image", "", "id_exhibit", "url", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getId_exhibit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId_image", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lkz/sapasoft/emark/app/domain/model/ImageModel;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ImageModel.kt */
public final class ImageModel implements Serializable {
    @SerializedName("id_exhibit")
    private final Integer id_exhibit;
    @SerializedName("id_image")
    private final Integer id_image;
    @SerializedName("url")
    private final String url;

    public static /* synthetic */ ImageModel copy$default(ImageModel imageModel, Integer num, Integer num2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = imageModel.id_image;
        }
        if ((i & 2) != 0) {
            num2 = imageModel.id_exhibit;
        }
        if ((i & 4) != 0) {
            str = imageModel.url;
        }
        return imageModel.copy(num, num2, str);
    }

    public final Integer component1() {
        return this.id_image;
    }

    public final Integer component2() {
        return this.id_exhibit;
    }

    public final String component3() {
        return this.url;
    }

    public final ImageModel copy(Integer num, Integer num2, String str) {
        return new ImageModel(num, num2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageModel)) {
            return false;
        }
        ImageModel imageModel = (ImageModel) obj;
        return Intrinsics.areEqual((Object) this.id_image, (Object) imageModel.id_image) && Intrinsics.areEqual((Object) this.id_exhibit, (Object) imageModel.id_exhibit) && Intrinsics.areEqual((Object) this.url, (Object) imageModel.url);
    }

    public int hashCode() {
        Integer num = this.id_image;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.id_exhibit;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str = this.url;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ImageModel(id_image=" + this.id_image + ", id_exhibit=" + this.id_exhibit + ", url=" + this.url + ")";
    }

    public ImageModel(Integer num, Integer num2, String str) {
        this.id_image = num;
        this.id_exhibit = num2;
        this.url = str;
    }

    public final Integer getId_image() {
        return this.id_image;
    }

    public final Integer getId_exhibit() {
        return this.id_exhibit;
    }

    public final String getUrl() {
        return this.url;
    }
}

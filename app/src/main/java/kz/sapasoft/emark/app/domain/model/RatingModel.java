package kz.sapasoft.emark.app.domain.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lkz/sapasoft/emark/app/domain/model/RatingModel;", "Ljava/io/Serializable;", "rating", "", "(Ljava/lang/Double;)V", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "copy", "(Ljava/lang/Double;)Lkz/sapasoft/emark/app/domain/model/RatingModel;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: RatingModel.kt */
public final class RatingModel implements Serializable {
    @SerializedName("rating")
    private final Double rating;

    public static /* synthetic */ RatingModel copy$default(RatingModel ratingModel, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            d = ratingModel.rating;
        }
        return ratingModel.copy(d);
    }

    public final Double component1() {
        return this.rating;
    }

    public final RatingModel copy(Double d) {
        return new RatingModel(d);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RatingModel) && Intrinsics.areEqual((Object) this.rating, (Object) ((RatingModel) obj).rating);
        }
        return true;
    }

    public int hashCode() {
        Double d = this.rating;
        if (d != null) {
            return d.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RatingModel(rating=" + this.rating + ")";
    }

    public RatingModel(Double d) {
        this.rating = d;
    }

    public final Double getRating() {
        return this.rating;
    }
}

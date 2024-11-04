package kz.sapasoft.emark.app.ui.photo;

import android.view.View;
import kotlin.Metadata;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;
import kz.sapasoft.emark.app.ui.photo.PhotoAdapter;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "kz/sapasoft/emark/app/ui/photo/PhotoAdapter$SimpleHolder$onBind$1$2"}, k = 3, mv = {1, 1, 16})
/* compiled from: PhotoAdapter.kt */
final class PhotoAdapter$SimpleHolder$onBind$$inlined$with$lambda$2 implements View.OnClickListener {
    final /* synthetic */ ImageDataModel $t$inlined;
    final /* synthetic */ PhotoAdapter.SimpleHolder this$0;

    PhotoAdapter$SimpleHolder$onBind$$inlined$with$lambda$2(PhotoAdapter.SimpleHolder simpleHolder, ImageDataModel imageDataModel) {
        this.this$0 = simpleHolder;
        this.$t$inlined = imageDataModel;
    }

    public final void onClick(View view) {
        this.this$0.this$0.deletePhoto(this.$t$inlined);
    }
}

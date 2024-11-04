package kz.sapasoft.emark.app.ui.photo;

import android.view.View;
import kotlin.Metadata;
import kz.sapasoft.emark.app.ui.photo.PhotoAdapter;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: PhotoAdapter.kt */
final class PhotoAdapter$FooterHolder$onBind$1 implements View.OnClickListener {
    final /* synthetic */ PhotoAdapter.FooterHolder this$0;

    PhotoAdapter$FooterHolder$onBind$1(PhotoAdapter.FooterHolder footerHolder) {
        this.this$0 = footerHolder;
    }

    public final void onClick(View view) {
        this.this$0.this$0.listener.onAddPhotoClick();
    }
}

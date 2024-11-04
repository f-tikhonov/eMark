package kz.sapasoft.emark.app.ui.marker;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import pl.aprilapps.easyphotopicker.EasyImage;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lpl/aprilapps/easyphotopicker/EasyImage;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: MarkerFragment.kt */
final class MarkerFragment$easyImage$2 extends Lambda implements Function0<EasyImage> {
    final /* synthetic */ MarkerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MarkerFragment$easyImage$2(MarkerFragment markerFragment) {
        super(0);
        this.this$0 = markerFragment;
    }

    public final EasyImage invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkExpressionValueIsNotNull(requireContext, "requireContext()");
        return new EasyImage.Builder(requireContext).setCopyImagesToPublicGalleryFolder(false).allowMultiple(false).build();
    }
}

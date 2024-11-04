package kz.sapasoft.emark.app.ui.marker;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.R;
import kz.sapasoft.emark.app.ui.custom_views.MarkerPhotoView;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.MediaFile;
import pl.aprilapps.easyphotopicker.MediaSource;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"kz/sapasoft/emark/app/ui/marker/MarkerFragment$onActivityResult$1", "Lpl/aprilapps/easyphotopicker/DefaultCallback;", "onMediaFilesPicked", "", "imageFiles", "", "Lpl/aprilapps/easyphotopicker/MediaFile;", "source", "Lpl/aprilapps/easyphotopicker/MediaSource;", "([Lpl/aprilapps/easyphotopicker/MediaFile;Lpl/aprilapps/easyphotopicker/MediaSource;)V", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MarkerFragment.kt */
public final class MarkerFragment$onActivityResult$1 extends DefaultCallback {
    final /* synthetic */ MarkerFragment this$0;

    MarkerFragment$onActivityResult$1(MarkerFragment markerFragment) {
        this.this$0 = markerFragment;
    }

    public void onMediaFilesPicked(MediaFile[] mediaFileArr, MediaSource mediaSource) {
        Intrinsics.checkParameterIsNotNull(mediaFileArr, "imageFiles");
        Intrinsics.checkParameterIsNotNull(mediaSource, FirebaseAnalytics.Param.SOURCE);
        ((MarkerPhotoView) this.this$0._$_findCachedViewById(R.id.view_marker_photo)).addImage(mediaFileArr[0]);
    }
}

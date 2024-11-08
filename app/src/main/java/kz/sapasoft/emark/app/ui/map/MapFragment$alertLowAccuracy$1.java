/*
package kz.sapasoft.emark.app.ui.map;

import android.content.DialogInterface;
import android.location.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 1, 16})
*/
/* compiled from: MapFragment.kt *//*

final class MapFragment$alertLowAccuracy$1 implements DialogInterface.OnClickListener {
    final */
/* synthetic *//*
 String $bytesStr;
    final */
/* synthetic *//*
 MapFragment this$0;

    MapFragment$alertLowAccuracy$1(MapFragment mapFragment, String str) {
        this.this$0 = mapFragment;
        this.$bytesStr = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MapViewModel access$getViewModel$p = this.this$0.getViewModel();
        String str = this.$bytesStr;
        Location access$getLocation = this.this$0.getLocation();
        if (access$getLocation == null) {
            Intrinsics.throwNpe();
        }
        this.this$0.openMarkerFragment(access$getViewModel$p.getMakerModelFromByteStr(str, access$getLocation));
        dialogInterface.dismiss();
    }
}
*/

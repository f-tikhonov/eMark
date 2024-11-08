/*
package kz.sapasoft.emark.app.ui.map;

import android.location.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
*/
/* compiled from: MapFragment.kt *//*

final class MapFragment$onReceivedData$1 implements Runnable {
    final */
/* synthetic *//*
 String $bytesStr;
    final */
/* synthetic *//*
 MapFragment this$0;

    MapFragment$onReceivedData$1(MapFragment mapFragment, String str) {
        this.this$0 = mapFragment;
        this.$bytesStr = str;
    }

    public final void run() {
        MapFragment mapFragment = this.this$0;
        String str = this.$bytesStr;
        Location access$getLocation = mapFragment.getLocation();
        if (access$getLocation == null) {
            Intrinsics.throwNpe();
        }
        mapFragment.alertLowAccuracy(str, access$getLocation);
    }
}
*/

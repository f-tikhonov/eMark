package kz.sapasoft.emark.app.ui.map;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "marker", "Lorg/osmdroid/views/overlay/Marker;", "kotlin.jvm.PlatformType", "mapView", "Lorg/osmdroid/views/MapView;", "onMarkerClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: MapFragment.kt */
final class MapFragment$onMarkerClickListener$1 implements Marker.OnMarkerClickListener {
    final /* synthetic */ MapFragment this$0;

    MapFragment$onMarkerClickListener$1(MapFragment mapFragment) {
        this.this$0 = mapFragment;
    }

    public final boolean onMarkerClick(Marker marker, MapView mapView) {
        Object obj;
        Iterator it = this.this$0.mMarkerModelList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            String id2 = ((MarkerModel) obj).getId();
            Intrinsics.checkExpressionValueIsNotNull(marker, "marker");
            if (Intrinsics.areEqual((Object) id2, (Object) marker.getId())) {
                break;
            }
        }
        MarkerModel markerModel = (MarkerModel) obj;
        if (markerModel == null) {
            return false;
        }
        this.this$0.openMarkerFragment(markerModel);
        return false;
    }
}

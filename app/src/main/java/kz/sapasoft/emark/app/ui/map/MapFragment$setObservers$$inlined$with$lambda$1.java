package kz.sapasoft.emark.app.ui.map;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.R;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
//import org.osmdroid.bonuspack.clustering.RadiusMarkerClusterer;
import org.osmdroid.views.MapView;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "kotlin.jvm.PlatformType", "onChanged", "kz/sapasoft/emark/app/ui/map/MapFragment$setObservers$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: MapFragment.kt */
final class MapFragment$setObservers$$inlined$with$lambda$1<T> implements Observer<List<? extends MarkerModel>> {
    final /* synthetic */ MapFragment this$0;

    MapFragment$setObservers$$inlined$with$lambda$1(MapFragment mapFragment) {
        this.this$0 = mapFragment;
    }

    public final void onChanged(List<? extends MarkerModel> list) {
        this.this$0.mMarkerModelList.clear();
        this.this$0.mMarkerList.clear();
        MapView mapView = (MapView) this.this$0._$_findCachedViewById(R.id.map_view);
        Intrinsics.checkExpressionValueIsNotNull(mapView, "map_view");
        mapView.getOverlays().clear();
        MapView mapView2 = (MapView) this.this$0._$_findCachedViewById(R.id.map_view);
        Intrinsics.checkExpressionValueIsNotNull(mapView2, "map_view");
        mapView2.getOverlays().add(this.this$0.mMyLocationOverlay);
        ((MapView) this.this$0._$_findCachedViewById(R.id.map_view)).invalidate();
       // RadiusMarkerClusterer unused = this.this$0.poiMarkers;
        MapFragment mapFragment = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(list, "it");
        mapFragment.addMapMarkers((List<MarkerModel>) list);
    }
}

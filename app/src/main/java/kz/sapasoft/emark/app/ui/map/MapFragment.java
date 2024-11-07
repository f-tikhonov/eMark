package kz.sapasoft.emark.app.ui.map;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.core.internal.view.SupportMenu;
import androidx.core.os.BundleKt;
import androidx.core.view.InputDeviceCompat;
import androidx.databinding.DataBindingUtil;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.felhr.usbserial.UsbSerialDevice;
import com.felhr.usbserial.UsbSerialInterface;
import com.google.android.material.snackbar.Snackbar;
import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialProber;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kz.sapasoft.emark.app.BuildConfig;
import kz.sapasoft.emark.app.databinding.FragmentMapBinding;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.sapasoft.emark.app.domain.model.ProjectModel;
import kz.sapasoft.emark.app.ui.MainActivity;
import kz.sapasoft.emark.app.ui.OnNewDeviceAttached;
import kz.sapasoft.emark.app.ui.base.DaggerFragmentExtended;
import kz.sapasoft.emark.app.ui.marker.MarkerFragment;
import kz.sapasoft.emark.app.ui.marker.OnMarkerChangeListener;
import kz.sapasoft.emark.app.utils.Constants;
import kz.sapasoft.emark.app.utils.MarkerDrawer;
import kz.sapasoft.emark.app.utils.Utils;
import kz.ss.emark.R;
import okhttp3.internal.cache.DiskLruCache;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.bonuspack.clustering.RadiusMarkerClusterer;
import org.osmdroid.config.Configuration;
import org.osmdroid.config.IConfigurationProvider;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.CustomZoomButtonsController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000b\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001cB\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0007H\u0002J\u0016\u0010,\u001a\u00020)2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00150.H\u0002J\u0018\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020)H\u0002J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u000fH\u0002J\n\u00106\u001a\u0004\u0018\u000102H\u0002J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020\u000fH\u0002J\b\u0010:\u001a\u00020)H\u0002J#\u0010;\u001a\u00020)2\b\u0010<\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0002\u0010?J\u0018\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016J&\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010C\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u00020)H\u0016J\b\u0010M\u001a\u00020)H\u0016J\u0010\u0010N\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020PH\u0016J\u0012\u0010Q\u001a\u00020)2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J-\u0010T\u001a\u00020)2\u0006\u0010U\u001a\u00020\u00072\u000e\u0010V\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0W2\u0006\u0010X\u001a\u00020YH\u0016¢\u0006\u0002\u0010ZJ\u001a\u0010[\u001a\u00020)2\u0006\u0010\\\u001a\u00020F2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010]\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0015H\u0002J\b\u0010^\u001a\u00020)H\u0002J\b\u0010_\u001a\u00020)H\u0002J\b\u0010`\u001a\u00020)H\u0002J\u0010\u0010a\u001a\u00020)2\u0006\u0010b\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0011j\b\u0012\u0004\u0012\u00020\u0015`\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006d"}, d2 = {"Lkz/sapasoft/emark/app/ui/map/MapFragment;", "Lkz/sapasoft/emark/app/ui/base/DaggerFragmentExtended;", "Lkz/sapasoft/emark/app/ui/marker/OnMarkerChangeListener;", "Lcom/felhr/usbserial/UsbSerialInterface$UsbReadCallback;", "Lkz/sapasoft/emark/app/ui/OnNewDeviceAttached;", "()V", "REQUEST_LOCATION_PERMISSIONS", "", "TAG", "", "buffer", "Ljava/io/ByteArrayOutputStream;", "kzGeoPoint", "Lorg/osmdroid/util/GeoPoint;", "mIsManualNavigation", "", "mMarkerList", "Ljava/util/ArrayList;", "Lorg/osmdroid/views/overlay/Marker;", "Lkotlin/collections/ArrayList;", "mMarkerModelList", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "mMyLocationOverlay", "Lorg/osmdroid/views/overlay/mylocation/MyLocationNewOverlay;", "onMarkerClickListener", "Lorg/osmdroid/views/overlay/Marker$OnMarkerClickListener;", "poiMarkers", "Lorg/osmdroid/bonuspack/clustering/RadiusMarkerClusterer;", "viewModel", "Lkz/sapasoft/emark/app/ui/map/MapViewModel;", "getViewModel", "()Lkz/sapasoft/emark/app/ui/map/MapViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "addGasMarkerToMapMarkers", "", "markerModel", "color", "addMapMarkers", "markers", "", "alertLowAccuracy", "bytesStr", "location", "Landroid/location/Location;", "drawPin", "enableManualNavigation", "isManual", "getLocation", "getProjectModel", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "hasPermissions", "mapInit", "moveCamera", "geoPoint", "zoom", "", "(Lorg/osmdroid/util/GeoPoint;Ljava/lang/Double;)V", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onMarkerChange", "onNewDeviceAttached", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onReceivedData", "data", "", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "view", "openMarkerFragment", "requestGpsPermission", "setListeners", "setObservers", "showSnackBar", "text", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MapFragment.kt */
public final class MapFragment extends DaggerFragmentExtended implements OnMarkerChangeListener, UsbSerialInterface.UsbReadCallback, OnNewDeviceAttached {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int REQUEST_LOCATION_PERMISSIONS = 1;
    private final String TAG;
    private HashMap _$_findViewCache;
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private final GeoPoint kzGeoPoint = new GeoPoint(48.005284d, 66.9045435d);
    private boolean mIsManualNavigation;
    /* access modifiers changed from: private */
    public final ArrayList<Marker> mMarkerList = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<MarkerModel> mMarkerModelList = new ArrayList<>();
    /* access modifiers changed from: private */
    public MyLocationNewOverlay mMyLocationOverlay;
    private final Marker.OnMarkerClickListener onMarkerClickListener = new MapFragment$onMarkerClickListener$1(this);
    /* access modifiers changed from: private */
    public RadiusMarkerClusterer poiMarkers;
    private final Lazy viewModel$delegate = LazyKt.lazy(new MapFragment$viewModel$2(this));
    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Constants.MarkerStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Constants.MarkerStatus.NEW.ordinal()] = 1;
            $EnumSwitchMapping$0[Constants.MarkerStatus.EDITED.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: private */
    public final MapViewModel getViewModel() {
        return (MapViewModel) this.viewModel$delegate.getValue();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public MapFragment() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this::class.java.simpleName");
        this.TAG = simpleName;
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return factory;
    }

    public final void setViewModelFactory(ViewModelProvider.Factory factory) {
        Intrinsics.checkParameterIsNotNull(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lkz/sapasoft/emark/app/ui/map/MapFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "projectModel", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MapFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Fragment newInstance(ProjectModel projectModel) {
            Intrinsics.checkParameterIsNotNull(projectModel, "projectModel");
            MapFragment mapFragment = new MapFragment();
            mapFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("project", projectModel)));
            return mapFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        FragmentMapBinding fragmentMapBinding = (FragmentMapBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_map, viewGroup, false);
        setHasOptionsMenu(true);
        Intrinsics.checkExpressionValueIsNotNull(fragmentMapBinding, "binding");
        fragmentMapBinding.setItem(getProjectModel());
        return fragmentMapBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.tv_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_toolbar");
        textView.setText(getString(R.string.map));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((MainActivity) activity).setSupportActionBar((Toolbar) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.toolbar));
            Utils utils = Utils.INSTANCE;
            TextView textView2 = (TextView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.tv_toolbar);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_toolbar");
            utils.hideKeyboard(textView2);
            getViewModel().getMarkerList(CollectionsKt.arrayListOf(getProjectModel().getId()));
            getViewModel().getTemplateList(getProjectModel().getMarkerTemplateIds());
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                ((MainActivity) activity2).setDeviceListener(this);
                mapInit();
                drawPin();
                setObservers();
                setListeners();
                requestGpsPermission();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity");
        }
        throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity");
    }

    private final ProjectModel getProjectModel() {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("project") : null;
        if (serializable != null) {
            return (ProjectModel) serializable;
        }
        throw new TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.domain.model.ProjectModel");
    }

    private final void setListeners() {
        Object systemService = requireContext().getSystemService("usb");
        if (systemService != null) {
            UsbManager usbManager = (UsbManager) systemService;
            List<UsbSerialDriver> findAllDrivers = UsbSerialProber.getDefaultProber().findAllDrivers(usbManager);
            if (!findAllDrivers.isEmpty()) {
                UsbSerialDriver usbSerialDriver = findAllDrivers.get(0);
                Intrinsics.checkExpressionValueIsNotNull(usbSerialDriver, "availableDrivers[0]");
                UsbDeviceConnection openDevice = usbManager.openDevice(usbSerialDriver.getDevice());
                UsbSerialDriver usbSerialDriver2 = findAllDrivers.get(0);
                Intrinsics.checkExpressionValueIsNotNull(usbSerialDriver2, "availableDrivers[0]");
                UsbSerialDevice createUsbSerialDevice = UsbSerialDevice.createUsbSerialDevice(usbSerialDriver2.getDevice(), openDevice);
                createUsbSerialDevice.open();
                createUsbSerialDevice.setBaudRate(4800);
                createUsbSerialDevice.setDataBits(8);
                createUsbSerialDevice.setParity(0);
                createUsbSerialDevice.setFlowControl(0);
                createUsbSerialDevice.setStopBits(1);
                createUsbSerialDevice.read(this);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.usb.UsbManager");
    }

    private final void setObservers() {
        MapViewModel viewModel = getViewModel();
        viewModel.getMarkerModelListData().observe(getViewLifecycleOwner(), new MapFragment$setObservers$$inlined$with$lambda$1(this));
        viewModel.getError().observe(getViewLifecycleOwner(), new MapFragment$setObservers$$inlined$with$lambda$2(this));
    }

    /* access modifiers changed from: private */
    public final void showSnackBar(String str) {
        Snackbar.make((View) (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view), (CharSequence) str, -1).show();
    }

    private final void drawPin() {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_pin);
        Intrinsics.checkExpressionValueIsNotNull(drawable, "resources.getDrawable(R.drawable.ic_pin)");
        Bitmap bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, (Bitmap.Config) null, 7, (Object) null);
        ((ImageView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.iv_pin)).setImageBitmap(bitmap$default);
        ((ImageView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.iv_pin)).setPadding(0, 0, 0, bitmap$default.getHeight());
    }

    private final void mapInit() {
        Configuration.getInstance().load(getContext(), PreferenceManager.getDefaultSharedPreferences(getContext()));
        IConfigurationProvider instance = Configuration.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "Configuration.getInstance()");
        instance.setUserAgentValue(BuildConfig.APPLICATION_ID);
        MyLocationNewOverlay myLocationNewOverlay = new MyLocationNewOverlay((MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view));
        this.mMyLocationOverlay = myLocationNewOverlay;
        if (myLocationNewOverlay != null) {
            myLocationNewOverlay.enableMyLocation();
        }
        MapView mapView = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
        Intrinsics.checkExpressionValueIsNotNull(mapView, "map_view");
        mapView.getOverlays().clear();
        MapView mapView2 = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
        Intrinsics.checkExpressionValueIsNotNull(mapView2, "map_view");
        mapView2.getOverlays().add(this.mMyLocationOverlay);
        ((MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view)).setTileSource(TileSourceFactory.MAPNIK);
        ((MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view)).setMultiTouchControls(true);
        MapView mapView3 = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
        Intrinsics.checkExpressionValueIsNotNull(mapView3, "map_view");
        mapView3.setMaxZoomLevel(Double.valueOf(22.0d));
        MapView mapView4 = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
        Intrinsics.checkExpressionValueIsNotNull(mapView4, "map_view");
        mapView4.setMinZoomLevel(Double.valueOf(5.0d));
        MapView mapView5 = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
        Intrinsics.checkExpressionValueIsNotNull(mapView5, "map_view");
        mapView5.getController().setZoom(5.0d);
        MapView mapView6 = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
        Intrinsics.checkExpressionValueIsNotNull(mapView6, "map_view");
        mapView6.getController().setCenter(this.kzGeoPoint);
        MapView mapView7 = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
        Intrinsics.checkExpressionValueIsNotNull(mapView7, "map_view");
        mapView7.getZoomController().setVisibility(CustomZoomButtonsController.Visibility.SHOW_AND_FADEOUT);
    }

    static /* synthetic */ void moveCamera$default(MapFragment mapFragment, GeoPoint geoPoint, Double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = null;
        }
        mapFragment.moveCamera(geoPoint, d);
    }

    private final void moveCamera(GeoPoint geoPoint, Double d) {
        if (geoPoint != null) {
            if (d != null) {
                MapView mapView = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
                Intrinsics.checkExpressionValueIsNotNull(mapView, "map_view");
                mapView.getController().setZoom(12.0d);
            }
            MapView mapView2 = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
            Intrinsics.checkExpressionValueIsNotNull(mapView2, "map_view");
            mapView2.getController().setCenter(geoPoint);
        }
    }

    /* access modifiers changed from: private */
    public final void addMapMarkers(List<MarkerModel> list) {
        this.poiMarkers = new RadiusMarkerClusterer(getContext());
        this.mMarkerModelList.addAll(list);
        Drawable drawable = getResources().getDrawable(R.drawable.ic_cluster);
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            RadiusMarkerClusterer radiusMarkerClusterer = this.poiMarkers;
            if (radiusMarkerClusterer != null) {
                radiusMarkerClusterer.setIcon(bitmap);
            }
            RadiusMarkerClusterer radiusMarkerClusterer2 = this.poiMarkers;
            if (radiusMarkerClusterer2 != null) {
                radiusMarkerClusterer2.setRadius(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
            }
            MapView mapView = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
            Intrinsics.checkExpressionValueIsNotNull(mapView, "map_view");
            mapView.getOverlays().add(this.poiMarkers);
            for (MarkerModel next : list) {
                Constants.MarkerStatus status = next.getStatus();
                if (status != null) {
                    int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
                    if (i == 1) {
                        addGasMarkerToMapMarkers(next, -16711936);
                    } else if (i == 2) {
                        addGasMarkerToMapMarkers(next, SupportMenu.CATEGORY_MASK);
                    }
                }
                addGasMarkerToMapMarkers(next, InputDeviceCompat.SOURCE_ANY);
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
    }

    private final void addGasMarkerToMapMarkers(MarkerModel markerModel, int i) {
        Marker marker = new Marker((MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view));
        List<Double> location = markerModel.getLocation();
        if (location == null) {
            Intrinsics.throwNpe();
        }
        double doubleValue = location.get(0).doubleValue();
        List<Double> location2 = markerModel.getLocation();
        if (location2 == null) {
            Intrinsics.throwNpe();
        }
        marker.setPosition(new GeoPoint(doubleValue, location2.get(1).doubleValue()));
        marker.setOnMarkerClickListener(this.onMarkerClickListener);
        marker.setIcon(MarkerDrawer.INSTANCE.makeCircle(i, getViewModel().getMarkerSize()));
        marker.setId(markerModel.getId());
        this.mMarkerList.add(marker);
        RadiusMarkerClusterer radiusMarkerClusterer = this.poiMarkers;
        if (radiusMarkerClusterer != null) {
            radiusMarkerClusterer.add(marker);
        }
    }

    private final void enableManualNavigation(boolean z) {
        this.mIsManualNavigation = z;
        if (z) {
            ImageView imageView = (ImageView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.iv_pin);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "iv_pin");
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.iv_pin);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "iv_pin");
        imageView2.setVisibility(8);
    }

    public void onMarkerChange() {
        getViewModel().getMarkerEntityList(getProjectModel().getId());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkParameterIsNotNull(menu, "menu");
        Intrinsics.checkParameterIsNotNull(menuInflater, "inflater");
        menuInflater.inflate(R.menu.map_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        switch (menuItem.getItemId()) {
            case 16908332:
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                    break;
                }
                break;
            case R.id.action_manual_nav:
                menuItem.setChecked(!menuItem.isChecked());
                enableManualNavigation(menuItem.isChecked());
                break;
            case R.id.action_synchronize:
                getViewModel().synchronizeMarkers(getProjectModel().getId());
                break;
            case R.id.action_to_last_marker:
                Marker marker = (Marker) CollectionsKt.lastOrNull(this.mMarkerList);
                moveCamera$default(this, marker != null ? marker.getPosition() : null, (Double) null, 2, (Object) null);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onReceivedData(byte[] bArr) {
        if (bArr != null) {
            Log.e("SCAN_MARKER", DiskLruCache.VERSION_1);
            this.buffer.write(bArr);
            byte[] byteArray = this.buffer.toByteArray();
            Intrinsics.checkExpressionValueIsNotNull(byteArray, "buffer.toByteArray()");
            String str = new String(byteArray, Charsets.UTF_8);
            Log.e("SCAN_MARKER", str);
            Double d = null;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "DL,08,", false, 2, (Object) null)) {
                Log.e("SCAN_MARKER", str);
                this.buffer.reset();
                if (getLocation() != null) {
                    Location location = getLocation();
                    if (location != null) {
                        d = Double.valueOf(location.getLatitude());
                    }
                    if (d != null) {
                        Location location2 = getLocation();
                        if (location2 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (location2.getAccuracy() > ((float) 5)) {
                            Log.e("SCAN_MARKER", "4");
                            FragmentActivity activity = getActivity();
                            if (activity != null) {
                                activity.runOnUiThread(new MapFragment$onReceivedData$1(this, str));
                                return;
                            }
                            return;
                        }
                        Log.e("SCAN_MARKER", "5");
                        MapViewModel viewModel = getViewModel();
                        Location location3 = getLocation();
                        if (location3 == null) {
                            Intrinsics.throwNpe();
                        }
                        openMarkerFragment(viewModel.getMakerModelFromByteStr(str, location3));
                        return;
                    }
                }
                Log.e("SCAN_MARKER", ExifInterface.GPS_MEASUREMENT_3D);
                String string = getString(R.string.location_not_found);
                Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.location_not_found)");
                showSnackBar(string);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void alertLowAccuracy(String str, Location location) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle((CharSequence) getString(R.string.low_gps_accuracy));
        builder.setCancelable(false);
        builder.setMessage((CharSequence) getString(R.string.low_accuracy_continue, Integer.valueOf((int) location.getAccuracy())));
        builder.setPositiveButton((CharSequence) getString(R.string.yes), (DialogInterface.OnClickListener) new MapFragment$alertLowAccuracy$1(this, str));
        builder.setNegativeButton((CharSequence) getString(R.string.no), (DialogInterface.OnClickListener) MapFragment$alertLowAccuracy$2.INSTANCE);
        AlertDialog create = builder.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "builder.create()");
        create.show();
    }

    /* access modifiers changed from: private */
    public final void openMarkerFragment(MarkerModel markerModel) {
        getChildFragmentClickListener().onFragmentAdd(MarkerFragment.Companion.newInstance(getProjectModel(), markerModel, this));
    }

    private final void requestGpsPermission() {
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION"};
        if (!hasPermissions()) {
            requestPermissions(strArr, this.REQUEST_LOCATION_PERMISSIONS);
        }
    }

    private final boolean hasPermissions() {
        if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(requireContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == this.REQUEST_LOCATION_PERMISSIONS) {
            if (!(!(iArr.length == 0)) || iArr[0] != 0) {
                String string = getString(R.string.permission_gps_rejected);
                Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.permission_gps_rejected)");
                showSnackBar(string);
                return;
            }
            MapView mapView = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
            Intrinsics.checkExpressionValueIsNotNull(mapView, "map_view");
            mapView.getOverlays().remove(this.mMyLocationOverlay);
            MyLocationNewOverlay myLocationNewOverlay = new MyLocationNewOverlay((MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view));
            this.mMyLocationOverlay = myLocationNewOverlay;
            if (myLocationNewOverlay != null) {
                myLocationNewOverlay.enableMyLocation();
            }
            MapView mapView2 = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
            Intrinsics.checkExpressionValueIsNotNull(mapView2, "map_view");
            mapView2.getOverlays().add(this.mMyLocationOverlay);
            ((MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view)).invalidate();
        }
    }

    /* access modifiers changed from: private */
    public final Location getLocation() {
        if (this.mIsManualNavigation) {
            Location location = new Location("map_center");
            location.setAccuracy(0.0f);
            MapView mapView = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
            Intrinsics.checkExpressionValueIsNotNull(mapView, "map_view");
            IGeoPoint mapCenter = mapView.getMapCenter();
            Intrinsics.checkExpressionValueIsNotNull(mapCenter, "map_view.mapCenter");
            location.setLatitude(mapCenter.getLatitude());
            MapView mapView2 = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
            Intrinsics.checkExpressionValueIsNotNull(mapView2, "map_view");
            IGeoPoint mapCenter2 = mapView2.getMapCenter();
            Intrinsics.checkExpressionValueIsNotNull(mapCenter2, "map_view.mapCenter");
            location.setLongitude(mapCenter2.getLongitude());
            MapView mapView3 = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
            Intrinsics.checkExpressionValueIsNotNull(mapView3, "map_view");
            IGeoPoint mapCenter3 = mapView3.getMapCenter();
            Intrinsics.checkExpressionValueIsNotNull(mapCenter3, "map_view.mapCenter");
            MapView mapView4 = (MapView) _$_findCachedViewById(kz.sapasoft.emark.app.R.id.map_view);
            Intrinsics.checkExpressionValueIsNotNull(mapView4, "map_view");
            IGeoPoint mapCenter4 = mapView4.getMapCenter();
            Intrinsics.checkExpressionValueIsNotNull(mapCenter4, "map_view.mapCenter");
            CollectionsKt.arrayListOf(Double.valueOf(mapCenter3.getLatitude()), Double.valueOf(mapCenter4.getLongitude()));
            return location;
        }
        MyLocationNewOverlay myLocationNewOverlay = this.mMyLocationOverlay;
        if (myLocationNewOverlay != null) {
            return myLocationNewOverlay.getLastFix();
        }
        return null;
    }

    public void onNewDeviceAttached() {
        setListeners();
    }
}

package kz.sapasoft.emark.app.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.decompiledapk.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.List;

import dagger.android.support.DaggerAppCompatActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.ui.main_fragments.MainFragment;
import kz.sapasoft.emark.app.utils.Utils;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000*\u0001\u0019\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001cH\u0014J\u0006\u0010!\u001a\u00020\u001cJ\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\u0006\u0010$\u001a\u00020\u001cJ\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\fJ\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006,"}, d2 = {"Lkz/sapasoft/emark/app/ui/MainActivity;", "Ldagger/android/support/DaggerAppCompatActivity;", "()V", "ACTION_USB_PERMISSION", "", "TAG", "kotlin.jvm.PlatformType", "active", "Landroidx/fragment/app/Fragment;", "closeActivityFlag", "", "deviceListener", "Lkz/sapasoft/emark/app/ui/OnNewDeviceAttached;", "fm", "Landroidx/fragment/app/FragmentManager;", "fragment1", "fragment2", "fragment3", "mUsbManager", "Landroid/hardware/usb/UsbManager;", "getMUsbManager", "()Landroid/hardware/usb/UsbManager;", "mUsbManager$delegate", "Lkotlin/Lazy;", "usbReceiver", "kz/sapasoft/emark/app/ui/MainActivity$usbReceiver$1", "Lkz/sapasoft/emark/app/ui/MainActivity$usbReceiver$1;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "openProjectsFragment", "registerReceiver", "requestPermission", "setCloseActivityFlag", "setDeviceListener", "listener", "setupNavigation", "unregisterReceiver", "updateNavigationBarState", "actionId", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MainActivity.kt */
public final class MainActivity extends DaggerAppCompatActivity {
    /* access modifiers changed from: private */
    public final String ACTION_USB_PERMISSION;
    public final int REQUEST_BLUETOOTH_PERMISSIONS = 111;
    private final String TAG = getClass().getSimpleName();
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Fragment active;
    private boolean closeActivityFlag;
    /* access modifiers changed from: private */
    public OnNewDeviceAttached deviceListener;
    /* access modifiers changed from: private */
    public final FragmentManager fm;
    /* access modifiers changed from: private */
    public final Fragment fragment1 = MainFragment.Companion.newInstance(1);
    /* access modifiers changed from: private */
    public final Fragment fragment2 = MainFragment.Companion.newInstance(2);
    /* access modifiers changed from: private */
    public final Fragment fragment3 = MainFragment.Companion.newInstance(3);
    private final Lazy mUsbManager$delegate;
    // private final MainActivity$usbReceiver$1 usbReceiver;

    private static final int REQUEST_ENABLE_BT = 1001;

    private final UsbManager getMUsbManager() {
        return (UsbManager) this.mUsbManager$delegate.getValue();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public MainActivity() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
        this.fm = supportFragmentManager;
        this.active = this.fragment2;
        this.ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION";
        this.mUsbManager$delegate = LazyKt.lazy(new MainActivity$mUsbManager$2(this));
        //   this.usbReceiver = new MainActivity$usbReceiver$1(this);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((R.layout.activity_main));
        setupNavigation();
        Utils utils = Utils.INSTANCE;
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        utils.hideKeyboard(bottomNavigationView);
        registerReceiver();
        requestPermission();
    }

    private final void setupNavigation() {
        this.fm.beginTransaction().add((int) R.id.fl_content, this.fragment1, "1").commit();
        this.fm.beginTransaction().add((int) R.id.fl_content, this.fragment2, "2").hide(this.fragment2).commit();
        this.fm.beginTransaction().add((int) R.id.fl_content, this.fragment3, "3").hide(this.fragment3).commit();
        updateNavigationBarState(R.id.nav_item_projects);
        ((BottomNavigationView) findViewById(R.id.nav_view)).setOnNavigationItemSelectedListener(
                new MainActivity$setupNavigation$1(this));
    }


    /* access modifiers changed from: private */
    public final void updateNavigationBarState(int i) {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        Intrinsics.checkExpressionValueIsNotNull(bottomNavigationView, "nav_view");
        MenuItem findItem = bottomNavigationView.getMenu().findItem(i);
        Intrinsics.checkExpressionValueIsNotNull(findItem, "menuItem");
        findItem.setChecked(true);
    }

    public final void setCloseActivityFlag() {
        this.closeActivityFlag = true;
    }

    public final void openProjectsFragment() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        Intrinsics.checkExpressionValueIsNotNull(bottomNavigationView, "nav_view");
        bottomNavigationView.setSelectedItemId(R.id.nav_item_projects);
    }

    public final void setDeviceListener(OnNewDeviceAttached onNewDeviceAttached) {
        Intrinsics.checkParameterIsNotNull(onNewDeviceAttached, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.deviceListener = onNewDeviceAttached;
    }

    public void onBackPressed() {
        Utils utils = Utils.INSTANCE;
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        Intrinsics.checkExpressionValueIsNotNull(bottomNavigationView, "nav_view");
        utils.hideKeyboard(bottomNavigationView);
        List<Fragment> fragments = this.fm.getFragments();
        Intrinsics.checkExpressionValueIsNotNull(fragments, "fm.fragments");
        for (Fragment next : fragments) {
            if (next != null && (next instanceof MainFragment)) {
                MainFragment mainFragment = (MainFragment) next;
                if (mainFragment.isVisible()) {
                    mainFragment.onBackPressed();
                }
            }
        }
        if (this.closeActivityFlag) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public final void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.BLUETOOTH_SCAN,
                        Manifest.permission.BLUETOOTH_CONNECT
                }, REQUEST_BLUETOOTH_PERMISSIONS);
            } else {
                enableBluetooth();
            }
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION
                }, REQUEST_BLUETOOTH_PERMISSIONS);
            } else {
                enableBluetooth();
            }
        }
    }

    @SuppressLint("MissingPermission")
    private void enableBluetooth() {
        BluetoothManager bluetoothManager = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        }
        BluetoothAdapter bluetoothAdapter = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            bluetoothAdapter = bluetoothManager.getAdapter();
        }

        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth is not supported on this device", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        } else {
            Toast.makeText(this, "Bluetooth Already Enabled", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ENABLE_BT) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Bluetooth Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bluetooth not enabled", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_BLUETOOTH_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                enableBluetooth();
            } else {
                Toast.makeText(this, "Bluetooth permissions denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private final void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.ACTION_USB_PERMISSION);
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        // registerReceiver(this.usbReceiver, intentFilter);
    }

    private final void unregisterReceiver() {
        //  unregisterReceiver(this.usbReceiver);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        unregisterReceiver();
        super.onDestroy();
    }
}

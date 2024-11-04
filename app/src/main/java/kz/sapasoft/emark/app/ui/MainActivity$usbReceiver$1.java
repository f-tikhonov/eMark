package kz.sapasoft.emark.app.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.R;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"kz/sapasoft/emark/app/ui/MainActivity$usbReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MainActivity.kt */
public final class MainActivity$usbReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ MainActivity this$0;

    MainActivity$usbReceiver$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        String action = intent.getAction();
        if (Intrinsics.areEqual((Object) action, (Object) this.this$0.ACTION_USB_PERMISSION)) {
            if (intent.getBooleanExtra("permission", false)) {
                Log.e("SCAN_MARKER", "EXTRA_PERMISSION_GRANTED");
                OnNewDeviceAttached access$getDeviceListener$p = this.this$0.deviceListener;
                if (access$getDeviceListener$p != null) {
                    access$getDeviceListener$p.onNewDeviceAttached();
                    return;
                }
                return;
            }
            Snackbar.make((View) (BottomNavigationView) this.this$0._$_findCachedViewById(R.id.nav_view), (CharSequence) this.this$0.getString(kz.ss.emark.R.string.usb_permission_rejected), -1).show();
        } else if (Intrinsics.areEqual((Object) action, (Object) "android.hardware.usb.action.USB_DEVICE_ATTACHED")) {
            Log.e("SCAN_MARKER", "ACTION_USB_DEVICE_ATTACHED");
            this.this$0.requestPermission();
        } else if (Intrinsics.areEqual((Object) action, (Object) "android.hardware.usb.action.USB_DEVICE_DETACHED")) {
            Log.e("SCAN_MARKER", "ACTION_USB_DEVICE_DETACHED");
        }
    }
}

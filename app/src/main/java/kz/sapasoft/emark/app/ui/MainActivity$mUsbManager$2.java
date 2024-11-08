package kz.sapasoft.emark.app.ui;

import android.hardware.usb.UsbManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/hardware/usb/UsbManager;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainActivity.kt */
final class MainActivity$mUsbManager$2 implements Function0<UsbManager> {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivity$mUsbManager$2(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final UsbManager invoke() {
        Object systemService = this.this$0.getSystemService(String.valueOf("usb"));
        if (systemService != null) {
            return (UsbManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.usb.UsbManager");
    }
}

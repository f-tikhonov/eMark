/*
package kz.sapasoft.emark.app.ui.settings;

import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.core.view.InputDeviceCompat;

import com.example.decompiledapk.R;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.utils.MarkerDrawer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"kz/sapasoft/emark/app/ui/settings/SettingsFragment$setListeners$3", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "app_release"}, k = 1, mv = {1, 1, 16})
*/
/* compiled from: SettingsFragment.kt *//*

public final class SettingsFragment$setListeners$3 implements SeekBar.OnSeekBarChangeListener {
    final */
/* synthetic *//*
 SettingsFragment this$0;

    public void onStartTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
    }

    SettingsFragment$setListeners$3(SettingsFragment settingsFragment) {
        this.this$0 = settingsFragment;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
        ((ImageView) this.this$0._$_findCachedViewById(R.id.iv_circle)).setImageDrawable(MarkerDrawer.INSTANCE.makeCircle(InputDeviceCompat.SOURCE_ANY, ((float) i) + ((float) 20)));
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "seekBar");
        this.this$0.getViewModel().saveMarkerSize(((float) seekBar.getProgress()) + ((float) 20));
    }
}
*/

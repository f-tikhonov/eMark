package kz.sapasoft.emark.app.ui;

import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.utils.Utils;
import kz.ss.emark.R;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "item", "Landroid/view/MenuItem;", "onNavigationItemSelected"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainActivity.kt */
final class MainActivity$setupNavigation$1 implements BottomNavigationView.OnNavigationItemSelectedListener {
    final /* synthetic */ MainActivity this$0;

    MainActivity$setupNavigation$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        switch (menuItem.getItemId()) {
            case R.id.nav_item_about:
                this.this$0.fm.beginTransaction().hide(this.this$0.active).show(this.this$0.fragment3).commit();
                MainActivity mainActivity = this.this$0;
                mainActivity.active = mainActivity.fragment3;
                break;
            case R.id.nav_item_projects:
                this.this$0.fm.beginTransaction().hide(this.this$0.active).show(this.this$0.fragment1).commit();
                MainActivity mainActivity2 = this.this$0;
                mainActivity2.active = mainActivity2.fragment1;
                break;
            case R.id.nav_item_settings:
                this.this$0.fm.beginTransaction().hide(this.this$0.active).show(this.this$0.fragment2).commit();
                MainActivity mainActivity3 = this.this$0;
                mainActivity3.active = mainActivity3.fragment2;
                break;
        }
        this.this$0.updateNavigationBarState(menuItem.getItemId());
        Utils utils = Utils.INSTANCE;
        BottomNavigationView bottomNavigationView = (BottomNavigationView) this.this$0._$_findCachedViewById(kz.sapasoft.emark.app.R.id.nav_view);
        Intrinsics.checkExpressionValueIsNotNull(bottomNavigationView, "nav_view");
        utils.hideKeyboard(bottomNavigationView);
        return false;
    }
}

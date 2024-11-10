/*
package kz.sapasoft.emark.app.ui.custom_views;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.R;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "view", "Landroid/widget/DatePicker;", "kotlin.jvm.PlatformType", "year", "", "month", "dayOfMonth", "onDateSet"}, k = 3, mv = {1, 1, 16})
*/
/* compiled from: FieldViewDate.kt *//*

final class FieldViewDate$dialogListener$1 implements DatePickerDialog.OnDateSetListener {
    final */
/* synthetic *//*
 FieldViewDate this$0;

    FieldViewDate$dialogListener$1(FieldViewDate fieldViewDate) {
        this.this$0 = fieldViewDate;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2);
        instance.set(5, i3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
        TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.tv_text);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_text");
        Intrinsics.checkExpressionValueIsNotNull(instance, "cal");
        textView.setText(simpleDateFormat.format(instance.getTime()));
    }
}
*/

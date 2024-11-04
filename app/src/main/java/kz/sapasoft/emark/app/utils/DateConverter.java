package kz.sapasoft.emark.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u001f\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkz/sapasoft/emark/app/utils/DateConverter;", "", "()V", "dateToString", "", "date", "Ljava/util/Date;", "pattern", "millisToDate", "milliSeconds", "", "(Ljava/lang/Long;)Ljava/util/Date;", "millisToString", "(Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;", "stringToDate", "string", "stringToMillis", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DateConverter.kt */
public final class DateConverter {
    public static final DateConverter INSTANCE = new DateConverter();

    private DateConverter() {
    }

    public final Date stringToDate(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str2, "pattern");
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }

    public final String dateToString(Date date, String str) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        Intrinsics.checkParameterIsNotNull(str, "pattern");
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(date);
        Intrinsics.checkExpressionValueIsNotNull(format, "format.format(date)");
        return format;
    }

    public final Date millisToDate(Long l) {
        if (l == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTimeInMillis(l.longValue());
        return instance.getTime();
    }

    public final String millisToString(Long l, String str) {
        Date millisToDate;
        Intrinsics.checkParameterIsNotNull(str, "pattern");
        if (l == null || (millisToDate = millisToDate(l)) == null) {
            return "";
        }
        return dateToString(millisToDate, str);
    }

    public final Long stringToMillis(String str, String str2) {
        Date stringToDate;
        Intrinsics.checkParameterIsNotNull(str2, "pattern");
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0) && (stringToDate = stringToDate(str, str2)) != null) {
            return Long.valueOf(stringToDate.getTime());
        }
        return null;
    }
}

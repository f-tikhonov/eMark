package kz.sapasoft.emark.app.utils;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lkz/sapasoft/emark/app/utils/Constants;", "", "()V", "FieldTypes", "MarkerStatus", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Constants.kt */
public final class Constants {
    public static final Constants INSTANCE = new Constants();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkz/sapasoft/emark/app/utils/Constants$MarkerStatus;", "", "(Ljava/lang/String;I)V", "NEW", "EDITED", "NORMAL", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Constants.kt */
    public enum MarkerStatus {
        NEW,
        EDITED,
        NORMAL
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkz/sapasoft/emark/app/utils/Constants$FieldTypes;", "", "()V", "BOOL", "", "DATE", "DOUBLE", "LONG", "TAG", "TEXT", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Constants.kt */
    public static final class FieldTypes {
        public static final String BOOL = "boolValue";
        public static final String DATE = "dateValue";
        public static final String DOUBLE = "doubleValue";
        public static final FieldTypes INSTANCE = new FieldTypes();
        public static final String LONG = "longValue";
        public static final String TAG = "tagValue";
        public static final String TEXT = "textValue";

        private FieldTypes() {
        }
    }

    private Constants() {
    }
}

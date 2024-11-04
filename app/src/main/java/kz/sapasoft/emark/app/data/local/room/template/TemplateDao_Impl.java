package kz.sapasoft.emark.app.data.local.room.template;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kz.sapasoft.emark.app.data.local.room.DataConverter;
import kz.sapasoft.emark.app.domain.model.FieldModel;
import kz.sapasoft.emark.app.domain.model.TemplateModel;

public final class TemplateDao_Impl implements TemplateDao {
    /* access modifiers changed from: private */
    public final DataConverter __dataConverter = new DataConverter();
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateModel;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public TemplateDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfTemplateModel = new EntityInsertionAdapter<TemplateModel>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `template_table`(`id`,`createdById`,`created`,`updatedById`,`updated`,`privileges`,`frontData`,`name`,`descr`,`fields`,`color`,`markerModels`,`markerTypes`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateModel templateModel) {
                if (templateModel.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, templateModel.getId());
                }
                if (templateModel.getCreatedById() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, templateModel.getCreatedById());
                }
                supportSQLiteStatement.bindLong(3, templateModel.getCreated());
                if (templateModel.getUpdatedById() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, templateModel.getUpdatedById());
                }
                supportSQLiteStatement.bindLong(5, templateModel.getUpdated());
                String fromStringList = TemplateDao_Impl.this.__dataConverter.fromStringList(templateModel.getPrivileges());
                if (fromStringList == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, fromStringList);
                }
                if (templateModel.getFrontData() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, templateModel.getFrontData());
                }
                if (templateModel.getName() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, templateModel.getName());
                }
                if (templateModel.getDescr() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, templateModel.getDescr());
                }
                String fromFieldModelList = TemplateDao_Impl.this.__dataConverter.fromFieldModelList(templateModel.getFields());
                if (fromFieldModelList == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, fromFieldModelList);
                }
                if (templateModel.getColor() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, templateModel.getColor());
                }
                String fromStringMap = TemplateDao_Impl.this.__dataConverter.fromStringMap(templateModel.getMarkerModels());
                if (fromStringMap == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, fromStringMap);
                }
                String fromStringList2 = TemplateDao_Impl.this.__dataConverter.fromStringList(templateModel.getMarkerTypes());
                if (fromStringList2 == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, fromStringList2);
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM template_table";
            }
        };
    }

    public void insert(List<TemplateModel> list) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfTemplateModel.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAll() {
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(acquire);
        }
    }

    public List<TemplateModel> findById(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from template_table WHERE id=?", 1);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        Cursor query = this.__db.query(acquire);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("createdById");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("created");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("updatedById");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("updated");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("privileges");
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("frontData");
            int columnIndexOrThrow8 = query.getColumnIndexOrThrow(AppMeasurementSdk.ConditionalUserProperty.NAME);
            int columnIndexOrThrow9 = query.getColumnIndexOrThrow("descr");
            int columnIndexOrThrow10 = query.getColumnIndexOrThrow("fields");
            int columnIndexOrThrow11 = query.getColumnIndexOrThrow("color");
            int columnIndexOrThrow12 = query.getColumnIndexOrThrow("markerModels");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow13 = query.getColumnIndexOrThrow("markerTypes");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow2);
                    long j = query.getLong(columnIndexOrThrow3);
                    String string3 = query.getString(columnIndexOrThrow4);
                    long j2 = query.getLong(columnIndexOrThrow5);
                    int i = columnIndexOrThrow;
                    List<String> stringList = this.__dataConverter.toStringList(query.getString(columnIndexOrThrow6));
                    String string4 = query.getString(columnIndexOrThrow7);
                    String string5 = query.getString(columnIndexOrThrow8);
                    String string6 = query.getString(columnIndexOrThrow9);
                    List<FieldModel> fieldModelList = this.__dataConverter.toFieldModelList(query.getString(columnIndexOrThrow10));
                    String string7 = query.getString(columnIndexOrThrow11);
                    Map<String, String> stringMap = this.__dataConverter.toStringMap(query.getString(columnIndexOrThrow12));
                    int i2 = columnIndexOrThrow13;
                    columnIndexOrThrow13 = i2;
                    arrayList.add(new TemplateModel(string, string2, j, string3, j2, stringList, string4, string5, string6, fieldModelList, string7, stringMap, this.__dataConverter.toStringList(query.getString(i2))));
                    columnIndexOrThrow = i;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }
}

package kz.sapasoft.emark.app.data.local.room.tag;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import kz.sapasoft.emark.app.domain.model.TagModel;

public final class TagDao_Impl implements TagDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfTagModel;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public TagDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfTagModel = new EntityInsertionAdapter<TagModel>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `tag_table`(`id`,`createdById`,`created`,`updatedById`,`updated`,`frontData`,`templateId`,`name`) VALUES (?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TagModel tagModel) {
                if (tagModel.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, tagModel.getId());
                }
                if (tagModel.createdById == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, tagModel.createdById);
                }
                if (tagModel.created == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindLong(3, tagModel.created.longValue());
                }
                if (tagModel.updatedById == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, tagModel.updatedById);
                }
                if (tagModel.updated == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, tagModel.updated.longValue());
                }
                if (tagModel.frontData == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, tagModel.frontData);
                }
                if (tagModel.templateId == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, tagModel.templateId);
                }
                if (tagModel.name == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, tagModel.name);
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM tag_table";
            }
        };
    }

    public void insert(List<TagModel> list) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfTagModel.insert(list);
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

    public List<TagModel> findAll() {
        Long l;
        Long l2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from tag_table", 0);
        Cursor query = this.__db.query(acquire);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("createdById");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("created");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("updatedById");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("updated");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("frontData");
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("templateId");
            int columnIndexOrThrow8 = query.getColumnIndexOrThrow(AppMeasurementSdk.ConditionalUserProperty.NAME);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.getString(columnIndexOrThrow);
                String string2 = query.getString(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    l = null;
                } else {
                    l = Long.valueOf(query.getLong(columnIndexOrThrow3));
                }
                String string3 = query.getString(columnIndexOrThrow4);
                if (query.isNull(columnIndexOrThrow5)) {
                    l2 = null;
                } else {
                    l2 = Long.valueOf(query.getLong(columnIndexOrThrow5));
                }
                arrayList.add(new TagModel(string, string2, l, string3, l2, query.getString(columnIndexOrThrow6), query.getString(columnIndexOrThrow7), query.getString(columnIndexOrThrow8)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}

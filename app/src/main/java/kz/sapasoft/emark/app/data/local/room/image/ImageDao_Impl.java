/*
package kz.sapasoft.emark.app.data.local.room.image;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import kz.sapasoft.emark.app.data.local.room.DataConverter;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;

public final class ImageDao_Impl implements ImageDao {
    */
/* access modifiers changed from: private *//*

    public final DataConverter __dataConverter = new DataConverter();
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfImageDataModel;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByLocalIdParent;

    public ImageDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfImageDataModel = new EntityInsertionAdapter<ImageDataModel>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `image_table`(`id`,`localIdParent`,`metadata`,`file`) VALUES (?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, ImageDataModel imageDataModel) {
                if (imageDataModel.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, imageDataModel.getId());
                }
                if (imageDataModel.localIdParent == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, imageDataModel.localIdParent);
                }
                String fromMetaData = ImageDao_Impl.this.__dataConverter.fromMetaData(imageDataModel.metadata);
                if (fromMetaData == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, fromMetaData);
                }
                String fromFile = ImageDao_Impl.this.__dataConverter.fromFile(imageDataModel.file);
                if (fromFile == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, fromFile);
                }
            }
        };
        this.__preparedStmtOfDeleteByLocalIdParent = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM image_table WHERE localIdParent = ?";
            }
        };
    }

    public void insertWithReplace(List<ImageDataModel> list) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfImageDataModel.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteByLocalIdParent(String str) {
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteByLocalIdParent.acquire();
        this.__db.beginTransaction();
        if (str == null) {
            try {
                acquire.bindNull(1);
            } catch (Throwable th) {
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteByLocalIdParent.release(acquire);
                throw th;
            }
        } else {
            acquire.bindString(1, str);
        }
        acquire.executeUpdateDelete();
        this.__db.setTransactionSuccessful();
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByLocalIdParent.release(acquire);
    }

    public List<ImageDataModel> findByLocalIdParent(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from image_table WHERE localIdParent=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        Cursor query = this.__db.query(acquire);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("localIdParent");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("metadata");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("file");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new ImageDataModel(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), this.__dataConverter.toMetaData(query.getString(columnIndexOrThrow3)), this.__dataConverter.toFile(query.getString(columnIndexOrThrow4))));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
*/

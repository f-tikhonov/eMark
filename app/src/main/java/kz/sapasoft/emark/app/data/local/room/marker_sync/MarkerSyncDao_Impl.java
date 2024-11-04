package kz.sapasoft.emark.app.data.local.room.marker_sync;

import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kz.sapasoft.emark.app.data.local.room.DataConverter;
import kz.sapasoft.emark.app.domain.model.MarkerModelSync;

public final class MarkerSyncDao_Impl implements MarkerSyncDao {
    /* access modifiers changed from: private */
    public final DataConverter __dataConverter = new DataConverter();
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfMarkerModelSync;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;

    public MarkerSyncDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfMarkerModelSync = new EntityInsertionAdapter<MarkerModelSync>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `marker_sync_table`(`id`,`updated`,`templateId`,`markerId`,`markerModel`,`color`,`passiveId`,`projectIds`,`depth`,`location`,`fields`,`generalId`,`markerType`,`idLocal`,`status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, MarkerModelSync markerModelSync) {
                if (markerModelSync.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, markerModelSync.getId());
                }
                if (markerModelSync.getUpdated() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindLong(2, markerModelSync.getUpdated().longValue());
                }
                if (markerModelSync.getTemplateId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, markerModelSync.getTemplateId());
                }
                if (markerModelSync.getMarkerId() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, markerModelSync.getMarkerId());
                }
                if (markerModelSync.getMarkerModel() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, markerModelSync.getMarkerModel());
                }
                if (markerModelSync.getColor() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, markerModelSync.getColor());
                }
                if (markerModelSync.getPassiveId() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, markerModelSync.getPassiveId());
                }
                String fromStringList = MarkerSyncDao_Impl.this.__dataConverter.fromStringList(markerModelSync.getProjectIds());
                if (fromStringList == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, fromStringList);
                }
                if (markerModelSync.getDepth() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindDouble(9, markerModelSync.getDepth().doubleValue());
                }
                String fromDoubleList = MarkerSyncDao_Impl.this.__dataConverter.fromDoubleList(markerModelSync.getLocation());
                if (fromDoubleList == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, fromDoubleList);
                }
                String fromFieldModelList = MarkerSyncDao_Impl.this.__dataConverter.fromFieldModelList(markerModelSync.getFields());
                if (fromFieldModelList == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, fromFieldModelList);
                }
                if (markerModelSync.getGeneralId() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, markerModelSync.getGeneralId());
                }
                if (markerModelSync.getMarkerType() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, markerModelSync.getMarkerType());
                }
                if (markerModelSync.getIdLocal() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, markerModelSync.getIdLocal());
                }
                String fromMarkerStatus = MarkerSyncDao_Impl.this.__dataConverter.fromMarkerStatus(markerModelSync.getStatus());
                if (fromMarkerStatus == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, fromMarkerStatus);
                }
            }
        };
        this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM marker_sync_table WHERE id = ?";
            }
        };
    }

    public void insertWithReplace(MarkerModelSync markerModelSync) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfMarkerModelSync.insert(markerModelSync);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void insertWithReplace(List<MarkerModelSync> list) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfMarkerModelSync.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteById(String str) {
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteById.acquire();
        this.__db.beginTransaction();
        if (str == null) {
            try {
                acquire.bindNull(1);
            } catch (Throwable th) {
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteById.release(acquire);
                throw th;
            }
        } else {
            acquire.bindString(1, str);
        }
        acquire.executeUpdateDelete();
        this.__db.setTransactionSuccessful();
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteById.release(acquire);
    }

    public List<MarkerModelSync> findByProjectId(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        Long l;
        Double d;
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM marker_sync_table WHERE projectIds LIKE '%' || ?  || '%'", 1);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        Cursor query = this.__db.query(acquire);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("updated");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("templateId");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("markerId");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("markerModel");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("color");
            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("passiveId");
            int columnIndexOrThrow8 = query.getColumnIndexOrThrow("projectIds");
            int columnIndexOrThrow9 = query.getColumnIndexOrThrow("depth");
            int columnIndexOrThrow10 = query.getColumnIndexOrThrow(FirebaseAnalytics.Param.LOCATION);
            int columnIndexOrThrow11 = query.getColumnIndexOrThrow("fields");
            int columnIndexOrThrow12 = query.getColumnIndexOrThrow("generalId");
            int columnIndexOrThrow13 = query.getColumnIndexOrThrow("markerType");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = query.getColumnIndexOrThrow("idLocal");
                int columnIndexOrThrow15 = query.getColumnIndexOrThrow(NotificationCompat.CATEGORY_STATUS);
                int i = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow2));
                    }
                    String string2 = query.getString(columnIndexOrThrow3);
                    String string3 = query.getString(columnIndexOrThrow4);
                    String string4 = query.getString(columnIndexOrThrow5);
                    String string5 = query.getString(columnIndexOrThrow6);
                    String string6 = query.getString(columnIndexOrThrow7);
                    int i2 = columnIndexOrThrow;
                    List<String> stringList = this.__dataConverter.toStringList(query.getString(columnIndexOrThrow8));
                    if (query.isNull(columnIndexOrThrow9)) {
                        d = null;
                    } else {
                        d = Double.valueOf(query.getDouble(columnIndexOrThrow9));
                    }
                    int i3 = i;
                    int i4 = columnIndexOrThrow14;
                    i = i3;
                    int i5 = columnIndexOrThrow2;
                    int i6 = columnIndexOrThrow15;
                    columnIndexOrThrow15 = i6;
                    arrayList.add(new MarkerModelSync(string, l, string2, string3, string4, string5, string6, stringList, d, this.__dataConverter.toDoubleList(query.getString(columnIndexOrThrow10)), this.__dataConverter.toFieldModelList(query.getString(columnIndexOrThrow11)), query.getString(columnIndexOrThrow12), query.getString(i3), query.getString(i4), this.__dataConverter.toMarkerStatus(query.getString(i6))));
                    columnIndexOrThrow2 = i5;
                    columnIndexOrThrow14 = i4;
                    columnIndexOrThrow = i2;
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

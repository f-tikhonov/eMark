package kz.sapasoft.emark.app.data.local.room.marker;

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
import kz.sapasoft.emark.app.domain.model.MarkerModel;

public final class MarkerDao_Impl implements MarkerDao {
    /* access modifiers changed from: private */
    public final DataConverter __dataConverter = new DataConverter();
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfMarkerModel;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByProjectId;

    public MarkerDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfMarkerModel = new EntityInsertionAdapter<MarkerModel>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `marker_table`(`id`,`updated`,`templateId`,`markerId`,`markerModel`,`color`,`passiveId`,`projectIds`,`depth`,`location`,`fields`,`generalId`,`markerType`,`idLocal`,`status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, MarkerModel markerModel) {
                if (markerModel.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, markerModel.getId());
                }
                if (markerModel.getUpdated() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindLong(2, markerModel.getUpdated().longValue());
                }
                if (markerModel.getTemplateId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, markerModel.getTemplateId());
                }
                if (markerModel.getMarkerId() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, markerModel.getMarkerId());
                }
                if (markerModel.getMarkerModel() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, markerModel.getMarkerModel());
                }
                if (markerModel.getColor() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, markerModel.getColor());
                }
                if (markerModel.getPassiveId() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, markerModel.getPassiveId());
                }
                String fromStringList = MarkerDao_Impl.this.__dataConverter.fromStringList(markerModel.getProjectIds());
                if (fromStringList == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, fromStringList);
                }
                if (markerModel.getDepth() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindDouble(9, markerModel.getDepth().doubleValue());
                }
                String fromDoubleList = MarkerDao_Impl.this.__dataConverter.fromDoubleList(markerModel.getLocation());
                if (fromDoubleList == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, fromDoubleList);
                }
                String fromFieldModelList = MarkerDao_Impl.this.__dataConverter.fromFieldModelList(markerModel.getFields());
                if (fromFieldModelList == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, fromFieldModelList);
                }
                if (markerModel.getGeneralId() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, markerModel.getGeneralId());
                }
                if (markerModel.getMarkerType() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, markerModel.getMarkerType());
                }
                if (markerModel.getIdLocal() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, markerModel.getIdLocal());
                }
                String fromMarkerStatus = MarkerDao_Impl.this.__dataConverter.fromMarkerStatus(markerModel.getStatus());
                if (fromMarkerStatus == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, fromMarkerStatus);
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM marker_table";
            }
        };
        this.__preparedStmtOfDeleteByProjectId = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM marker_table WHERE projectIds LIKE '%' || ?  || '%'";
            }
        };
    }

    public void insertWithReplace(MarkerModel markerModel) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfMarkerModel.insert(markerModel);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void insertWithReplace(List<MarkerModel> list) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfMarkerModel.insert(list);
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

    public void deleteByProjectId(String str) {
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteByProjectId.acquire();
        this.__db.beginTransaction();
        if (str == null) {
            try {
                acquire.bindNull(1);
            } catch (Throwable th) {
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteByProjectId.release(acquire);
                throw th;
            }
        } else {
            acquire.bindString(1, str);
        }
        acquire.executeUpdateDelete();
        this.__db.setTransactionSuccessful();
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByProjectId.release(acquire);
    }

    public List<MarkerModel> findByProjectId(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        Long l;
        Double d;
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM marker_table WHERE projectIds LIKE '%' || ?  || '%'", 1);
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
                    arrayList.add(new MarkerModel(string, l, string2, string3, string4, string5, string6, stringList, d, this.__dataConverter.toDoubleList(query.getString(columnIndexOrThrow10)), this.__dataConverter.toFieldModelList(query.getString(columnIndexOrThrow11)), query.getString(columnIndexOrThrow12), query.getString(i3), query.getString(i4), this.__dataConverter.toMarkerStatus(query.getString(i6))));
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

    public List<MarkerModel> findAll(int i, int i2) {
        RoomSQLiteQuery roomSQLiteQuery;
        Long l;
        Double d;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from marker_table LIMIT ? OFFSET ?", 2);
        acquire.bindLong(1, (long) i);
        acquire.bindLong(2, (long) i2);
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
                int i3 = columnIndexOrThrow13;
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
                    int i4 = columnIndexOrThrow;
                    List<String> stringList = this.__dataConverter.toStringList(query.getString(columnIndexOrThrow8));
                    if (query.isNull(columnIndexOrThrow9)) {
                        d = null;
                    } else {
                        d = Double.valueOf(query.getDouble(columnIndexOrThrow9));
                    }
                    int i5 = i3;
                    int i6 = columnIndexOrThrow14;
                    i3 = i5;
                    int i7 = columnIndexOrThrow2;
                    int i8 = columnIndexOrThrow15;
                    columnIndexOrThrow15 = i8;
                    arrayList.add(new MarkerModel(string, l, string2, string3, string4, string5, string6, stringList, d, this.__dataConverter.toDoubleList(query.getString(columnIndexOrThrow10)), this.__dataConverter.toFieldModelList(query.getString(columnIndexOrThrow11)), query.getString(columnIndexOrThrow12), query.getString(i5), query.getString(i6), this.__dataConverter.toMarkerStatus(query.getString(i8))));
                    columnIndexOrThrow2 = i7;
                    columnIndexOrThrow14 = i6;
                    columnIndexOrThrow = i4;
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

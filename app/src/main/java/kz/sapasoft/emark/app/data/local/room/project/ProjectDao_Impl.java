package kz.sapasoft.emark.app.data.local.room.project;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import kz.sapasoft.emark.app.data.local.room.DataConverter;
import kz.sapasoft.emark.app.domain.model.ProjectModel;

public final class ProjectDao_Impl implements ProjectDao {
    /* access modifiers changed from: private */
    public final DataConverter __dataConverter = new DataConverter();
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfProjectModel;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public ProjectDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfProjectModel = new EntityInsertionAdapter<ProjectModel>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `project_table`(`id`,`markerTemplateIds`,`name`,`regionName`) VALUES (?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, ProjectModel projectModel) {
                if (projectModel.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, projectModel.getId());
                }
                String fromStringList = ProjectDao_Impl.this.__dataConverter.fromStringList(projectModel.getMarkerTemplateIds());
                if (fromStringList == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, fromStringList);
                }
                if (projectModel.getName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, projectModel.getName());
                }
                if (projectModel.getRegionName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, projectModel.getRegionName());
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM project_table";
            }
        };
    }

    public void insert(ProjectModel projectModel) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfProjectModel.insert(projectModel);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void insert(List<ProjectModel> list) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfProjectModel.insert(list);
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

    public List<ProjectModel> findAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from project_table", 0);
        Cursor query = this.__db.query(acquire);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("markerTemplateIds");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow(AppMeasurementSdk.ConditionalUserProperty.NAME);
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("regionName");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new ProjectModel(query.getString(columnIndexOrThrow), this.__dataConverter.toStringList(query.getString(columnIndexOrThrow2)), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}

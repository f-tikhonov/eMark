package kz.sapasoft.emark.app.data.local.room;

import androidx.core.app.NotificationCompat;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.HashSet;
import kz.sapasoft.emark.app.data.local.room.image.ImageDao;
import kz.sapasoft.emark.app.data.local.room.image.ImageDao_Impl;
import kz.sapasoft.emark.app.data.local.room.marker.MarkerDao;
import kz.sapasoft.emark.app.data.local.room.marker.MarkerDao_Impl;
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncDao;
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncDao_Impl;
import kz.sapasoft.emark.app.data.local.room.project.ProjectDao;
import kz.sapasoft.emark.app.data.local.room.project.ProjectDao_Impl;
import kz.sapasoft.emark.app.data.local.room.tag.TagDao;
import kz.sapasoft.emark.app.data.local.room.tag.TagDao_Impl;
import kz.sapasoft.emark.app.data.local.room.template.TemplateDao;
import kz.sapasoft.emark.app.data.local.room.template.TemplateDao_Impl;

public final class LocalDatabase_Impl extends LocalDatabase {
    private volatile ImageDao _imageDao;
    private volatile MarkerDao _markerDao;
    private volatile MarkerSyncDao _markerSyncDao;
    private volatile ProjectDao _projectDao;
    private volatile TagDao _tagDao;
    private volatile TemplateDao _templateDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `project_table` (`id` TEXT NOT NULL, `markerTemplateIds` TEXT NOT NULL, `name` TEXT NOT NULL, `regionName` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `tag_table` (`id` TEXT NOT NULL, `createdById` TEXT, `created` INTEGER, `updatedById` TEXT, `updated` INTEGER, `frontData` TEXT, `templateId` TEXT, `name` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `template_table` (`id` TEXT NOT NULL, `createdById` TEXT NOT NULL, `created` INTEGER NOT NULL, `updatedById` TEXT, `updated` INTEGER NOT NULL, `privileges` TEXT NOT NULL, `frontData` TEXT NOT NULL, `name` TEXT NOT NULL, `descr` TEXT NOT NULL, `fields` TEXT NOT NULL, `color` TEXT NOT NULL, `markerModels` TEXT NOT NULL, `markerTypes` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `marker_table` (`id` TEXT NOT NULL, `updated` INTEGER, `templateId` TEXT, `markerId` TEXT, `markerModel` TEXT, `color` TEXT, `passiveId` TEXT, `projectIds` TEXT, `depth` REAL, `location` TEXT, `fields` TEXT, `generalId` TEXT, `markerType` TEXT, `idLocal` TEXT, `status` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `marker_sync_table` (`id` TEXT NOT NULL, `updated` INTEGER, `templateId` TEXT, `markerId` TEXT, `markerModel` TEXT, `color` TEXT, `passiveId` TEXT, `projectIds` TEXT, `depth` REAL, `location` TEXT, `fields` TEXT, `generalId` TEXT, `markerType` TEXT, `idLocal` TEXT, `status` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `image_table` (`id` TEXT NOT NULL, `localIdParent` TEXT, `metadata` TEXT, `file` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"84a8cb60b4604c9828bcdd284012e41b\")");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `project_table`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `tag_table`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `template_table`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `marker_table`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `marker_sync_table`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `image_table`");
            }

            /* access modifiers changed from: protected */
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (LocalDatabase_Impl.this.mCallbacks != null) {
                    int size = LocalDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) LocalDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = LocalDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                LocalDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (LocalDatabase_Impl.this.mCallbacks != null) {
                    int size = LocalDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) LocalDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(4);
                hashMap.put("id", new TableInfo.Column("id", "TEXT", true, 1));
                hashMap.put("markerTemplateIds", new TableInfo.Column("markerTemplateIds", "TEXT", true, 0));
                hashMap.put(AppMeasurementSdk.ConditionalUserProperty.NAME, new TableInfo.Column(AppMeasurementSdk.ConditionalUserProperty.NAME, "TEXT", true, 0));
                hashMap.put("regionName", new TableInfo.Column("regionName", "TEXT", true, 0));
                TableInfo tableInfo = new TableInfo("project_table", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "project_table");
                if (tableInfo.equals(read)) {
                    HashMap hashMap2 = new HashMap(8);
                    hashMap2.put("id", new TableInfo.Column("id", "TEXT", true, 1));
                    hashMap2.put("createdById", new TableInfo.Column("createdById", "TEXT", false, 0));
                    hashMap2.put("created", new TableInfo.Column("created", "INTEGER", false, 0));
                    hashMap2.put("updatedById", new TableInfo.Column("updatedById", "TEXT", false, 0));
                    hashMap2.put("updated", new TableInfo.Column("updated", "INTEGER", false, 0));
                    hashMap2.put("frontData", new TableInfo.Column("frontData", "TEXT", false, 0));
                    hashMap2.put("templateId", new TableInfo.Column("templateId", "TEXT", false, 0));
                    hashMap2.put(AppMeasurementSdk.ConditionalUserProperty.NAME, new TableInfo.Column(AppMeasurementSdk.ConditionalUserProperty.NAME, "TEXT", false, 0));
                    String str = "\n Found:\n";
                    TableInfo tableInfo2 = new TableInfo("tag_table", hashMap2, new HashSet(0), new HashSet(0));
                    TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "tag_table");
                    if (tableInfo2.equals(read2)) {
                        HashMap hashMap3 = new HashMap(13);
                        hashMap3.put("id", new TableInfo.Column("id", "TEXT", true, 1));
                        hashMap3.put("createdById", new TableInfo.Column("createdById", "TEXT", true, 0));
                        hashMap3.put("created", new TableInfo.Column("created", "INTEGER", true, 0));
                        hashMap3.put("updatedById", new TableInfo.Column("updatedById", "TEXT", false, 0));
                        hashMap3.put("updated", new TableInfo.Column("updated", "INTEGER", true, 0));
                        hashMap3.put("privileges", new TableInfo.Column("privileges", "TEXT", true, 0));
                        hashMap3.put("frontData", new TableInfo.Column("frontData", "TEXT", true, 0));
                        hashMap3.put(AppMeasurementSdk.ConditionalUserProperty.NAME, new TableInfo.Column(AppMeasurementSdk.ConditionalUserProperty.NAME, "TEXT", true, 0));
                        hashMap3.put("descr", new TableInfo.Column("descr", "TEXT", true, 0));
                        hashMap3.put("fields", new TableInfo.Column("fields", "TEXT", true, 0));
                        hashMap3.put("color", new TableInfo.Column("color", "TEXT", true, 0));
                        hashMap3.put("markerModels", new TableInfo.Column("markerModels", "TEXT", true, 0));
                        hashMap3.put("markerTypes", new TableInfo.Column("markerTypes", "TEXT", true, 0));
                        TableInfo tableInfo3 = new TableInfo("template_table", hashMap3, new HashSet(0), new HashSet(0));
                        TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "template_table");
                        if (tableInfo3.equals(read3)) {
                            HashMap hashMap4 = new HashMap(15);
                            hashMap4.put("id", new TableInfo.Column("id", "TEXT", true, 1));
                            hashMap4.put("updated", new TableInfo.Column("updated", "INTEGER", false, 0));
                            hashMap4.put("templateId", new TableInfo.Column("templateId", "TEXT", false, 0));
                            hashMap4.put("markerId", new TableInfo.Column("markerId", "TEXT", false, 0));
                            hashMap4.put("markerModel", new TableInfo.Column("markerModel", "TEXT", false, 0));
                            hashMap4.put("color", new TableInfo.Column("color", "TEXT", false, 0));
                            hashMap4.put("passiveId", new TableInfo.Column("passiveId", "TEXT", false, 0));
                            hashMap4.put("projectIds", new TableInfo.Column("projectIds", "TEXT", false, 0));
                            String str2 = "projectIds";
                            hashMap4.put("depth", new TableInfo.Column("depth", "REAL", false, 0));
                            hashMap4.put(FirebaseAnalytics.Param.LOCATION, new TableInfo.Column(FirebaseAnalytics.Param.LOCATION, "TEXT", false, 0));
                            hashMap4.put("fields", new TableInfo.Column("fields", "TEXT", false, 0));
                            String str3 = "fields";
                            hashMap4.put("generalId", new TableInfo.Column("generalId", "TEXT", false, 0));
                            String str4 = "generalId";
                            hashMap4.put("markerType", new TableInfo.Column("markerType", "TEXT", false, 0));
                            hashMap4.put("idLocal", new TableInfo.Column("idLocal", "TEXT", false, 0));
                            hashMap4.put(NotificationCompat.CATEGORY_STATUS, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "TEXT", false, 0));
                            HashSet hashSet = new HashSet(0);
                            HashSet hashSet2 = new HashSet(0);
                            String str5 = FirebaseAnalytics.Param.LOCATION;
                            TableInfo tableInfo4 = new TableInfo("marker_table", hashMap4, hashSet, hashSet2);
                            TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, "marker_table");
                            if (tableInfo4.equals(read4)) {
                                HashMap hashMap5 = new HashMap(15);
                                hashMap5.put("id", new TableInfo.Column("id", "TEXT", true, 1));
                                hashMap5.put("updated", new TableInfo.Column("updated", "INTEGER", false, 0));
                                hashMap5.put("templateId", new TableInfo.Column("templateId", "TEXT", false, 0));
                                hashMap5.put("markerId", new TableInfo.Column("markerId", "TEXT", false, 0));
                                hashMap5.put("markerModel", new TableInfo.Column("markerModel", "TEXT", false, 0));
                                hashMap5.put("color", new TableInfo.Column("color", "TEXT", false, 0));
                                hashMap5.put("passiveId", new TableInfo.Column("passiveId", "TEXT", false, 0));
                                String str6 = str2;
                                hashMap5.put(str6, new TableInfo.Column(str6, "TEXT", false, 0));
                                hashMap5.put("depth", new TableInfo.Column("depth", "REAL", false, 0));
                                String str7 = str5;
                                hashMap5.put(str7, new TableInfo.Column(str7, "TEXT", false, 0));
                                String str8 = str3;
                                hashMap5.put(str8, new TableInfo.Column(str8, "TEXT", false, 0));
                                String str9 = str4;
                                hashMap5.put(str9, new TableInfo.Column(str9, "TEXT", false, 0));
                                hashMap5.put("markerType", new TableInfo.Column("markerType", "TEXT", false, 0));
                                hashMap5.put("idLocal", new TableInfo.Column("idLocal", "TEXT", false, 0));
                                hashMap5.put(NotificationCompat.CATEGORY_STATUS, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "TEXT", false, 0));
                                TableInfo tableInfo5 = new TableInfo("marker_sync_table", hashMap5, new HashSet(0), new HashSet(0));
                                TableInfo read5 = TableInfo.read(supportSQLiteDatabase2, "marker_sync_table");
                                if (tableInfo5.equals(read5)) {
                                    HashMap hashMap6 = new HashMap(4);
                                    hashMap6.put("id", new TableInfo.Column("id", "TEXT", true, 1));
                                    hashMap6.put("localIdParent", new TableInfo.Column("localIdParent", "TEXT", false, 0));
                                    hashMap6.put("metadata", new TableInfo.Column("metadata", "TEXT", false, 0));
                                    hashMap6.put("file", new TableInfo.Column("file", "TEXT", false, 0));
                                    TableInfo tableInfo6 = new TableInfo("image_table", hashMap6, new HashSet(0), new HashSet(0));
                                    TableInfo read6 = TableInfo.read(supportSQLiteDatabase2, "image_table");
                                    if (!tableInfo6.equals(read6)) {
                                        throw new IllegalStateException("Migration didn't properly handle image_table(kz.sapasoft.emark.app.domain.model.ImageDataModel).\n Expected:\n" + tableInfo6 + str + read6);
                                    }
                                    return;
                                }
                                throw new IllegalStateException("Migration didn't properly handle marker_sync_table(kz.sapasoft.emark.app.domain.model.MarkerModelSync).\n Expected:\n" + tableInfo5 + str + read5);
                            }
                            throw new IllegalStateException("Migration didn't properly handle marker_table(kz.sapasoft.emark.app.domain.model.MarkerModel).\n Expected:\n" + tableInfo4 + str + read4);
                        }
                        throw new IllegalStateException("Migration didn't properly handle template_table(kz.sapasoft.emark.app.domain.model.TemplateModel).\n Expected:\n" + tableInfo3 + str + read3);
                    }
                    throw new IllegalStateException("Migration didn't properly handle tag_table(kz.sapasoft.emark.app.domain.model.TagModel).\n Expected:\n" + tableInfo2 + str + read2);
                }
                throw new IllegalStateException("Migration didn't properly handle project_table(kz.sapasoft.emark.app.domain.model.ProjectModel).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        }, "84a8cb60b4604c9828bcdd284012e41b", "b34a78d3e9ed1147d8f4d230187b12e2")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, "project_table", "tag_table", "template_table", "marker_table", "marker_sync_table", "image_table");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `project_table`");
            writableDatabase.execSQL("DELETE FROM `tag_table`");
            writableDatabase.execSQL("DELETE FROM `template_table`");
            writableDatabase.execSQL("DELETE FROM `marker_table`");
            writableDatabase.execSQL("DELETE FROM `marker_sync_table`");
            writableDatabase.execSQL("DELETE FROM `image_table`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    public ProjectDao getProjectDao() {
        ProjectDao projectDao;
        if (this._projectDao != null) {
            return this._projectDao;
        }
        synchronized (this) {
            if (this._projectDao == null) {
                this._projectDao = new ProjectDao_Impl(this);
            }
            projectDao = this._projectDao;
        }
        return projectDao;
    }

    public TagDao getTagDao() {
        TagDao tagDao;
        if (this._tagDao != null) {
            return this._tagDao;
        }
        synchronized (this) {
            if (this._tagDao == null) {
                this._tagDao = new TagDao_Impl(this);
            }
            tagDao = this._tagDao;
        }
        return tagDao;
    }

    public TemplateDao getTemplateDao() {
        TemplateDao templateDao;
        if (this._templateDao != null) {
            return this._templateDao;
        }
        synchronized (this) {
            if (this._templateDao == null) {
                this._templateDao = new TemplateDao_Impl(this);
            }
            templateDao = this._templateDao;
        }
        return templateDao;
    }

    public MarkerDao getMarkerDao() {
        MarkerDao markerDao;
        if (this._markerDao != null) {
            return this._markerDao;
        }
        synchronized (this) {
            if (this._markerDao == null) {
                this._markerDao = new MarkerDao_Impl(this);
            }
            markerDao = this._markerDao;
        }
        return markerDao;
    }

    public MarkerSyncDao getMarkerSyncDao() {
        MarkerSyncDao markerSyncDao;
        if (this._markerSyncDao != null) {
            return this._markerSyncDao;
        }
        synchronized (this) {
            if (this._markerSyncDao == null) {
                this._markerSyncDao = new MarkerSyncDao_Impl(this);
            }
            markerSyncDao = this._markerSyncDao;
        }
        return markerSyncDao;
    }

    public ImageDao getImageDao() {
        ImageDao imageDao;
        if (this._imageDao != null) {
            return this._imageDao;
        }
        synchronized (this) {
            if (this._imageDao == null) {
                this._imageDao = new ImageDao_Impl(this);
            }
            imageDao = this._imageDao;
        }
        return imageDao;
    }
}

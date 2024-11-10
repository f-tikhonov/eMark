package kz.sapasoft.emark.app.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kz.sapasoft.emark.app.data.local.room.convertors.DoublesContainer
import kz.sapasoft.emark.app.data.local.room.convertors.FieldModelConverters
import kz.sapasoft.emark.app.data.local.room.convertors.FileConverter
import kz.sapasoft.emark.app.data.local.room.convertors.MapConverter
import kz.sapasoft.emark.app.data.local.room.convertors.MetaDataConverter
import kz.sapasoft.emark.app.data.local.room.convertors.StringsConverters
import kz.sapasoft.emark.app.data.local.room.image.ImageDao
import kz.sapasoft.emark.app.data.local.room.marker.MarkerDao
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncDao
import kz.sapasoft.emark.app.data.local.room.project.ProjectDao
import kz.sapasoft.emark.app.data.local.room.tag.TagDao
import kz.sapasoft.emark.app.data.local.room.template.TemplateDao
import kz.sapasoft.emark.app.domain.model.ImageDataModel
import kz.sapasoft.emark.app.domain.model.MarkerModel
import kz.sapasoft.emark.app.domain.model.MarkerModelSync
import kz.sapasoft.emark.app.domain.model.ProjectModel
import kz.sapasoft.emark.app.domain.model.TagModel
import kz.sapasoft.emark.app.domain.model.TemplateModel

@Database(
    entities = [TagModel::class, ProjectModel::class, MarkerModelSync::class, MarkerModel::class, ImageDataModel::class, TemplateModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(StringsConverters::class, FieldModelConverters::class, DoublesContainer::class, MetaDataConverter::class, FileConverter::class, MapConverter::class)
abstract class LocalDatabase : RoomDatabase() {

    abstract val imageDao: ImageDao

    abstract val markerDao: MarkerDao

    abstract val markerSyncDao: MarkerSyncDao

    abstract val projectDao: ProjectDao

    abstract val tagDao: TagDao

    abstract val templateDao: TemplateDao

    companion object {
        private var instance: LocalDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): LocalDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx.applicationContext, LocalDatabase::class.java,
                    "note_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

            return instance!!

        }
    }
}

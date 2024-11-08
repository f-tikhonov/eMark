/*
package kz.sapasoft.emark.app.data.local.room.marker

import android.database.Cursor
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteStatement
import kz.sapasoft.emark.app.data.local.room.DataConverter
import kz.sapasoft.emark.app.domain.model.MarkerModel

//@Dao
interface MarkerDao_Impl(private val db: RoomDatabase) : MarkerDao {

    private val dataConverter = DataConverter()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(markerModel: MarkerModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(markerModels: List<MarkerModel>)

    // @Query("DELETE FROM marker_table")
    fun deleteAll()

    // @Query("DELETE FROM marker_table WHERE projectIds LIKE '%' || :projectId || '%'")
    fun deleteByProjectId(projectId: String)

    //  @Query("SELECT * FROM marker_table WHERE projectIds LIKE '%' || :projectId || '%'")
    fun findByProjectId(projectId: String): List<MarkerModel>

    // @Query("SELECT * FROM marker_table LIMIT :limit OFFSET :offset")
    override fun findAll(limit: Int, offset: Int): List<MarkerModel>

    fun bindMarkerModel(statement: SupportSQLiteStatement, markerModel: MarkerModel) {
        statement.bindStringOrNull(1, markerModel.id)
        statement.bindLongOrNull(2, markerModel.updated?.toLong())
        statement.bindStringOrNull(3, markerModel.templateId)
        statement.bindStringOrNull(4, markerModel.markerId)
        statement.bindStringOrNull(5, markerModel.markerModel)
        statement.bindStringOrNull(6, markerModel.color)
        statement.bindStringOrNull(7, markerModel.passiveId)
        statement.bindStringOrNull(8, dataConverter.fromStringList(markerModel.projectIds))
        statement.bindDoubleOrNull(9, markerModel.depth?.toDouble())
        statement.bindStringOrNull(10, dataConverter.fromDoubleList(markerModel.location))
        statement.bindStringOrNull(11, dataConverter.fromFieldModelList(markerModel.fields))
        statement.bindStringOrNull(12, markerModel.generalId)
        statement.bindStringOrNull(13, markerModel.markerType)
        statement.bindStringOrNull(14, markerModel.idLocal)
        statement.bindStringOrNull(15, dataConverter.fromMarkerStatus(markerModel.status))
    }
}

// Extension functions for optional binding
fun SupportSQLiteStatement.bindStringOrNull(index: Int, value: String?) {
    if (value == null) bindNull(index) else bindString(index, value)
}

fun SupportSQLiteStatement.bindLongOrNull(index: Int, value: Long?) {
    if (value == null) bindNull(index) else bindLong(index, value)
}

fun SupportSQLiteStatement.bindDoubleOrNull(index: Int, value: Double?) {
    if (value == null) bindNull(index) else bindDouble(index, value)
}*/

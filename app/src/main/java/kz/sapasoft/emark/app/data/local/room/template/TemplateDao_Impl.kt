/*
package kz.sapasoft.emark.app.data.local.room.template

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteStatement
import kz.sapasoft.emark.app.data.local.room.DataConverter
import kz.sapasoft.emark.app.domain.model.FieldModel
import kz.sapasoft.emark.app.domain.model.TemplateModel

//@Dao
interface TemplateDao_Impl(private val db: RoomDatabase) : TemplateDao {

    //private val dataConverter = DataConverter()

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(templateModels: List<TemplateModel>)

   // @Query("DELETE FROM template_table")
    override fun deleteAll()

   // @Query("SELECT * FROM template_table WHERE id = :id")
   fun findById(id: String): List<TemplateModel>

    private fun bindTemplateModel(statement: SupportSQLiteStatement, templateModel: TemplateModel) {
        statement.bindStringOrNull(1, templateModel.id)
        statement.bindStringOrNull(2, templateModel.createdById)
        statement.bindLong(3, templateModel.created)
        statement.bindStringOrNull(4, templateModel.updatedById)
        statement.bindLong(5, templateModel.updated)
       // statement.bindStringOrNull(6, dataConverter.fromStringList(templateModel.privileges))
        statement.bindStringOrNull(7, templateModel.frontData)
        statement.bindStringOrNull(8, templateModel.name)
        statement.bindStringOrNull(9, templateModel.descr)
      //  statement.bindStringOrNull(10, dataConverter.fromFieldModelList(templateModel.fields))
        statement.bindStringOrNull(11, templateModel.color)
     //   statement.bindStringOrNull(12, dataConverter.fromStringMap(templateModel.markerModels))
     //   statement.bindStringOrNull(13, dataConverter.fromStringList(templateModel.markerTypes))
    }
}

// Extension functions for binding nullable values
fun SupportSQLiteStatement.bindStringOrNull(index: Int, value: String?) {
    if (value == null) bindNull(index) else bindString(index, value)
}

fun SupportSQLiteStatement.bindLongOrNull(index: Int, value: Long?) {
    if (value == null) bindNull(index) else bindLong(index, value)
}*/

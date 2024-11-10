package kz.sapasoft.emark.app.data.local.room.template

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kz.sapasoft.emark.app.domain.model.TemplateModel


@Dao
interface TemplateDao {
    // Удаление всех записей из таблицы
    @Query("DELETE FROM template")
    fun deleteAll()

    // Поиск записей по ID
    @Query("SELECT * FROM template WHERE id = :id")
    fun findById(id: String?): List<TemplateModel>

    // Вставка списка записей с игнорированием конфликта
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(list: List<TemplateModel>)
}
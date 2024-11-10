package kz.sapasoft.emark.app.data.local.room.marker

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kz.sapasoft.emark.app.domain.model.MarkerModel

@Dao
interface MarkerDao {
    // Удаление всех записей из таблицы
    @Query("DELETE FROM marker")
    fun deleteAll()

    // Удаление записей по projectId
    @Query("DELETE FROM marker WHERE id = :projectId")
    fun deleteByProjectId(projectId: String)

    // Поиск записей с определёнными границами, например, для пагинации
    @Query("SELECT * FROM marker LIMIT :limit OFFSET :offset")
    fun findAll(limit: Int, offset: Int): List<MarkerModel>

    // Поиск записей по projectId
    @Query("SELECT * FROM marker WHERE id = :projectId")
    fun findByProjectId(projectId: String): List<MarkerModel>

    // Вставка списка с заменой при конфликте
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(markers: List<MarkerModel>)

    // Вставка одного объекта с заменой при конфликте
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWithReplace(marker: MarkerModel)
}
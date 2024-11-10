package kz.sapasoft.emark.app.data.local.room.tag;

import androidx.room.Dao;

import java.util.List;
import kotlin.Metadata;
import kz.sapasoft.emark.app.domain.model.TagModel;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TagDao {

    // Удаление всех записей из таблицы
    @Query("DELETE FROM tag")
    void deleteAll();

    // Поиск всех записей в таблице
    @Query("SELECT * FROM tag")
    List<TagModel> findAll();

    // Вставка списка записей с игнорированием конфликта
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<TagModel> list);
}


package kz.sapasoft.emark.app.data.local.room.image;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
import kotlin.Metadata;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;

@Dao
public interface ImageDao {

    // Удаление записей по значению localIdParent
    @Query("DELETE FROM image_data WHERE localIdParent = :localIdParent")
    void deleteByLocalIdParent(String localIdParent);

    // Поиск записей по значению localIdParent
    @Query("SELECT * FROM image_data WHERE localIdParent = :localIdParent")
    List<ImageDataModel> findByLocalIdParent(String localIdParent);

    // Вставка с заменой при конфликте
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWithReplace(List<ImageDataModel> list);
}

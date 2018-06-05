package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

import us.rst.farmacovigilanza.database.entity.DrugEntity;

@Dao
public interface DrugsDao {
    @Query("SELECT * FROM drugs")
    LiveData<List<DrugEntity>> getAll();

    @Query("SELECT * FROM drugs WHERE id=:id")
    LiveData<DrugEntity> getById(int id);

    @Insert
    void add(DrugEntity medicationEntity);
}

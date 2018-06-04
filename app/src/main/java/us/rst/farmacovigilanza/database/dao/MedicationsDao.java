package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
import us.rst.farmacovigilanza.database.entity.MedicationEntity;

@Dao
public interface MedicationsDao {
    @Query("SELECT * FROM medications")
    LiveData<List<MedicationEntity>> getAll();

    @Query("SELECT * FROM medications WHERE id=:id")
    LiveData<MedicationEntity> getById(int id);

    @Insert
    void add(MedicationEntity medicationEntity);
}

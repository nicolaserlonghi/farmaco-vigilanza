package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
import us.rst.farmacovigilanza.database.entity.TherapyEntity;
import us.rst.farmacovigilanza.models.FiscalCode;

@Dao
public interface TherapiesDao {
    @Insert
    void insert(TherapyEntity entity);

    @Query("SELECT * FROM therapies WHERE patient=:cf")
    LiveData<List<TherapyEntity>> getTherapiesLinkedToPatient(FiscalCode cf);
}

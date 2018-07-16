package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import us.rst.farmacovigilanza.database.entity.DoctorEntity;
import us.rst.farmacovigilanza.database.entity.PharmacologistEntity;

@Dao
public interface PharmacologistDao {
    @Query("SELECT * FROM pharamacologist WHERE id=:id")
    LiveData<PharmacologistEntity> getDoctor(String id, String password);

    @Insert
    void insert(DoctorEntity doctor);
}

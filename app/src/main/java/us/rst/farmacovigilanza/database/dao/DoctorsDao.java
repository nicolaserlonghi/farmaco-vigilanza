package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import us.rst.farmacovigilanza.database.entity.DoctorEntity;

@Dao
public interface DoctorsDao {
    @Query("SELECT * FROM doctors WHERE id=:id AND password=:password")
    LiveData<DoctorEntity> getDoctor(String id, String password);
}

package us.rst.farmacovigilanza.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import us.rst.farmacovigilanza.database.entity.PatientEntity;

@Dao
public interface PatientDao {
    @Insert
    void insert(PatientEntity doctor);
}

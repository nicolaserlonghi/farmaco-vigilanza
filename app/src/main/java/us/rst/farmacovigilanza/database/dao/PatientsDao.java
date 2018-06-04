package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.models.FiscalCode;

@Dao
public interface PatientsDao {
    @Query("SELECT * FROM patients WHERE fiscalCode=:fiscalCode")
    LiveData<PatientEntity> getOne(FiscalCode fiscalCode);

    @Insert
    void insert(PatientEntity doctor);
}

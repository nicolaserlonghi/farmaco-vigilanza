package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.database.entity.PatientFactorEntity;
import us.rst.farmacovigilanza.models.FiscalCode;

@Dao
public interface FactorsDao {
    @Query("SELECT * FROM factors JOIN patientFactor WHERE patientCf=:fiscalCode")
    LiveData<List<FactorEntity>> getByFiscalCode(FiscalCode fiscalCode);

    @Query("SELECT * FROM factors")
    LiveData<List<FactorEntity>> getAll();

    @Query("SELECT * FROM patientFactor WHERE patientCf=:cf")
    LiveData<List<PatientFactorEntity>> getFactorsLinkedToPatient(FiscalCode cf);

    @Insert
    void insert(FactorEntity factor);

    @Insert
    void linkToPatient(PatientFactorEntity patientFactorEntity);
}

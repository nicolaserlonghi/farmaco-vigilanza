package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.database.entity.PatientFactorEntity;
import us.rst.farmacovigilanza.database.entity.TherapyEntity;
import us.rst.farmacovigilanza.models.FiscalCode;

@Dao
public interface PatientsDao {
    @Query("SELECT * FROM patients WHERE fiscalCode=:fiscalCode")
    LiveData<PatientEntity> getOne(FiscalCode fiscalCode);

    @Query("SELECT * FROM patientFactor WHERE patientCf=:fiscalCode")
    LiveData<List<PatientFactorEntity>> getPatientFactors(FiscalCode fiscalCode);

    @Query("SELECT * FROM therapies WHERE patient=:fiscalCode")
    LiveData<List<TherapyEntity>> getTherapies(FiscalCode fiscalCode);

    @Query("DELETE FROM therapies WHERE patient=:fiscalCode AND medicine=:medicineName")
    void deleteTherapy(FiscalCode fiscalCode, String medicineName);

    @Query("DELETE FROM patientFactor WHERE patientCf=:fiscalCode AND factorName=:factorName")
    void deleteFactor(FiscalCode fiscalCode, String factorName);

    @Insert
    void insert(PatientEntity doctor);
}

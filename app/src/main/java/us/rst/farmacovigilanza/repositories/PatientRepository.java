package us.rst.farmacovigilanza.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.List;

import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.database.entity.PatientFactorEntity;
import us.rst.farmacovigilanza.database.entity.TherapyEntity;
import us.rst.farmacovigilanza.models.FiscalCode;

/**
 * Gestisce le interrogazioni al database per il dominio delle reazioni avverse
 */
public class PatientRepository extends BaseRepository {
    /**
     * Inizializza una nuova istanza di questa classe
     *
     * @param database database
     * @param appExecutors pool thread per esecuzione operazioni I/O
     */
    public PatientRepository(AppDatabase database, AppExecutors appExecutors) {
        super(database, appExecutors);
    }

    /**
     * Aggiunge una {@link PatientEntity} in memoria
     * ATTENZIONE: se la reazione avversa è già presente in memoria, il sistema crasha
     * @param patientEntity nuovo paziente
     * @param factors fattori di rischio legati al paziente
     * @param therapies terapia legate al paziente
     */
    public void add(PatientEntity patientEntity, List<PatientFactorEntity> factors, List<TherapyEntity> therapies){
        getAppExecutors().diskIO().execute(() -> {
            patientEntity.setDoctor(Prefs.getString("userId", ""));
            getDatabase().patientsDao().insert(patientEntity);
            for (PatientFactorEntity factor: factors) {
                factor.setPatientCf(patientEntity.getFiscalCode());
                getDatabase().factorsDao().linkToPatient(factor);
            }

            for (TherapyEntity therapy: therapies) {
                therapy.setPatient(patientEntity.getFiscalCode());
                getDatabase().therapyDao().insert(therapy);
            }
        });
    }

    /**
     * Restituisce una lista osservabile di tutti i {@link FactorEntity}
     * @return lista di {@link FactorEntity} osservabile
     */
    public LiveData<List<FactorEntity>> getFactors() {
        return getDatabase().factorsDao().getAll();
    }

    /**
     * Restituisce una lista osservabile di {@link PatientFactorEntity} collegati al paziente
     * @param cf codice fiscale del paziente
     * @return lista osservabile di {@link PatientFactorEntity} collegati al paziente
     */
    public LiveData<List<PatientFactorEntity>> getPatientFactors(String cf) {
        return getDatabase().patientsDao().getPatientFactors(FiscalCode.parse(cf));
    }

    /**
     * Restituisce una lista osservabile di {@link TherapyEntity}
     * @param cf codice fiscale del paziente
     * @return una lista osservabile di {@link TherapyEntity}
     */
    public LiveData<List<TherapyEntity>> getPatientTherapies(String cf) {
        return getDatabase().patientsDao().getTherapies(FiscalCode.parse(cf));
    }

    /**
     * Restituisce un oggetto osservabile di {@link PatientEntity}
     * @param cf codice fiscale del paziente
     * @return un oggetto osservabile di {@link PatientEntity}
     */
    public LiveData<PatientEntity> getPatient(String cf) {
        return getDatabase().patientsDao().getOne(FiscalCode.parse(cf));
    }

    /**
     * Cancella una terapia legata al paziente
     * @param cf codice fiscale del paziente
     * @param therapyName nome del farmaco legato alla terapia
     */
    public void deleteTherapy(String cf, String therapyName) {
        getAppExecutors().diskIO().execute(() -> {
            getDatabase().patientsDao().deleteTherapy(FiscalCode.parse(cf), therapyName);
        });
    }

    /**
     * Cancella un fattore di rischio legato al paziente
     * @param cf codice fiscale del paziente
     * @param factorName nome del fattore di rischio
     */
    public void deleteFactor(String cf, String factorName) {
        getAppExecutors().diskIO().execute(() -> {
            getDatabase().patientsDao().deleteFactor(FiscalCode.parse(cf), factorName);
        });
    }

    /**
     * Aggiunge un fattore di rischio legato al paziente
     * @param patientFactorEntity fattore di rischio legato al paziente
     */
    public void addFactor(PatientFactorEntity patientFactorEntity) {
        getAppExecutors().diskIO().execute(() -> {
            getDatabase().factorsDao().linkToPatient(patientFactorEntity);
        });
    }

    /**
     * Aggiunge una terapia legata al paziente
     * @param therapyEntity terapia legata al paziente
     */
    public void addTherapy(TherapyEntity therapyEntity) {
        getAppExecutors().diskIO().execute(() -> {
            getDatabase().therapyDao().insert(therapyEntity);
        });
    }
}

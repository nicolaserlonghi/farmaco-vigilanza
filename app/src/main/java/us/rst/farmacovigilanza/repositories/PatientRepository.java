package us.rst.farmacovigilanza.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.database.entity.PatientFactorEntity;
import us.rst.farmacovigilanza.database.entity.TherapyEntity;

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
        this.patientEntityLiveData = new MutableLiveData<>();
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

    private final MutableLiveData<PatientEntity> patientEntityLiveData;
}

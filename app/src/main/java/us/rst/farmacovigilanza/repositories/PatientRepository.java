package us.rst.farmacovigilanza.repositories;

import android.arch.lifecycle.MutableLiveData;

import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.PatientEntity;

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
     * @param patientEntity reazione avversa da salvare
     */
    public void add(PatientEntity patientEntity){
        getAppExecutors().diskIO().execute(() -> {
            getDatabase().patientsDao().insert(patientEntity);
        });
    }

    private final MutableLiveData<PatientEntity> patientEntityLiveData;
}

package us.rst.farmacovigilanza.repositories;

import android.arch.lifecycle.LiveData;
import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.DoctorEntity;
import us.rst.farmacovigilanza.models.Doctor;

/**
 * Gestisce le interrogazioni al database per il dominio dei dottori
 */
public class DoctorsRepository extends BaseRepository {
    /**
     * Inizializza una nuova istanza di questa classe
     *
     * @param database database
     * @param appExecutors pool thread per esecuzione operazioni I/O
     */
    public DoctorsRepository(AppDatabase database, AppExecutors appExecutors) {
        super(database, appExecutors);
    }

    /**
     * Restituisce il dottore date le credenziali di accesso al sistema
     * @param id id dottore
     * @return un'istanza di {@link Doctor} se il dottore esiste; altrimenti null
     */
    public LiveData<DoctorEntity> getDoctor(String id) {
        return getDatabase().doctorsDao().getDoctor(id);
    }
}

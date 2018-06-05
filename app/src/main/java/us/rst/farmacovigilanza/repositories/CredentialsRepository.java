package us.rst.farmacovigilanza.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.CredentialsEntity;

/**
 * Gestisce l'interazione con database per il login di dottore o farmacologo
 */
public class CredentialsRepository extends BaseRepository {
    /**
     * Inizializza una nuova istanza di questa classe
     *
     * @param database database
     * @param appExecutors pool thread per esecuzione operazioni I/O
     */
    public CredentialsRepository(AppDatabase database, AppExecutors appExecutors) {
        super(database, appExecutors);

        credentialsEntity = new MutableLiveData<>();
    }

    /**
     * Ricerca un utente dati id e password
     * @param id id utente
     * @param password password utente
     * @return un'istanza di {@link CredentialsEntity} osservabile
     */
    public LiveData<CredentialsEntity> getCredentials(final String id, final String password) {
        getAppExecutors().diskIO().execute(() -> {
            credentialsEntity.setValue(getDatabase().credentialsDao().getUser(id, password).getValue());
        });

        return credentialsEntity;
    }

    private final MutableLiveData<CredentialsEntity> credentialsEntity;
}

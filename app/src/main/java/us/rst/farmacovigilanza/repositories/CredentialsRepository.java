package us.rst.farmacovigilanza.repositories;

import android.arch.lifecycle.LiveData;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.CredentialsEntity;

/**
 * Gestisce le interrogazioni al database per il dominio degli utenti
 */
public class CredentialsRepository extends BaseRepository {
    /**
     * Inizializza una nuova istanza di questa classe
     * @param database un'istanza di {@link AppDatabase}
     */
    public CredentialsRepository(AppDatabase database) {
        super(database);
    }

    /**
     * Restituisce le credenziali dell'utente collegato
     * @param id id utente
     * @param password password utente
     * @return un oggetto osservabile con le credenziali dell'utente connesso
     */
    public LiveData<CredentialsEntity> getDoctor(String id, String password) {
        return getDatabase().credentialsDao().getUser(id, password);
    }
}

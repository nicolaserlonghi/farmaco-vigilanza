package us.rst.farmacovigilanza.repositories;


import android.arch.lifecycle.LiveData;

import java.util.List;

import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;

/**
 * Gestisce le interrogazioni al database per il dominio dei pazienti
 */
public class DrugsRepository extends BaseRepository {
    /**
     * Inizializza una nuova istanza di questa classe
     *
     * @param database database
     * @param appExecutors pool thread per esecuzione operazioni I/O
     */
    public DrugsRepository(AppDatabase database, AppExecutors appExecutors) {
        super(database, appExecutors);
    }

    /**
     * Restituisce una lista osservabile di farmaci
     * @return lista osservabile di farmaci
     */
    public LiveData<List<String>> getDrugs() {
        return getDatabase().drugsDao().getNames();
    }
}
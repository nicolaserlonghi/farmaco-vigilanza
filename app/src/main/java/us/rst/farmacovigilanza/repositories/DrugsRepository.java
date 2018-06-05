package us.rst.farmacovigilanza.repositories;


import android.arch.lifecycle.LiveData;

import java.util.List;

import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.DrugEntity;

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

    public LiveData<List<DrugEntity>> getReports() {
        return  getDatabase().drugsDao().getAll();
    }
}
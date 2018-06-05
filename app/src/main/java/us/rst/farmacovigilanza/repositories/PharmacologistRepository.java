package us.rst.farmacovigilanza.repositories;

import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;

/**
 * Gestisce le interrogazioni al database per il dominio dei farmacologi
 */
public class PharmacologistRepository extends BaseRepository {
    /**
     * Inizializza una nuova istanza di questa classe
     *
     * @param database database
     * @param appExecutors pool thread per esecuzione operazioni I/O
     */
    public PharmacologistRepository(AppDatabase database, AppExecutors appExecutors) {
        super(database, appExecutors);
    }
}

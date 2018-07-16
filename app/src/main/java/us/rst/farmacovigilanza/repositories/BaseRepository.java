package us.rst.farmacovigilanza.repositories;

import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;

/**
 * Base repository
 */
public abstract class BaseRepository {
    /**
     * Inizializza una nuova istanza di questa classe
     *
     * @param database database
     * @param appExecutors pool thread per esecuzione operazioni I/O
     */
    public BaseRepository(AppDatabase database, AppExecutors appExecutors) {
        this.database = database;
        this.appExecutors = appExecutors;
    }

    /**
     * Restituisce un'istanza di {@link AppDatabase}
     * @return istanza di {@link AppDatabase}
     */
    public AppDatabase getDatabase() {
        return database;
    }

    /**
     * Restituisce l'istanza globale di {@link AppExecutors}
     * @return istanza globale di {@link AppExecutors}
     */
    public AppExecutors getAppExecutors() {
        return appExecutors;
    }

    private final AppDatabase database;
    private final AppExecutors appExecutors;
}

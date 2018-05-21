package us.rst.farmacovigilanza.repositories;

import us.rst.farmacovigilanza.database.AppDatabase;

/**
 * Base repository
 */
public abstract class BaseRepository {
    /**
     * Initializes a new instance of this class
     * @param database database
     */
    public BaseRepository(AppDatabase database) {
        this.database = database;
    }

    /**
     * Gets an instance of the database
     * @return instance of database
     */
    public AppDatabase getDatabase() {
        return database;
    }

    private AppDatabase database;
}

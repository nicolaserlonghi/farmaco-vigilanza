package us.rst.farmacovigilanza;

import android.arch.persistence.room.Room;
import android.content.Context;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.repositories.DoctorsRepository;
import us.rst.farmacovigilanza.repositories.ReportsRepository;

/**
 * Wraps every repository of this project
 */
public class DataRepository {
    /**
     * Gets an instance of this class
     * @param appContext application context
     * @return an instance of {@link DataRepository}
     */
    public static DataRepository getInstance(final Context appContext, final AppExecutors appExecutors) {
        if (instance == null) {
            synchronized (DataRepository.class) {
                if (instance == null) {
                    instance = new DataRepository(appContext, appExecutors);
                }
            }
        }
        return instance;
    }

    private DataRepository(final Context context, final AppExecutors appExecutors) {
        database = Room.databaseBuilder(context, AppDatabase.class, "appDatabase").build();
        doctorsRepository = new DoctorsRepository(database);
        reportsRepository = new ReportsRepository(database);
    }

    private final AppDatabase database;
    private final DoctorsRepository doctorsRepository;
    private final ReportsRepository reportsRepository;
    private static DataRepository instance;
}

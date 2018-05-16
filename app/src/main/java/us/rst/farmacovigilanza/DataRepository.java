package us.rst.farmacovigilanza;

import android.content.Context;

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

    }

    private static DataRepository instance;
}

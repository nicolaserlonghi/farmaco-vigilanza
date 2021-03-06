package us.rst.farmacovigilanza;

import android.app.Application;
import android.content.ContextWrapper;
import com.pixplicity.easyprefs.library.Prefs;
import us.rst.farmacovigilanza.database.DummyContentLoader;

/**
 * Android Application class. Used for accessing singletons.
 */
public class FarmacoVigilanzaApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        appExecutors = new AppExecutors();

        // Builds preferences
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(BuildConfig.APPLICATION_ID)
                .setUseDefaultSharedPreference(true)
                .build();

        // Generate dummy content
        DummyContentLoader dummyContentLoader = new DummyContentLoader(this);
        dummyContentLoader.loadContent();
    }

    /**
     * Gets an instance of {@link DataRepository}
     * @return an instance of {@link DataRepository}
     */
    public DataRepository getDataRepository() {
        return DataRepository.getInstance(getApplicationContext(), appExecutors);
    }

    public AppExecutors getAppExecutors() {
        return appExecutors;
    }

    private AppExecutors appExecutors;
}

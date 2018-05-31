package us.rst.farmacovigilanza.database;

import android.app.Application;
import android.support.annotation.NonNull;
import us.rst.farmacovigilanza.FarmacoVigilanzaApp;

/**
 * Classe di supporto per l'inserimento di dati di test per la demo al cliente
 */
public class DummyContentLoader {
    /**
     * Inizializza una nuova istanza di questa classe
     * @param application istanza dell'applicazione
     */
    public DummyContentLoader(@NonNull Application application) {
        this.application = (FarmacoVigilanzaApp)application;
    }

    /**
     * Carica dati di test nel database
     */
    public void loadContent() {
        application.getAppExecutors().diskIO().execute(() -> {
            // TODO:
        });
    }

    private final FarmacoVigilanzaApp application;
}

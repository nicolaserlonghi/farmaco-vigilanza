package us.rst.farmacovigilanza.database;

import android.app.Application;
import android.support.annotation.NonNull;
import us.rst.farmacovigilanza.FarmacoVigilanzaApp;
import us.rst.farmacovigilanza.Logger;
import us.rst.farmacovigilanza.database.entity.CredentialsEntity;
import us.rst.farmacovigilanza.database.entity.DoctorEntity;
import us.rst.farmacovigilanza.models.Credentials.UserType;

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
            try {
                CredentialsEntity credentialsEntity = new CredentialsEntity();
                credentialsEntity.setId("mario.rossi");
                credentialsEntity.setPassword("1234");
                credentialsEntity.setUserType(UserType.DOCTOR);

                application.getDataRepository().getCredentialsRepository().getDatabase().credentialsDao().insert(credentialsEntity);
            }
            catch (Exception ex) {
                Logger.w(DummyContentLoader.class.getSimpleName(), ex.getMessage());
            }
        });
    }

    private final FarmacoVigilanzaApp application;
}

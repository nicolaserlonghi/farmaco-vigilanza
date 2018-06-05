package us.rst.farmacovigilanza.database;

import android.app.Application;
import android.support.annotation.NonNull;
import us.rst.farmacovigilanza.FarmacoVigilanzaApp;
import us.rst.farmacovigilanza.Logger;
import us.rst.farmacovigilanza.database.entity.AvverseReactionEntity;
import us.rst.farmacovigilanza.database.entity.CredentialsEntity;
import us.rst.farmacovigilanza.database.entity.DoctorEntity;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.models.Credentials.UserType;
import us.rst.farmacovigilanza.models.Medication;

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
                // Credentials
                // mario.rossi --> doctor
                CredentialsEntity credentialsEntity = new CredentialsEntity();
                credentialsEntity.setId("mario.rossi");
                credentialsEntity.setPassword("1234");
                credentialsEntity.setUserType(UserType.DOCTOR);
                application.getDataRepository().getCredentialsRepository().getDatabase().credentialsDao().insert(credentialsEntity);

                // bianchi.luca --> pharmacology
                credentialsEntity = new CredentialsEntity();
                credentialsEntity.setId("bianchi.luca");
                credentialsEntity.setPassword("1234");
                credentialsEntity.setUserType(UserType.PHARMACOLOGIST);
                application.getDataRepository().getCredentialsRepository().getDatabase().credentialsDao().insert(credentialsEntity);

                // Factors
                FactorEntity factor = new FactorEntity();
                factor.setName("Ipertensione");
                factor.setDescription("Pressione arteriosa a risposta più alta rispetto agli standard");
                // TODO: add factor

                factor = new FactorEntity();
                factor.setName("Sovrappeso");
                factor.setDescription("Peso superiore allo standard");
                // TODO: add factor

                factor = new FactorEntity();
                factor.setName("Fumatore");
                factor.setDescription("Paziente fumatore");
                // TODO: add factor

                AvverseReactionEntity avverseReactionEntity = new AvverseReactionEntity();
                avverseReactionEntity.setName("Asma");
                avverseReactionEntity.setDescription("Difficoltà respiratorie");
                // TODO: add avverse reaction
                // TODO: modify database

                avverseReactionEntity = new AvverseReactionEntity();
                avverseReactionEntity.setName("Dermatite");
                avverseReactionEntity.setDescription("Infiammazione della cute");
                // TODO: add avverse reaction

                avverseReactionEntity = new AvverseReactionEntity();
                avverseReactionEntity.setName("Insufficienza renale");
                avverseReactionEntity.setDescription("Incapacità dei reni di adempiere alle proprie funzioni");
                // TODO: add avverse reaction

                
            }
            catch (Exception ex) {
                Logger.w(DummyContentLoader.class.getSimpleName(), ex.getMessage());
            }
        } );
    }

    private final FarmacoVigilanzaApp application;
}

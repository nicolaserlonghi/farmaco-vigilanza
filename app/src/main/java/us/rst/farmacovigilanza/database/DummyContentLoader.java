package us.rst.farmacovigilanza.database;

import android.app.Application;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import us.rst.farmacovigilanza.FarmacoVigilanzaApp;
import us.rst.farmacovigilanza.Logger;
import us.rst.farmacovigilanza.database.entity.AdverseReactionEntity;
import us.rst.farmacovigilanza.database.entity.CredentialsEntity;
import us.rst.farmacovigilanza.database.entity.DoctorEntity;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.database.entity.PatientFactorEntity;
import us.rst.farmacovigilanza.database.entity.PharmacologistEntity;
import us.rst.farmacovigilanza.database.entity.TherapyEntity;
import us.rst.farmacovigilanza.models.Credentials.UserType;
import us.rst.farmacovigilanza.models.FiscalCode;

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

                DoctorEntity doctor = new DoctorEntity();
                doctor.setId("mario.rossi");
                application.getDataRepository().getDoctorsRepository().getDatabase().doctorsDao().insert(doctor);

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
                application.getDataRepository().getPatientRepository().getDatabase().factorsDao().insert(factor);

                factor = new FactorEntity();
                factor.setName("Sovrappeso");
                factor.setDescription("Peso superiore allo standard");
                application.getDataRepository().getPatientRepository().getDatabase().factorsDao().insert(factor);

                factor = new FactorEntity();
                factor.setName("Fumatore");
                factor.setDescription("Paziente fumatore");
                application.getDataRepository().getPatientRepository().getDatabase().factorsDao().insert(factor);

                AdverseReactionEntity adverseReactionEntity = new AdverseReactionEntity();
                adverseReactionEntity.setName("Asma");
                adverseReactionEntity.setDescription("Difficoltà respiratorie");
                application.getDataRepository().getAdverseReactionRepository().add(adverseReactionEntity);

                adverseReactionEntity = new AdverseReactionEntity();
                adverseReactionEntity.setName("Dermatite");
                adverseReactionEntity.setDescription("Infiammazione della cute");
                application.getDataRepository().getAdverseReactionRepository().add(adverseReactionEntity);

                adverseReactionEntity = new AdverseReactionEntity();
                adverseReactionEntity.setName("Insufficienza renale");
                adverseReactionEntity.setDescription("Incapacità dei reni di adempiere alle proprie funzioni");
                application.getDataRepository().getAdverseReactionRepository().add(adverseReactionEntity);

                PatientEntity patient = new PatientEntity();
                patient.setDoctor("mario.rossi");
                patient.setBirthDate(1968);
                patient.setFiscalCode(FiscalCode.parse("aaabbb11c22d333e"));
                patient.setJob("Operaio");
                patient.setProvince("Verona");

                SimpleDateFormat date = new SimpleDateFormat("dd/MM/YYYY");

                List<TherapyEntity> therapies = new ArrayList<>();
                TherapyEntity therapy = new TherapyEntity();
                therapy.setPatient(FiscalCode.parse("aaabbb11c22d333e"));
                therapy.setFrequency(2);
                therapy.setMedicine("Biopasan");
                therapy.setUnit(2);
                therapy.setStartDate(date.parse("10/07/2014"));
                therapy.setEndDate(date.parse("10/07/2018"));
                therapies.add(therapy);

                therapy = new TherapyEntity();
                therapy.setPatient(FiscalCode.parse("aaabbb11c22d333e"));
                therapy.setFrequency(1);
                therapy.setMedicine("Gilacal");
                therapy.setUnit(3);
                therapy.setStartDate(date.parse("10/02/2017"));
                therapy.setEndDate(date.parse("31/12/2018"));
                therapies.add(therapy);

                List<PatientFactorEntity> patientFactorEntities = new ArrayList<>();
                PatientFactorEntity patientFactorEntity = new PatientFactorEntity();
                patientFactorEntity.setPatientCf(FiscalCode.parse("aaabbb11c22d333e"));
                patientFactorEntity.setFactorName("Fumatore");
                patientFactorEntity.setLevelOfRisk(4);
                patientFactorEntities.add(patientFactorEntity);

                application.getDataRepository().getPatientRepository().add(patient, patientFactorEntities, therapies);
            }
            catch (Exception ex) {
                Logger.w(DummyContentLoader.class.getSimpleName(), ex.getMessage());
            }
        } );
    }

    private final FarmacoVigilanzaApp application;
}

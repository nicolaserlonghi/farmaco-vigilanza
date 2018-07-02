package us.rst.farmacovigilanza;

import android.arch.persistence.room.Room;
import android.content.Context;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.models.Patient;
import us.rst.farmacovigilanza.repositories.AdverseReactionRepository;
import us.rst.farmacovigilanza.repositories.CredentialsRepository;
import us.rst.farmacovigilanza.repositories.DoctorsRepository;
import us.rst.farmacovigilanza.repositories.DrugsRepository;
import us.rst.farmacovigilanza.repositories.PatientRepository;
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
        doctorsRepository = new DoctorsRepository(database, appExecutors);
        reportsRepository = new ReportsRepository(database, appExecutors);
        credentialsRepository = new CredentialsRepository(database, appExecutors);
        adverseReactionRepository = new AdverseReactionRepository(database, appExecutors);
        drugsRepository = new DrugsRepository(database, appExecutors);
        patientRepository = new PatientRepository(database, appExecutors);

    }
    final AdverseReactionRepository adverseReactionRepository;

    public DoctorsRepository getDoctorsRepository() {
        return doctorsRepository;
    }

    public ReportsRepository getReportsRepository() {
        return reportsRepository;
    }

    public CredentialsRepository getCredentialsRepository() {
        return credentialsRepository;
    }

    public AdverseReactionRepository getAdverseReactionRepository(){
        return adverseReactionRepository;
    }

    public PatientRepository getPatientRepository(){
        return patientRepository;
    }

    public DrugsRepository getDrugsRepository() {
        return drugsRepository;
    }

    private final AppDatabase database;
    private final DoctorsRepository doctorsRepository;
    private final ReportsRepository reportsRepository;
    private final CredentialsRepository credentialsRepository;
    private final DrugsRepository drugsRepository;
    private final PatientRepository patientRepository;
    private static DataRepository instance;
}

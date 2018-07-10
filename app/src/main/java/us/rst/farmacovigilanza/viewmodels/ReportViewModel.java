package us.rst.farmacovigilanza.viewmodels;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import java.util.Date;
import java.util.List;
import us.rst.farmacovigilanza.database.entity.AdverseReactionEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.database.entity.PatientFactorEntity;
import us.rst.farmacovigilanza.database.entity.ReportEntity;
import us.rst.farmacovigilanza.database.entity.ReportTherapyEntity;
import us.rst.farmacovigilanza.database.entity.TherapyEntity;
import us.rst.farmacovigilanza.models.FiscalCode;
import us.rst.farmacovigilanza.repositories.ReportsRepository;

/**
 * Classe di collegamento tra interfaccia e dati della segnalazione
 */
public class ReportViewModel extends BaseViewModel {
    private final ReportsRepository reportsRepository;
    private final MutableLiveData<PatientEntity> patient;
    private final MutableLiveData<List<PatientFactorEntity>> factors;
    private final MutableLiveData<List<TherapyEntity>> therapies;
    private AppCompatActivity owner;

    /**
     * Inizializza una nuova istanza di questa classe
     * @param application istanza corrente dell'applicazione
     * @param reportsRepository gestione dati della segnalazione
     */
    public ReportViewModel(@NonNull Application application, ReportsRepository reportsRepository) {
        super(application);

        this.reportsRepository = reportsRepository;
        this.patient = new MutableLiveData<>();
        this.factors = new MutableLiveData<>();
        this.therapies = new MutableLiveData<>();
    }

    /**
     * Restituisce un oggetto osservabile di {@link PatientEntity}
     * @return un oggetto osservabile di {@link PatientEntity}
     */
    public LiveData<PatientEntity> getPatient(AppCompatActivity activity) {
        owner = activity;
        return patient;
    }

    /**
     * Avvia la ricerca di un paziente
     * @param cf codice fiscale
     */
    public void findPatient(String cf) {
        FiscalCode fiscalCode = FiscalCode.parse(cf);
        reportsRepository.getPatient(fiscalCode).observe(owner, patientEntity -> patient.setValue(patientEntity));
    }

    /**
     * Restituisce una lista osservabile di {@link PatientFactorEntity}
     * @return una lista osservabile di {@link PatientFactorEntity}
     */
    public LiveData<List<PatientFactorEntity>> getFactors(AppCompatActivity activity) {
        owner = activity;
        return factors;
    }

    /**
     * Avvia la ricerca dei fattori di rischio legati al paziente
     * @param cf codice fiscale
     */
    public void findFactors(String cf) {
        FiscalCode fiscalCode = FiscalCode.parse(cf);
        reportsRepository.getFactors(fiscalCode).observe(owner, factorEntities -> factors.setValue(factorEntities));
    }

    /**
     * Restituisce una lista osservabile di {@link TherapyEntity}
     * @return una lista osservabile di {@link TherapyEntity}
     */
    public MutableLiveData<List<TherapyEntity>> getTherapies(AppCompatActivity activity) {
        owner = activity;
        return therapies;
    }

    /**
     * Avvia la ricerca delle terapie al paziente
     * @param cf codice fiscale
     */
    public void findTherapies(String cf) {
        FiscalCode fiscalCode = FiscalCode.parse(cf);
        reportsRepository.getTherapies(fiscalCode).observe(owner, therapyEntities -> therapies.setValue(therapyEntities));
    }

    /**
     * Restituisce una lista osservabile di {@link AdverseReactionEntity}
     * @return una lista osservabile di {@link AdverseReactionEntity}
     */
    public LiveData<List<AdverseReactionEntity>> getAdversReactions(AppCompatActivity activity) {
        owner = activity;
        return reportsRepository.getAdverseReactions();
    }

    /**
     * Salva la segnalazione
     * @param patient paziente
     * @param adverseReactionName nome reazione avversa
     * @param levelOfGravity livello di gravità
     * @param reactionDate data di reazione
     * @param therapyId id della terapia
     */
    public void saveReport(PatientEntity patient, String adverseReactionName, int levelOfGravity, Date reactionDate, int therapyId) {
        reportsRepository
            .saveReport(patient.getFiscalCode(), adverseReactionName, levelOfGravity, reactionDate, therapyId);
    }

    /**
     * Restituisce una lista osservabile di {@link ReportTherapyEntity}
     * @return una lista osservabile di {@link ReportTherapyEntity}
     */
    public LiveData<List<ReportTherapyEntity>> getReports() {
        return reportsRepository.getReports();
    }

    /**
     * Restituisce un oggetto che osserva una lista di {@link ReportTherapyEntity}
     * @param doctorId id del dottore che ha "firmato" le segnalazioni
     * @return un oggetto che osserva una lista di {@link ReportTherapyEntity}
     */
    public LiveData<List<ReportTherapyEntity>> getReportsByDoctor(String doctorId) {
        return reportsRepository.getReportsByDoctor(doctorId);
    }

    /**
     * Factory per questo ViewModel
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        /**
         * Inizializza una nuova istanza di questa classe
         * @param application istanza di questa applicazione
         * @param reportsRepository istanza di {@link ReportsRepository}
         */
        public Factory(@NonNull Application application, ReportsRepository reportsRepository) {
            this.application = application;
            this.reportsRepository = reportsRepository;
        }

        /**
         * Restituisce il ViewModel
         * @param modelClass classe del ViewModel
         * @param <T> tipo del ViewModel
         * @return un'istanza del ViewModel
         */
        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new ReportViewModel(application, reportsRepository);
        }

        @NonNull
        private final Application application;
        private final ReportsRepository reportsRepository;
    }
}

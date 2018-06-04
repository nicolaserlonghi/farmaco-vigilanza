package us.rst.farmacovigilanza.viewmodels;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import java.util.Date;
import java.util.List;
import us.rst.farmacovigilanza.database.entity.AvverseReactionEntity;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.models.AvverseReaction;
import us.rst.farmacovigilanza.models.FiscalCode;
import us.rst.farmacovigilanza.repositories.ReportsRepository;

/**
 * Classe di collegamento tra interfaccia e dati della segnalazione
 */
public class ReportViewModel extends BaseViewModel {
    /**
     * Inizializza una nuova istanza di questa classe
     * @param application istanza corrente dell'applicazione
     * @param reportsRepository gestione dati della segnalazione
     */
    public ReportViewModel(@NonNull Application application, ReportsRepository reportsRepository) {
        super(application);

        this.reportsRepository = reportsRepository;
    }

    /**
     * Restituisce un oggetto osservabile di {@link PatientEntity}
     * @param cf codice fiscale
     * @return un oggetto osservabile di {@link PatientEntity}
     */
    public LiveData<PatientEntity> getPatient(String cf) {
        FiscalCode fiscalCode = FiscalCode.parse(cf);
        return reportsRepository.getOne(fiscalCode);
    }

    /**
     * Restituisce una lista osservabile di {@link FactorEntity}
     * @param cf codice fiscale
     * @return una lista osservabile di {@link FactorEntity}
     */
    public MutableLiveData<List<FactorEntity>> getFactors(String cf) {
        FiscalCode fiscalCode = FiscalCode.parse(cf);
        return reportsRepository.getFactors(fiscalCode);
    }

    /**
     * Restituisce una lista osservabile di {@link AvverseReactionEntity}
     * @return una lista osservabile di {@link AvverseReactionEntity}
     */
    public MutableLiveData<List<AvverseReactionEntity>> getAvverseReactions() {
        return reportsRepository.getAvverseReactions();
    }

    /**
     * Salva la segnalazione
     * @param fiscalCode codice fiscale
     * @param description descrizione segnalazione
     * @param reactionDate data di reazione
     * @param reportDate data di segnalazione
     * @param avverseReaction tipologia reazione avversa
     * @param levelOfGravity livello di gravità della reazione avversa
     */
    public void saveReport(FiscalCode fiscalCode, String description, Date reactionDate, Date reportDate, AvverseReaction avverseReaction, int levelOfGravity) {
        reportsRepository
            .saveReport(fiscalCode, description, reactionDate, reactionDate, avverseReaction, levelOfGravity);
    }

    /**
     * This class Factory
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        /**
         * Initializes a Factory for this viewmodel
         * @param application
         */
        public Factory(@NonNull Application application, ReportsRepository reportsRepository) {
            this.application = application;
            this.reportsRepository = reportsRepository;
        }

        /**
         * Gets the actual viewmodel
         * @param modelClass model of the... Viewmodel
         * @param <T> type of the viewmodel
         * @return the viewmodel
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

    private final ReportsRepository reportsRepository;
}

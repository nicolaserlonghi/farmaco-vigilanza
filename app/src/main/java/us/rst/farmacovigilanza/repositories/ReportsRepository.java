package us.rst.farmacovigilanza.repositories;

import android.arch.lifecycle.LiveData;
import java.util.Date;
import java.util.List;
import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.AdverseReactionEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.database.entity.PatientFactorEntity;
import us.rst.farmacovigilanza.database.entity.ReportEntity;
import us.rst.farmacovigilanza.database.entity.TherapyEntity;
import us.rst.farmacovigilanza.models.FiscalCode;

/**
 * Gestisce le interrogazioni al database per il dominio dei pazienti
 */
public class ReportsRepository extends BaseRepository {
    /**
     * Inizializza una nuova istanza di questa classe
     *
     * @param database database
     * @param appExecutors pool thread per esecuzione operazioni I/O
     */
    public ReportsRepository(AppDatabase database, AppExecutors appExecutors) {
        super(database, appExecutors);
    }

    /**
     * Restituisce un oggetto osservabile di {@link PatientEntity}
     * @param fiscalCode un'istanza di {@link FiscalCode} che rappresenta il codice fiscale del paziente
     * @return un oggetto osservabile di {@link PatientEntity}
     */
    public LiveData<PatientEntity> getPatient(FiscalCode fiscalCode) {
        return getDatabase().patientsDao().getOne(fiscalCode);
    }

    /**
     * Restituisce una lista osservabile di {@link PatientFactorEntity}
     * @param fiscalCode un'istanza di {@link FiscalCode} che rappresenta il codice fiscale del paziente
     * @return una lista osservabile di {@link PatientFactorEntity}
     */
    public LiveData<List<PatientFactorEntity>> getFactors(FiscalCode fiscalCode) {
        return getDatabase().factorsDao().getFactorsLinkedToPatient(fiscalCode);
    }

    /**
     * Restituisce una lista osservabile di {@link AdverseReactionEntity}
     * @return una lista osservabile di {@link AdverseReactionEntity}
     */
    public LiveData<List<AdverseReactionEntity>> getAdverseReactions() {
        return getDatabase().avverseReactionsDao().getAll();
    }

    /**
     * Restituisce una lista osservabile di {@link TherapyEntity}
     * @param fiscalCode un'istanza di {@link FiscalCode} che rappresenta il codice fiscale del paziente
     * @return una lista osservabile di {@link TherapyEntity}
     */
    public LiveData<List<TherapyEntity>> getTherapies(FiscalCode fiscalCode) {
        return getDatabase().therapyDao().getTherapiesLinkedToPatient(fiscalCode);
    }

    /**
     * Salva la segnalazione
     * @param fiscalCode codice fiscale
     * @param adverseReactionName nome reazione avversa
     * @param adverseReactionDate data di reazione
     * @param therapyId identificativo terapia
     */
    public void saveReport(FiscalCode fiscalCode, String adverseReactionName, Date adverseReactionDate, int therapyId) {
        getAppExecutors().diskIO().execute(() -> {
            ReportEntity report = new ReportEntity();
            report.setReactionDate(adverseReactionDate);
            report.setAdverseReactionName(adverseReactionName);
            report.setPatientFiscalCode(fiscalCode);
            report.setTherapyId(therapyId);
        });
    }

    /**
     * Restituisce un oggetto che osserva una lista di {@link ReportEntity}
     * @return un oggetto che osserva una lista di {@link ReportEntity}
     */
    public LiveData<List<ReportEntity>> getReports() {
        return getDatabase().reportsDao().getAll();
    }
}

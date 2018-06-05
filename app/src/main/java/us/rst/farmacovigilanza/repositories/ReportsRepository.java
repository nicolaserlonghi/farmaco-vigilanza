package us.rst.farmacovigilanza.repositories;

import android.arch.lifecycle.LiveData;
import java.util.Date;
import java.util.List;
import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.AvverseReactionEntity;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.database.entity.ReportEntity;
import us.rst.farmacovigilanza.models.AvverseReaction;
import us.rst.farmacovigilanza.models.FiscalCode;
import us.rst.farmacovigilanza.models.Report;

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
    public LiveData<PatientEntity> getOne(FiscalCode fiscalCode) {
        return getDatabase().patientsDao().getOne(fiscalCode);
    }

    /**
     * Restituisce una lista osservabile di {@link FactorEntity}
     * @param fiscalCode un'istanza di {@link FiscalCode} che rappresenta il codice fiscale del paziente
     * @return una lista osservabile di {@link FactorEntity}
     */
    public LiveData<List<FactorEntity>> getFactors(FiscalCode fiscalCode) {
        return getDatabase().factorsDao().getByFiscalCode(fiscalCode);
    }

    /**
     * Restituisce una lista osservabile di {@link AvverseReactionEntity}
     * @return una lista osservabile di {@link AvverseReactionEntity}
     */
    public LiveData<List<AvverseReactionEntity>> getAvverseReactions() {
        return getDatabase().avverseReactionsDao().getAll();
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
        // TODO
    }

    public LiveData<List<ReportEntity>> getReports() {
        return getDatabase().reportsDao().getAll();
    }
}

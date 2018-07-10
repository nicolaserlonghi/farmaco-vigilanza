package us.rst.farmacovigilanza.repositories;


import android.arch.lifecycle.LiveData;

import java.util.List;

import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.ProposalEntity;

/**
 * Gestisce le interrogazioni al database per il dominio dei pazienti
 */
public class DrugsRepository extends BaseRepository {
    /**
     * Inizializza una nuova istanza di questa classe
     *
     * @param database database
     * @param appExecutors pool thread per esecuzione operazioni I/O
     */
    public DrugsRepository(AppDatabase database, AppExecutors appExecutors) {
        super(database, appExecutors);
    }

    /**
     * Restituisce una lista osservabile di farmaci
     * @return lista osservabile di farmaci
     */
    public LiveData<List<String>> getDrugs() {
        return getDatabase().drugsDao().getNames();
    }

    /**
     * Aggiunge un'instanza di {@link ProposalEntity} al database
     * @param proposalEntity proposta da aggiungere al database
     */
    public void addProposal(ProposalEntity proposalEntity) {
        getAppExecutors().diskIO().execute(() -> {
            getDatabase().proposalsDao().insert(proposalEntity);
        });
    }

    /**
     * Restituisce una lista osservabile di {@link ProposalEntity}
     * @return lista osservabile di {@link ProposalEntity}
     */
    public LiveData<List<ProposalEntity>> getProposals() {
        return getDatabase().proposalsDao().getAll();
    }
}
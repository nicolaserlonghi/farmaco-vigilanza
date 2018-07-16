package us.rst.farmacovigilanza.repositories;

import java.util.concurrent.Executors;

import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.Logger;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.AdverseReactionEntity;

/**
 * Gestisce le interrogazioni al database per il dominio delle reazioni avverse
 */
public class AdverseReactionRepository extends BaseRepository {
    /**
     * Inizializza una nuova istanza di questa classe
     *
     * @param database database
     * @param appExecutors pool thread per esecuzione operazioni I/O
     */
    public AdverseReactionRepository(AppDatabase database, AppExecutors appExecutors) {
        super(database, appExecutors);
    }

    /**
     * Aggiunge una {@link AdverseReactionEntity} in memoria
     * ATTENZIONE: se la reazione avversa è già presente in memoria, il sistema crasha
     * @param adverseReactionEntity reazione avversa da salvare
     */
    public void add(AdverseReactionEntity adverseReactionEntity){
        getAppExecutors().diskIO().execute(() -> {
            try {
                getDatabase().avverseReactionsDao().insert(adverseReactionEntity);
            }
            catch (Exception ex) {
                Logger.e(AdverseReactionRepository.class.getSimpleName(), ex.getMessage());
            }
        });
    }
}

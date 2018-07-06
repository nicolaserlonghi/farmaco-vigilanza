package us.rst.farmacovigilanza.repositories;

import android.arch.lifecycle.MutableLiveData;
import us.rst.farmacovigilanza.AppExecutors;
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
        this.avverseReactionEntityLiveData = new MutableLiveData<>();
    }

    /**
     * Aggiunge una {@link AdverseReactionEntity} in memoria
     * ATTENZIONE: se la reazione avversa è già presente in memoria, il sistema crasha
     * @param adverseReactionEntity reazione avversa da salvare
     */
    public void add(AdverseReactionEntity adverseReactionEntity){
        getAppExecutors().diskIO().execute(() -> {
            getDatabase().avverseReactionsDao().insert(adverseReactionEntity);
        });
    }

    private final MutableLiveData<AdverseReactionEntity> avverseReactionEntityLiveData;
}

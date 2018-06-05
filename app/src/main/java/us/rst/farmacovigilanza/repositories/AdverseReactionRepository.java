package us.rst.farmacovigilanza.repositories;

import android.arch.lifecycle.MutableLiveData;
import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.AvverseReactionEntity;

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
     * Aggiunge una {@link AvverseReactionEntity} in memoria
     * ATTENZIONE: se la reazione avversa è già presente in memoria, il sistema crasha
     * @param avverseReactionEntity reazione avversa da salvare
     */
    public void add(AvverseReactionEntity avverseReactionEntity){
        getAppExecutors().diskIO().execute(() -> {
            getDatabase().avverseReactionsDao().insert(avverseReactionEntity);
        });
    }

    private final MutableLiveData<AvverseReactionEntity> avverseReactionEntityLiveData;
}

package us.rst.farmacovigilanza.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Database;

import us.rst.farmacovigilanza.AppExecutors;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.AvverseReactionEntity;
import us.rst.farmacovigilanza.models.AvverseReaction;

public class AdverseReactionRepository extends BaseRepository {

    final AppExecutors appExecutors;
    final MutableLiveData<AvverseReactionEntity> avverseReactionEntityLiveData;


    /**
     * Initializes a new instance of this class
     *
     * @param database database
     */
    public AdverseReactionRepository(AppDatabase database, AppExecutors appExecutors) {
        super(database);
        this.appExecutors = appExecutors;
        this.avverseReactionEntityLiveData = new MutableLiveData<>();
    }

    public LiveData<AvverseReactionEntity> getAdverseReaction(String name){
        appExecutors.diskIO().execute(() ->{
            avverseReactionEntityLiveData.setValue(getDatabase().avverseReactionsDao().getOne(name).getValue());
        });

        return avverseReactionEntityLiveData;
    }

    public void add(AvverseReactionEntity avverseReactionEntity){

        appExecutors.diskIO().execute(() -> {
            getDatabase().avverseReactionsDao().insert(avverseReactionEntity);
        });

    }

}

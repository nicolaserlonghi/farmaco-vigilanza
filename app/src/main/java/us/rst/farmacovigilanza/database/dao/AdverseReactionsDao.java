package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
import us.rst.farmacovigilanza.database.entity.AdverseReactionEntity;

@Dao
public interface AdverseReactionsDao {
    @Query("SELECT * FROM avverseReactions")
    LiveData<List<AdverseReactionEntity>> getAll();

    @Insert
    void insert(AdverseReactionEntity adverseReactionEntity);
}

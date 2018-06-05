package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
import us.rst.farmacovigilanza.database.entity.AvverseReactionEntity;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.models.FiscalCode;

@Dao
public interface AvverseReactionsDao {
    @Query("SELECT * FROM avverseReactions")
    LiveData<List<AvverseReactionEntity>> getAll();

    @Insert
    void insert(AvverseReactionEntity avverseReactionEntity);

    @Query("SELECT * FROM avverseReactions WHERE name=:name")
    LiveData<AvverseReactionEntity> getOne(String name);
}

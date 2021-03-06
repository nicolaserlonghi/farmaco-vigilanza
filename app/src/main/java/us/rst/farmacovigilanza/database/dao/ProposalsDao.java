package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import us.rst.farmacovigilanza.database.entity.ProposalEntity;

@Dao
public interface ProposalsDao {
    @Query("SELECT * FROM proposals")
    LiveData<List<ProposalEntity>> getAll();

    @Insert
    void insert(ProposalEntity proposal);
}

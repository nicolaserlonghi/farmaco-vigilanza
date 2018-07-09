package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface DrugsDao {
    @Query("SELECT DISTINCT therapies.medicine FROM therapies")
    LiveData<List<String>> getNames();
}

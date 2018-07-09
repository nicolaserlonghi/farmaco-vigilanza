package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import us.rst.farmacovigilanza.database.entity.ReportEntity;
import us.rst.farmacovigilanza.database.entity.ReportTherapyEntity;

@Dao
public interface ReportsDao {
    @Query("SELECT reports.*, therapies.* FROM reports JOIN therapies ON reports.therapyId = therapies.id")
    LiveData<List<ReportTherapyEntity>> getAll();

    @Insert
    void add(ReportEntity report);
}

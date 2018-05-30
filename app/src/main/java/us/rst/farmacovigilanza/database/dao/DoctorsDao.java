package us.rst.farmacovigilanza.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import us.rst.farmacovigilanza.models.Doctor;

@Dao
public interface DoctorsDao {
    @Query("SELECT * FROM doctors WHERE id=:id AND password=:password")
    List<Doctor> getDoctor(String id, String password);
}

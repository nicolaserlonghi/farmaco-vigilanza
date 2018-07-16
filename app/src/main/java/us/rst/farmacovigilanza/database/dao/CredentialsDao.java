package us.rst.farmacovigilanza.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import us.rst.farmacovigilanza.database.entity.CredentialsEntity;
import us.rst.farmacovigilanza.database.entity.DoctorEntity;

@Dao
public interface CredentialsDao {
    @Query("SELECT * FROM credentials WHERE id=:id AND password=:password")
    LiveData<CredentialsEntity> getUser(String id, String password);

    @Insert
    void insert(CredentialsEntity credentialsEntity);
}

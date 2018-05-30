package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import us.rst.farmacovigilanza.models.Doctor;

/**
 * Represents the entity of {@link Doctor}
 */
@Entity(tableName = "doctors")
public class DoctorEntity implements Doctor {
    /**
     * Gets the id of the doctor
     * @return doctor id
     */
    @Override public String getId() {
        return id;
    }

    /**
     * Sets the id of the doctor
     * @param id doctor id
     */
    @Override public void setId(String id) {
        this.id = id;
    }

    /**
     * Restituisce la password del dottore
     * @return password del dottore
     */
    @Override public String getPassword() {
        return password;
    }

    /**
     * Imposta la password del dottore
     * @param password password del dottore
     */
    @Override public void setPassword(String password) {
        this.password = password;
    }

    @PrimaryKey @NonNull
    private String id;
    private String password;
}

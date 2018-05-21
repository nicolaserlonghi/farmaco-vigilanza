package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
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
    @Override public int getId() {
        return id;
    }

    /**
     * Sets the id of the doctor
     * @param id doctor id
     */
    @Override public void setId(int id) {
        this.id = id;
    }

    private int id;
}

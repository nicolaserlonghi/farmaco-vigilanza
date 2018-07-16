package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import us.rst.farmacovigilanza.models.Pharmacologist;

/**
 * Rappresenta l'entità del farmacologo nel database
 */
@Entity(tableName = "pharamacologist")
public class PharmacologistEntity implements Pharmacologist {
    /**
     * Restituisce l'id del farmacologo
     * @return id farmacologo
     */
    @Override public String getId() {
        return id;
    }

    /**
     * Imposta l'id del farmacologo
     * @param id id farmacologo
     */
    @Override public void setId(String id) {
        this.id = id;
    }

    @PrimaryKey @NonNull
    private String id;
}

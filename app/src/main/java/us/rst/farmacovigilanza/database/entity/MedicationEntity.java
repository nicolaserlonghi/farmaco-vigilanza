package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import us.rst.farmacovigilanza.models.Medication;

/**
 * Rappresenta il modello {@link Medication} nel database
 */
@Entity(tableName = "medications")
public class MedicationEntity implements Medication {

    /**
     * Restituisce l'id univoco del farmaco
     * @return id univoco del farmaco
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Imposta l'id univoco del farmaco
     * @param id id univoco del farmaco
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Restituisce il nome del farmaco
     * @return nome del farmaco
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Imposta il nome del farmaco
     * @param name nome del farmaco
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @PrimaryKey
    private int id;
    private String name;
}

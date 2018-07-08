package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import us.rst.farmacovigilanza.models.FiscalCode;

/**
 * Represents the many to many relationship between patients and factors
 */
@Entity(tableName = "patientFactor",
        foreignKeys = {
                @ForeignKey(entity = PatientEntity.class,
                        parentColumns = "fiscalCode",
                        childColumns = "patientCf"),
                @ForeignKey(entity = FactorEntity.class,
                        parentColumns = "name",
                        childColumns = "factorName")
        })
public class PatientFactorEntity {
    /**
     * Gets the CF of the patient
     * @return patient CF
     */
    public FiscalCode getPatientCf() {
        return patientCf;
    }

    /**
     * Sets the CF of the patient
     * @param patientCf patient cf
     */
    public void setPatientCf(FiscalCode patientCf) {
        this.patientCf = patientCf;
    }

    /**
     * Gets the name of the factor
     * @return factor name
     */
    public String getFactorName() {
        return factorName;
    }

    /**
     * Sets the name of the factor
     * @param factorName factor name
     */
    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }

    /**
     * Gets the level of risk of this factor
     * @return level of risk
     */
    public int getLevelOfRisk() {
        return levelOfRisk;
    }

    /**
     * Sets the level of risk of this factor
     * @param levelOfRisk
     */
    public void setLevelOfRisk(int levelOfRisk) {
        this.levelOfRisk = levelOfRisk;
    }

    /**
     * Imposta l'id unico dell'entità
     * @return id entità
     */
    public int getId() {
        return id;
    }


    /**
     * Imposta l'id unico dell'entità
     * @param id id entità
     */
    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    private FiscalCode patientCf;
    private String factorName;
    private int levelOfRisk;
}

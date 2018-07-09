package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import us.rst.farmacovigilanza.models.FiscalCode;
import us.rst.farmacovigilanza.models.Patient;

/**
 * Rappresenta l'entità di {@link Patient}
 */
@Entity(tableName = "patients",
        foreignKeys = {
                @ForeignKey(entity = DoctorEntity.class,
                        parentColumns = "id",
                        childColumns = "doctor")
        })
public class PatientEntity implements Patient {
    /**
     * Restituisce il codice fiscale del paziente
     * @return codice fiscale del paziente
     */
    @Override public FiscalCode getFiscalCode() {
        return fiscalCode;
    }

    /**
     * Imposta il codice fiscale del paziente
     * @param fiscalCode codice fiscale del paziente
     */
    @Override public void setFiscalCode(FiscalCode fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    /**
     * Restituisce l'anno di nascita del paziente
     * @return anno di nascita del paziente
     */
    @Override public int getBirthDate() {
        return this.birthDate;
    }

    /**
     * Imposta l'anno di nascita del paziente
     * @param birthDate anno di nascita del paziente
     */
    @Override public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Restituisce la provincia di residenza del paziente
     * @return provincia di residenza del paziente
     */
    @Override public String getProvince() {
        return province;
    }

    /**
     * Imposta la provincia di residenza del paziente
     * @param province provincia di residenza del paziente
     */
    @Override public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Restituisce il lavoro corrente del paziente
     * @return lavoro corrente del paziente
     */
    @Override public String getJob() {
        return job;
    }

    /**
     * Imposta il lavoro corrente del paziente
     * @param job lavoro corrente del paziente
     */
    @Override public void setJob(String job) {
        this.job = job;
    }

    /**
     * Restituisce l'id del dottore che ha in cura questo paziente
     * @return id del dottore che ha in cura questo paziente
     */
    @Override public String getDoctor() {
        return doctor;
    }

    /**
     * Imposta l'id del dottore che ha in cura questo paziente
     * @param doctorId id del dottore che ha in cura questo paziente
     */
    @Override public void setDoctor(String doctorId) {
        this.doctor = doctorId;
    }

    @PrimaryKey @NonNull
    private FiscalCode fiscalCode;
    private int birthDate;
    private String province;
    private String job;
    private String doctor;
}

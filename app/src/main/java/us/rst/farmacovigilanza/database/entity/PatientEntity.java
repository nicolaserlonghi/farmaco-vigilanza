package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import us.rst.farmacovigilanza.models.FiscalCode;
import us.rst.farmacovigilanza.models.Patient;

/**
 * Represents the entity of {@link Patient}
 */
@Entity(tableName = "patients")
public class PatientEntity implements Patient {
    /**
     * Gets the fiscal code of this patient
     * @return fiscal code of this patient
     */
    @Override public FiscalCode getFiscalCode() {
        return fiscalCode;
    }

    /**
     * Sets the fiscal code of this patient
     * @param fiscalCode fiscal code of this patient
     */
    @Override public void setFiscalCode(FiscalCode fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    /**
     * Gets the birth date of this patient
     * @return birth date of this patient
     */
    @Override public int getBirthDate() {
        return this.birthDate;
    }

    /**
     * Sets the birth date of this patient
     * @param birthDate birth date of this patient
     */
    @Override public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets the province where this patient lives
     * @return province where this patient lives
     */
    @Override public String getProvince() {
        return province;
    }

    /**
     * Sets the province where this patient lives
     * @param province province where this patient lives
     */
    @Override public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets the current job of this patient
     * @return current job of this patient
     */
    @Override public String getJob() {
        return job;
    }

    /**
     * Sets the current job of this patient
     * @param job current job of this patient
     */
    @Override public void setJob(String job) {
        this.job = job;
    }

    @PrimaryKey @NonNull
    private FiscalCode fiscalCode;
    private int birthDate;
    private String province;
    private String job;
}

package us.rst.farmacovigilanza.models;

/**
 * Represents a patient
 */
public interface Patient {
    /**
     * Gets the fiscal code of this patient
     * @return fiscal code of this patient
     */
    FiscalCode getFiscalCode();

    /**
     * Sets the fiscal code of this patient
     * @param fiscalCode fiscal code of this patient
     */
    void setFiscalCode(FiscalCode fiscalCode);

    /**
     * Gets the birth date of this patient
     * @return birth date of this patient
     */
    int getBirthDate();

    /**
     * Sets the birth date of this patient
     * @param birthDate birth date of this patient
     */
    void setBirthDate(int birthDate);

    /**
     * Gets the province where this patient lives
     * @return province where this patient lives
     */
    String getProvince();

    /**
     * Sets the province where this patient lives
     * @param province province where this patient lives
     */
    void setProvince(String province);

    /**
     * Gets the current job of this patient
     * @return current job of this patient
     */
    String getJob();

    /**
     * Sets the current job of this patient
     * @param job current job of this patient
     */
    void setJob(String job);

    /**
     * Gets the doctor id
     * @return doctor id
     */
    int getDoctorId();

    /**
     * Sets the doctor id
     * @param id doctor id
     */
    void setDoctorId(int id);
}

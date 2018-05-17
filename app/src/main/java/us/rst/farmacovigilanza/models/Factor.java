package us.rst.farmacovigilanza.models;

public interface Factor {
    /**
     * Gets the name of this patient
     * @return patient name
     */
    String getName();

    /**
     * Sets the name of this patient
     * @param name patient name
     */
    void setName(String name);

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
}

package us.rst.farmacovigilanza.models;

/**
 * Represents a doctor
 */
public interface Doctor {
    /**
     * Gets the id of the doctor
     * @return doctor id
     */
    String getId();

    /**
     * Sets the id of the doctor
     * @param id doctor id
     */
    void setId(String id);

    /**
     * Restituisce la password del dottore
     * @return password del dottore
     */
    String getPassword();

    /**
     * Imposta la password del dottore
     * @param password password del dottore
     */
    void setPassword(String password);
}

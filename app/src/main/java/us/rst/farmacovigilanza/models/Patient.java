package us.rst.farmacovigilanza.models;

/**
 * Rappresenta un paziente
 */
public interface Patient {
    /**
     * Restituisce il codice fiscale del paziente
     * @return codice fiscale del paziente
     */
    FiscalCode getFiscalCode();

    /**
     * Imposta il codice fiscale del paziente
     * @param fiscalCode codice fiscale del paziente
     */
    void setFiscalCode(FiscalCode fiscalCode);

    /**
     * Restituisce l'anno di nascita del paziente
     * @return anno di nascita del paziente
     */
    int getBirthDate();

    /**
     * Imposta l'anno di nascita del paziente
     * @param birthDate anno di nascita del paziente
     */
    void setBirthDate(int birthDate);

    /**
     * Restituisce la provincia di residenza del paziente
     * @return provincia di residenza del paziente
     */
    String getProvince();

    /**
     * Imposta la provincia di residenza del paziente
     * @param province provincia di residenza del paziente
     */
    void setProvince(String province);

    /**
     * Restituisce il lavoro corrente del paziente
     * @return lavoro corrente del paziente
     */
    String getJob();

    /**
     * Imposta il lavoro corrente del paziente
     * @param job lavoro corrente del paziente
     */
    void setJob(String job);

    /**
     * Restituisce l'id del dottore che ha in cura questo paziente
     * @return id del dottore che ha in cura questo paziente
     */
    String getDoctor();

    /**
     * Imposta l'id del dottore che ha in cura questo paziente
     * @param doctorId id del dottore che ha in cura questo paziente
     */
    void setDoctor(String doctorId);
}

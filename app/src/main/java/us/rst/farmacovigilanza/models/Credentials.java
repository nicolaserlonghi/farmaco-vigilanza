package us.rst.farmacovigilanza.models;

/**
 * Rappresenta le credenziali di accesso al sistema
 */
public interface Credentials {
    enum UserType {
        DOCTOR,
        PHARMACOLOGIST
    }

    /**
     * Restituisce l'identificativo dell'utente
     * @return identificativo utente
     */
    String getId();

    /**
     * Imposta l'identificativo dell'utente
     * @param id identificativo utente
     */
    void setId(String id);

    /**
     * Restituisce la password dell'utente
     * @return password dell'utente
     */
    String getPassword();

    /**
     * Imposta la password dell'utente
     * @param password password dell'utente
     */
    void setPassword(String password);

    /**
     * Restituisce il tipo di utente
     * @return il tipo di utente
     */
    UserType getUserType();

    /**
     * Imposta il tipo di utente
     * @param userType tipo di utente
     */
    void setUserType(UserType userType);
}

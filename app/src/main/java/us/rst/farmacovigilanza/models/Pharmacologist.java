package us.rst.farmacovigilanza.models;

/**
 * Rappresenta un farmacologo
 */
public interface Pharmacologist {
    /**
     * Restituisce l'id del farmacologo
     * @return id farmacologo
     */
    String getId();

    /**
     * Imposta l'id del farmacologo
     * @param id id farmacologo
     */
    void setId(String id);
}

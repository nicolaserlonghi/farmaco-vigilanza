package us.rst.farmacovigilanza.models;

/**
 * Represents a medication
 */
public interface Drug {
    /**
     * Gets the medication id
     * @return medication id
     */
    int getId();

    /**
     * Sets the id for this medication
     * @param id medication id
     */
    void setId(int id);

    /**
     * Gets the name of the medication
     * @return medication name
     */
    String getName();

    /**
     * Sets the name of the medication
     * @param name medication name
     */
    void setName(String name);
}

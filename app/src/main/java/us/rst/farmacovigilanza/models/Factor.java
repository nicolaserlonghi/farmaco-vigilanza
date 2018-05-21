package us.rst.farmacovigilanza.models;

public interface Factor {
    /**
     * Gets the name of this factor
     * @return factor
     */
    String getName();

    /**
     * Sets the name of this factor
     * @param name factor
     */
    void setName(String name);

    /**
     * Gets the description of this factor
     * @return description
     */
    String getDescription();

    /**
     * Sets the description of this factor
     * @param description description
     */
    void setDescription(String description);

}

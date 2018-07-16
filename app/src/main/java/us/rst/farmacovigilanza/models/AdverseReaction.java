package us.rst.farmacovigilanza.models;

/**
 * Represents a reaction to a medication
 */
public interface AdverseReaction {
    /**
     * Gets the name of the reaction
     * @return reaction name
     */
    String getName();

    /**
     * Sets the name of the reaction
     * @param name reaction name
     */
    void setName(String name);

    /**
     * Gets the description of this reaction
     * @return reaction description
     */
    String getDescription();

    /**
     * Sets the description of this reaction
     * @param description description reaction
     */
    void setDescription(String description);
}

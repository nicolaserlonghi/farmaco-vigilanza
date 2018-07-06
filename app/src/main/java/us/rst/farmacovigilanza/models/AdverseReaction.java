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
     * Get the level of gravity (1-5) of this reaction
     * @return level of gravity (1-5) of this reaction
     */
    int getLevelOfGravity();

    /**
     * Sets the level of gravity (1-5) of this reaction
     * @param levelOfGravity level of gravity of this reaction
     */
    void setLevelOfGravity(int levelOfGravity);

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

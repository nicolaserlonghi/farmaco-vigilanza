package us.rst.farmacovigilanza.models;

import java.sql.Date;

/**
 * Represents a report
 */
public interface Report {
    /**
     * Gets the id of this report
     * @return report id
     */
    int getId();

    /**
     * Sets the id for this report
     * @param id id
     */
    void setId(String id);

    /**
     * Gets the description of this report
     * @return report description
     */
    String getDescription();

    /**
     * Sets the report for this description
     * @param description description
     */
    void setDescription(String description);

    /**
     * Gets the date when the reaction happened
     * @return the date when the reaction happened
     */
    Date getReactionDate();

    /**
     * Sets the date when the reaction happened
     * @param date date
     */
    void setReactionDate(Date date);
}

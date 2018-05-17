package us.rst.farmacovigilanza.models;

import java.sql.Date;

/**
 * Represents a therapy
 */
public interface Therapy {
    /**
     * Gets the name of the therapy
     * @return therapy name
     */
    String getName();

    /**
     * Sets the name of the therapy
     * @param name therapy name
     */
    void setName(String name);

    /**
     * Gets the amount of therapy taken
     * @return amount of therapy takne
     */
    int getUnit();

    /**
     * Sets the amount of therapy taken
     * @param unit amount of therapy taken
     */
    void setUnit(int unit);

    /**
     * Gets the frequency of the therapy
     * @return frequency of the therapy
     */
    int getFrequency();

    /**
     * Sets the frequency of the therapy
     * @param frequency therapy frequency
     */
    void setFrequency(int frequency);

    /**
     * Gets the start date of the therapy
     * @return start date of the therapy
     */
    Date getStartDate();

    /**
     * Sets the start date of the therapy
     * @param startDate therapy start date
     */
    void setStartDate(Date startDate);

    /**
     * Gets the end date of the therapy
     * @return therapy end date
     */
    Date getEndDate();

    /**
     * Sets the end date of the therapy
     * @param endDate therapy end date
     */
    void setEndDate(Date endDate);
}

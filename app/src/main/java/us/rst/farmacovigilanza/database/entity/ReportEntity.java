package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import java.sql.Date;
import us.rst.farmacovigilanza.models.Patient;
import us.rst.farmacovigilanza.models.Report;

/**
 * Represents the entity for {@link Report}
 */
@Entity(tableName = "reports",
    foreignKeys = {
        @ForeignKey(entity = PatientEntity.class,
            parentColumns = "id",
            childColumns = "patientId"),
        @ForeignKey(entity = AvverseReactionEntity.class,
            parentColumns = "name",
            childColumns = "avverseReactionName")
    })
public class ReportEntity implements Report {
    /**
     * Gets the id of this report
     * @return report id
     */
    @Override public int getId() {
        return id;
    }

    /**
     * Sets the id for this report
     * @param id id
     */
    @Override public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the description of this report
     * @return report description
     */
    @Override public String getDescription() {
        return description;
    }

    /**
     * Sets the report for this description
     * @param description description
     */
    @Override public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the date when the reaction happened
     * @return the date when the reaction happened
     */
    @Override public Date getReactionDate() {
        return reactionDate;
    }

    /**
     * Sets the date when the reaction happened
     * @param date date
     */
    @Override public void setReactionDate(Date date) {
        this.reactionDate = date;
    }

    /**
     * Gets the date when the report has been recorded
     * @return date when the report has been recorded
     */
    @Override public Date getReportDate() {
        return reportDate;
    }

    /**
     * Sets the date when the report has been recorded
     * @param date date
     */
    @Override public void setReportDate(Date date) {
        this.reactionDate = date;
    }

    /**
     * Gets the id of the patient
     * @return patient id
     */
    @Override public int getPatientId() {
        return patientId;
    }

    /**
     * Sets the id of the patient
     * @param patientId patient id
     */
    @Override public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * Gets the name of the avverse reaction
     * @return avverse reaciton
     */
    @Override public String getAvverseReactionName() {
        return avverseReactionName;
    }

    /**
     * Sets the name of the avverse reaction
     * @param avverseReactionName avverse reaction name
     */
    @Override public void setAvverseReactionName(String avverseReactionName) {
        this.avverseReactionName = avverseReactionName;
    }

    private int id;
    private String description;
    private Date reactionDate;
    private Date reportDate;
    private Patient patient;
    private int patientId;
    private String avverseReactionName;
}

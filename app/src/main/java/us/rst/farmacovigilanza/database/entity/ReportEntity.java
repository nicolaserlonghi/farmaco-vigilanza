package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import us.rst.farmacovigilanza.models.FiscalCode;
import us.rst.farmacovigilanza.models.Report;

/**
 * Represents the entity for {@link Report}
 */
@Entity(tableName = "reports",
    foreignKeys = {
        @ForeignKey(entity = PatientEntity.class,
            parentColumns = "fiscalCode",
            childColumns = "patientFiscalCode"),
        @ForeignKey(entity = AdverseReactionEntity.class,
            parentColumns = "name",
            childColumns = "adverseReactionName"),
        @ForeignKey(entity = TherapyEntity.class,
                parentColumns = "id",
                childColumns = "therapyId")
    })
public class ReportEntity implements Report {
    /**
     * Gets the reportId of this report
     * @return report reportId
     */
    @Override public int getReportId() {
        return reportId;
    }

    /**
     * Sets the reportId for this report
     * @param id reportId
     */
    @Override public void setReportId(int id) {
        this.reportId = id;
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
        this.reportDate = date;
    }

    /**
     * Gets the fiscal code of the patient
     * @return patient fiscal code
     */
    @Override public FiscalCode getPatientFiscalCode() {
        return patientFiscalCode;
    }

    /**
     * Sets the fiscal code of the patient
     * @param fiscalCode fiscal code
     */
    @Override public void setPatientFiscalCode(FiscalCode fiscalCode) {
        this.patientFiscalCode = fiscalCode;
    }

    /**
     * Gets the name of the avverse reaction
     * @return avverse reaciton
     */
    @Override public String getAdverseReactionName() {
        return adverseReactionName;
    }

    /**
     * Sets the name of the avverse reaction
     * @param adverseReactionName avverse reaction name
     */
    @Override public void setAdverseReactionName(String adverseReactionName) {
        this.adverseReactionName = adverseReactionName;
    }


    /**
     * Get the level of gravity (1-5) of this reaction
     * @return level of gravity (1-5) of this reaction
     */
    @Override public int getLevelOfGravity() {
        return this.levelOfGravity;
    }

    /**
     * Sets the level of gravity (1-5) of this reaction
     * @param levelOfGravity level of gravity of this reaction
     */
    @Override public void setLevelOfGravity(int levelOfGravity) {
        this.levelOfGravity = levelOfGravity;
    }

    @Override public int getTherapyId() {
        return therapyId;
    }

    @Override public void setTherapyId(int id) {
        therapyId = id;
    }

    @Override
    public String getDoctor() {
        return doctor;
    }

    @Override
    public void setDoctor(String doctorId) {
        this.doctor = doctorId;
    }

    @PrimaryKey(autoGenerate = true)
    private int reportId;
    private String description;
    private Date reactionDate;
    private Date reportDate;
    private FiscalCode patientFiscalCode;
    private String adverseReactionName;
    private int therapyId;
    private int levelOfGravity;
    private String doctor;
}

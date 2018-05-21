package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

/**
 * Represents the many to many relationship between reports and avverse reactions
 */
@Entity(tableName = "reportAvverseReaction",
        foreignKeys = {
                @ForeignKey(entity = ReportEntity.class,
                        parentColumns = "id",
                        childColumns = "reportId"),
                @ForeignKey(entity = AvverseReactionEntity.class,
                        parentColumns = "name",
                        childColumns = "avverseReactionName")
        })
public class ReportAvverseReactionEntity {
    /**
     * Gets the id of the report
     * @return report id
     */
    public int getReportId() {
        return reportId;
    }

    /**
     * Sets the id of the report
     * @param reportId report id
     */
    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    /**
     * Gets the name of the avverse reaction
     * @return name of the avverse reaction
     */
    public String getAvverseReactionName() {
        return avverseReactionName;
    }

    /**
     * Sets the name of the avverse reaction
     * @param avverseReactionName name of the avverse reaction
     */
    public void setAvverseReactionName(String avverseReactionName) {
        this.avverseReactionName = avverseReactionName;
    }

    /**
     * Gets the level of gravity of this report
     * @return level of gravity of this report
     */
    public int getLevelOfGravity() {
        return levelOfGravity;
    }

    /**
     * Sets the level of gravity of this report
     * @param levelOfGravity level of gravity
     */
    public void setLevelOfGravity(int levelOfGravity) {
        this.levelOfGravity = levelOfGravity;
    }

    private int reportId;
    private String avverseReactionName;
    private int levelOfGravity;
}

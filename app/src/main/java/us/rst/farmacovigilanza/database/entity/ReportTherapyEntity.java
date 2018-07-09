package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Embedded;

/**
 * Rappresenta la correlazione tra una segnalazione e la terapia collegata
 */
public class ReportTherapyEntity {
    @Embedded
    private ReportEntity report;
    @Embedded
    private TherapyEntity therapyEntity;

    public ReportEntity getReport() {
        return report;
    }

    public void setReport(ReportEntity report) {
        this.report = report;
    }

    public TherapyEntity getTherapyEntity() {
        return therapyEntity;
    }

    public void setTherapyEntity(TherapyEntity therapyEntity) {
        this.therapyEntity = therapyEntity;
    }
}

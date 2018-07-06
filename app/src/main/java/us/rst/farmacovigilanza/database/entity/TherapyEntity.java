package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Date;
import us.rst.farmacovigilanza.models.FiscalCode;
import us.rst.farmacovigilanza.models.Therapy;

@Entity(tableName = "therapyEntity",
        foreignKeys = {
                @ForeignKey(entity = PatientEntity.class,
                        parentColumns = "fiscalCode",
                        childColumns = "patient"),
        })
public class TherapyEntity implements Therapy {
    /**
     * Restituisce l'id della terapia
     * @return id terapia
     */
    @Override public int getId() {
        return id;
    }

    /**
     * Imposta l'id della terapia
     * @param id id terapia
     */
    @Override public void setId(int id) {
        this.id = id;
    }

    /**
     * Restituisce il farmaco legato alla terapia
     * @return farmaco legato alla terapia
     */
    @Override public String getMedicine() {
        return medicine;
    }

    /**
     * Imposta il farmaco legato alla terapia
     * @param medicine farmaco legato alla terapia
     */
    @Override public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    /**
     * Restituisce il numero di volte che la terapia va presa
     * @return numero di volte che la terapia va presa
     */
    @Override public int getUnit() {
        return unit;
    }

    /**
     * Imposta il numero di volte che la terapia va presa
     * @param unit numero di volte che la terapia va presa
     */
    @Override public void setUnit(int unit) {
        this.unit = unit;
    }

    /**
     * Restituisce la frequenza della terapia
     * @return frequenza della terapia
     */
    @Override public int getFrequency() {
        return frequency;
    }

    /**
     * Imposta la frequenza della terapia
     * @param frequency frequenza della terapia
     */
    @Override public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * Restituisce la data di inizio della terapia
     * @return data di inizio della terapia
     */
    @Override public Date getStartDate() {
        return startDate;
    }

    /**
     * Imposta la data di inizio della terapia
     * @param startDate data di inizio della terapia
     */
    @Override public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Restituisce la data di fine della terapia
     * @return data di fine della terapia
     */
    @Override public Date getEndDate() {
        return endDate;
    }

    /**
     * Imposta la data di fine della terapia
     * @param endDate data di fine della terapia
     */
    @Override public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Restituisce il codice fiscale del paziente legato a questa terapia
     * @return il codice fiscale del paziente legato a questa terapia
     */
    @Override public FiscalCode getPatient() {
        return patient;
    }

    /**
     * Imposta il codice fiscale del paziente legato a questa terapia
     * @param cf codice fiscale del paziente legato a questa terapia
     */
    @Override public void setPatient(FiscalCode cf) {
        this.patient = cf;
    }

    @PrimaryKey
    private int id;
    private Date startDate;
    private Date endDate;
    private int unit;
    private String medicine;
    private int frequency;
    private FiscalCode patient;
}

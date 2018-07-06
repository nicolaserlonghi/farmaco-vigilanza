package us.rst.farmacovigilanza.models;

import java.sql.Date;

/**
 * Rappresenta una terapia
 */
public interface Therapy {
    /**
     * Restituisce l'id della terapia
     * @return id terapia
     */
    int getId();

    /**
     * Imposta l'id della terapia
     * @param id id terapia
     */
    void setId(int id);

    /**
     * Restituisce il farmaco legato alla terapia
     * @return farmaco legato alla terapia
     */
    String getMedicine();

    /**
     * Imposta il farmaco legato alla terapia
     * @param medicine farmaco legato alla terapia
     */
    void setMedicine(String medicine);

    /**
     * Restituisce il numero di volte che la terapia va presa
     * @return numero di volte che la terapia va presa
     */
    int getUnit();

    /**
     * Imposta il numero di volte che la terapia va presa
     * @param unit numero di volte che la terapia va presa
     */
    void setUnit(int unit);

    /**
     * Restituisce la frequenza della terapia
     * @return frequenza della terapia
     */
    int getFrequency();

    /**
     * Imposta la frequenza della terapia
     * @param frequency frequenza della terapia
     */
    void setFrequency(int frequency);

    /**
     * Restituisce la data di inizio della terapia
     * @return data di inizio della terapia
     */
    Date getStartDate();

    /**
     * Imposta la data di inizio della terapia
     * @param startDate data di inizio della terapia
     */
    void setStartDate(Date startDate);

    /**
     * Restituisce la data di fine della terapia
     * @return data di fine della terapia
     */
    Date getEndDate();

    /**
     * Imposta la data di fine della terapia
     * @param endDate data di fine della terapia
     */
    void setEndDate(Date endDate);

    /**
     * Restituisce il codice fiscale del paziente legato a questa terapia
     * @return il codice fiscale del paziente legato a questa terapia
     */
    FiscalCode getPatient();

    /**
     * Imposta il codice fiscale del paziente legato a questa terapia
     * @param cf codice fiscale del paziente legato a questa terapia
     */
    void setPatient(FiscalCode cf);
}

package us.rst.farmacovigilanza.repositories;

import android.arch.lifecycle.LiveData;
import us.rst.farmacovigilanza.database.AppDatabase;
import us.rst.farmacovigilanza.database.entity.DoctorEntity;
import us.rst.farmacovigilanza.models.Doctor;

/**
 * Gestisce le interrogazioni al database per il dominio dei farmacologi
 */
public class PharmacologistRepository extends BaseRepository {
    /**
     * Inizializza una nuova istanza di questa classe
     * @param database un'istanza di {@link AppDatabase}
     */
    public PharmacologistRepository(AppDatabase database) {
        super(database);
    }
}

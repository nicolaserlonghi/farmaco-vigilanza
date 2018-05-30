package us.rst.farmacovigilanza.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import us.rst.farmacovigilanza.database.converters.DateConverter;
import us.rst.farmacovigilanza.database.converters.FiscalCodeConverter;
import us.rst.farmacovigilanza.database.dao.DoctorsDao;
import us.rst.farmacovigilanza.database.entity.AvverseReactionEntity;
import us.rst.farmacovigilanza.database.entity.DoctorEntity;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.database.entity.PatientFactorEntity;
import us.rst.farmacovigilanza.database.entity.ReportAvverseReactionEntity;
import us.rst.farmacovigilanza.database.entity.ReportEntity;

@Database(entities = { AvverseReactionEntity.class, DoctorEntity.class, FactorEntity.class,
        PatientEntity.class, PatientFactorEntity.class, ReportAvverseReactionEntity.class, ReportEntity.class }, version = 1)
@TypeConverters({ DateConverter.class, FiscalCodeConverter.class })
public abstract class AppDatabase extends RoomDatabase {
    public abstract DoctorsDao doctorsDao();
}

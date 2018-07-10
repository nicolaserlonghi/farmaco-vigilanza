package us.rst.farmacovigilanza.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import us.rst.farmacovigilanza.database.converters.DateConverter;
import us.rst.farmacovigilanza.database.converters.FiscalCodeConverter;
import us.rst.farmacovigilanza.database.converters.UserTypeConverter;
import us.rst.farmacovigilanza.database.dao.AdverseReactionsDao;
import us.rst.farmacovigilanza.database.dao.CredentialsDao;
import us.rst.farmacovigilanza.database.dao.DoctorsDao;
import us.rst.farmacovigilanza.database.dao.DrugsDao;
import us.rst.farmacovigilanza.database.dao.FactorsDao;
import us.rst.farmacovigilanza.database.dao.PatientsDao;
import us.rst.farmacovigilanza.database.dao.ReportsDao;
import us.rst.farmacovigilanza.database.dao.TherapiesDao;
import us.rst.farmacovigilanza.database.entity.AdverseReactionEntity;
import us.rst.farmacovigilanza.database.entity.CredentialsEntity;
import us.rst.farmacovigilanza.database.entity.DoctorEntity;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.database.entity.PatientFactorEntity;
import us.rst.farmacovigilanza.database.entity.ReportEntity;
import us.rst.farmacovigilanza.database.entity.TherapyEntity;

@Database(entities = { AdverseReactionEntity.class, DoctorEntity.class, FactorEntity.class,
        PatientEntity.class, PatientFactorEntity.class, ReportEntity.class,
    CredentialsEntity.class, TherapyEntity.class }, version = 1)
@TypeConverters({ DateConverter.class, FiscalCodeConverter.class, UserTypeConverter.class })
public abstract class AppDatabase extends RoomDatabase {
    public abstract DoctorsDao doctorsDao();
    public abstract PatientsDao patientsDao();
    public abstract CredentialsDao credentialsDao();
    public abstract DrugsDao drugsDao();
    public abstract FactorsDao factorsDao();
    public abstract AdverseReactionsDao avverseReactionsDao();
    public abstract ReportsDao reportsDao();
    public abstract TherapiesDao therapyDao();
}

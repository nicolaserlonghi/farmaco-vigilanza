package us.rst.farmacovigilanza.database.converters;

import android.arch.persistence.room.TypeConverter;

import java.sql.Date;

import us.rst.farmacovigilanza.models.FiscalCode;

/**
 * Handles database {@link Date} conversion
 */
public class FiscalCodeConverter {
    @TypeConverter
    public static FiscalCode fromString(String cf) {
        return FiscalCode.parse(cf);
    }

    @TypeConverter
    public static String cfToString(FiscalCode cf) {
        return cf == null ? null : cf.toString();
    }
}

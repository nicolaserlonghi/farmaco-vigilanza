package us.rst.farmacovigilanza.database.converters;

import android.arch.persistence.room.TypeConverter;
import java.util.Date;

/**
 * Handles database {@link Date} conversion
 */
public class DateConverter {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}

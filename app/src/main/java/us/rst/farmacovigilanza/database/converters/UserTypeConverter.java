package us.rst.farmacovigilanza.database.converters;

import android.arch.persistence.room.TypeConverter;
import us.rst.farmacovigilanza.models.Credentials.UserType;

/**
 * Gestisce la serializzazione e deserializzazione dell'enumeratore {@link UserType}
 */
public class UserTypeConverter {
    @TypeConverter
    public static UserType fromString(String userType) {
        return UserType.valueOf(userType);
    }

    @TypeConverter
    public static String userTypeToString(UserType userType) {
        return userType == null ? null : userType.toString();
    }
}

package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import us.rst.farmacovigilanza.models.Factor;

/**
 * Represents the entity of {@link Factor}
 */
@Entity(tableName = "factors")
public class FactorEntity implements Factor {
    /**
     * Gets the name of this factor
     * @return factor
     */
    @Override public String getName() {
        return name;
    }

    /**
     * Sets the name of this factor
     * @param name factor
     */
    @Override public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of this factor
     * @return description
     */
    @Override public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this factor
     * @param description description
     */
    @Override public void setDescription(String description) {
        this.description = description;
    }

    private String name;
    private String description;
}

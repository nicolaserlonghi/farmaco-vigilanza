package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import us.rst.farmacovigilanza.models.AdverseReaction;

/**
 * Represents the entity for {@link AdverseReaction}
 */
@Entity(tableName = "avverseReactions")
public class AdverseReactionEntity implements AdverseReaction {
    /**
     * Gets the name of the reaction
     * @return reaction name
     */
    @Override public String getName() {
        return name;
    }

    /**
     * Sets the name of the reaction
     * @param name reaction name
     */
    @Override public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of this reaction
     * @return reaction description
     */
    @Override public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this reaction
     * @param description description reaction
     */
    @Override public void setDescription(String description) {
        this.description = description;
    }

    @PrimaryKey @NonNull
    private String name;
    private String description;
}

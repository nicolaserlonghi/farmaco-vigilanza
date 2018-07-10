package us.rst.farmacovigilanza.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import us.rst.farmacovigilanza.models.Proposal;

@Entity(tableName = "proposals")
public class ProposalEntity implements Proposal {

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDrug() {
        return drug;
    }

    @Override
    public void setDrug(String drug) {
        this.drug = drug;
    }

    @PrimaryKey @NonNull
    String drug;
    String type;
}

package org.codepository.mytoko.models.entity;

import org.codepository.mytoko.models.enumeration.Campus;
import org.codepository.mytoko.models.enumeration.Division;

public class Staff extends User {
    private final Division division;
    private final String position;

    public Staff(String name, Campus campus, Division division, String position) {
        super(name, campus);
        this.division = division;
        this.position = position;
    }

    public String getDivision() {
        if (division == Division.SLC) {
            return "Software Laboratory Center";
        } else if (division == Division.SOCS) {
            return "School of Computer Science";
        } else if (division == Division.IT) {
            return "IT Support";
        }

        return null;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String getEmail() {
        return this.getUsername() + "@bimaya.edu";
    }

    @Override
    public String getRole() {
        return "Staff";
    }
}

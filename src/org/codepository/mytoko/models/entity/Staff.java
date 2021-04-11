package org.codepository.mytoko.models.entity;

import org.codepository.mytoko.models.enumeration.Campus;
import org.codepository.mytoko.models.enumeration.Division;

public class Staff extends User {
    private final Division division;
    private final String position;

    protected Staff(String name, Campus campus, Division division, String position) {
        super(name, campus);
        this.division = division;
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String getEmail() {
        return this.getUsername() + "@binus.edu";
    }
}

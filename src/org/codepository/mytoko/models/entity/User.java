package org.codepository.mytoko.models.entity;

import org.codepository.mytoko.models.enumeration.Campus;

public abstract class User {
    protected String name;
    protected Campus campus;

    protected User(String name, Campus campus) {
        this.name = name;
        this.campus = campus;
    }

    public String getName() {
        return name;
    }

    public Campus getCampus() {
        return campus;
    }

    public String getUsername() {
        String[] subnames = name.split(" ");
        return subnames[0].toLowerCase() + "." + subnames[subnames.length - 1].toLowerCase();
    }

    public abstract String getEmail();
    public abstract String getRole();
}

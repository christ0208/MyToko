package org.codepository.mytoko.models.entity;

import org.codepository.mytoko.interfaces.CanGenerateEmail;
import org.codepository.mytoko.interfaces.CanGenerateUsername;
import org.codepository.mytoko.interfaces.CanShowRole;
import org.codepository.mytoko.models.enumeration.Campus;

public abstract class User implements CanShowRole, CanGenerateUsername, CanGenerateEmail {
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

    @Override
    public String getUsername() {
        String[] subnames = name.split(" ");
        return subnames[0].toLowerCase() + "." + subnames[subnames.length - 1].toLowerCase();
    }
}

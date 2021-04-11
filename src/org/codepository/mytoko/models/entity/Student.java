package org.codepository.mytoko.models.entity;

import org.codepository.mytoko.models.enumeration.Campus;
import org.codepository.mytoko.models.enumeration.Major;

public class Student extends User {
    private final Major major;

    protected Student(String name, Campus campus, Major major) {
        super(name, campus);
        this.major = major;
    }

    @Override
    public String getName() {
        return super.getName().toUpperCase();
    }

    public Major getMajor() {
        return major;
    }

    @Override
    public String getEmail() {
        return this.getUsername() + "@binus.ac.id";
    }
}

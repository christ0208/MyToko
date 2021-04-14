package org.codepository.mytoko.models.entity;

import org.codepository.mytoko.models.enumeration.Campus;
import org.codepository.mytoko.models.enumeration.Major;

public class Student extends User {
    private final Major major;

    public Student(String name, Campus campus, Major major) {
        super(name, campus);
        this.major = major;
    }

    @Override
    public String getName() {
        return super.getName().toUpperCase();
    }

    public String getMajor() {
        if (major == Major.CS) {
            return "Computer Science";
        } else if (major == Major.IS) {
            return "Information Systems";
        }

        return null;
    }

    @Override
    public String getEmail() {
        return this.getUsername() + "@binus.ac.id";
    }

    @Override
    public String getRole() {
        return "Student";
    }
}

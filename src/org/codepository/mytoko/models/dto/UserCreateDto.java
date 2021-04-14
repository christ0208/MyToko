package org.codepository.mytoko.models.dto;

public class UserCreateDto {
    protected final String name;
    protected final String campus;

    public UserCreateDto(String name, String campus) {
        this.name = name;
        this.campus = campus;
    }

    public String getName() {
        return name;
    }

    public String getCampus() {
        return campus;
    }
}

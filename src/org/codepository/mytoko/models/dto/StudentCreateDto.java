package org.codepository.mytoko.models.dto;

public class StudentCreateDto extends UserCreateDto {
    private final String major;

    public StudentCreateDto(String name, String campus, String major) {
        super(name, campus);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }
}

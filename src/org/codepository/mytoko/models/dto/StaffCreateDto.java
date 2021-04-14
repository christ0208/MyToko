package org.codepository.mytoko.models.dto;

public class StaffCreateDto extends UserCreateDto {
    private final String division;
    private final String position;

    public StaffCreateDto(String name, String campus, String division, String position) {
        super(name, campus);
        this.division = division;
        this.position = position;
    }

    public String getDivision() {
        return division;
    }

    public String getPosition() {
        return position;
    }
}

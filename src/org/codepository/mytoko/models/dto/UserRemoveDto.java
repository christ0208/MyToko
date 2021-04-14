package org.codepository.mytoko.models.dto;

public class UserRemoveDto {
    private final String role;
    private final String username;

    public UserRemoveDto(String role, String username) {
        this.role = role;
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }
}

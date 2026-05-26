package com.historias_de_cafe.backend.DTO;
import com.historias_de_cafe.backend.model.User;

public class UserResponseDTO {
    private String id;
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String role;

    public UserResponseDTO() {
    }

    public static UserResponseDTO from(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.confirmPassword = user.getPasswordHash();
        dto.email = user.getEmail();
        dto.name = user.getName();
        return dto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

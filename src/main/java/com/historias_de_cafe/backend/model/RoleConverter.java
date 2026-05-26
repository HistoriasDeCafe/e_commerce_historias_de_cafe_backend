package com.historias_de_cafe.backend.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role role) {
        if (role == null) {
            return null;
        }

        return role.name();
    }

    @Override
    public Role convertToEntityAttribute(String value) {
        return Role.fromValue(value);
    }
}

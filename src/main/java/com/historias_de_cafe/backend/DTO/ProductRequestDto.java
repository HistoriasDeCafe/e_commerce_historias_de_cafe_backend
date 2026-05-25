package com.historias_de_cafe.backend.DTO;

import java.math.BigDecimal;

public record ProductRequestDto(
        String name,
        String description,
        BigDecimal price,
        Integer stock,
        Long categorieId
) {}

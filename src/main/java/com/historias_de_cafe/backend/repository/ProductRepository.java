package com.historias_de_cafe.backend.repository;

import com.historias_de_cafe.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

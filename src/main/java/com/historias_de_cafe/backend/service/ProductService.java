package com.historias_de_cafe.backend.service;

import com.historias_de_cafe.backend.DTO.ProductRequestDto;
import com.historias_de_cafe.backend.DTO.ProductResponseDto;
import com.historias_de_cafe.backend.model.Product;
import com.historias_de_cafe.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto create(ProductRequestDto dto) {
        validate(dto);

        Product product = new Product();
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setStock(dto.stock());
        product.setCategorieId(dto.categorieId());

        return toResponseDto(productRepository.save(product));
    }

    @Transactional(readOnly = true)
    public ProductResponseDto getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return toResponseDto(product);
    }

    @Transactional(readOnly = true)
    public List<ProductResponseDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public ProductResponseDto update(Long id, ProductRequestDto dto) {
        validate(dto);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setStock(dto.stock());
        product.setCategorieId(dto.categorieId());

        return toResponseDto(productRepository.save(product));
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        productRepository.delete(product);
    }

    private void validate(ProductRequestDto dto) {
        if (dto.name() == null || dto.name().isBlank()) {
            throw new RuntimeException("Product name is required");
        }

        if (dto.price() == null || dto.price().signum() <= 0) {
            throw new RuntimeException("Product price must be greater than 0");
        }

        if (dto.stock() == null || dto.stock() < 0) {
            throw new RuntimeException("Product stock must be greater than or equal to 0");
        }
    }

    private ProductResponseDto toResponseDto(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategorieId()
        );
    }
}

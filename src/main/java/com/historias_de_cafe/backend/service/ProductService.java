package com.historias_de_cafe.backend.service;

import com.historias_de_cafe.backend.model.Product;
import com.historias_de_cafe.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product update(Long id, Product datos) {
        Product existente = productRepository.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setName(datos.getName());
        existente.setDescription(datos.getDescription());
        existente.setPrice(datos.getPrice());
        existente.setStock(datos.getStock());
        return productRepository.save(existente);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

}

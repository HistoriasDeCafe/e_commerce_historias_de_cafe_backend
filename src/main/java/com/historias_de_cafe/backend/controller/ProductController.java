package com.historias_de_cafe.backend.controller;

import com.historias_de_cafe.backend.model.Product;
import com.historias_de_cafe.backend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> obtenerTodosProductos() {
        return ResponseEntity.ok(productService.findAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> obtenerPorId(@PathVariable Long id) {
        Product producto = productService.findById(id);
        if (producto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Product> crear(@Valid @RequestBody Product producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> actualizar(@PathVariable Long id,
                                               @Valid @RequestBody Product datos) {
        Product actualizado = productService.update(id, datos);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


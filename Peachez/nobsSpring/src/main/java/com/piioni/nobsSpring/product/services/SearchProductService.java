package com.piioni.nobsSpring.product.services;

import com.piioni.nobsSpring.Query;
import com.piioni.nobsSpring.product.ProductRepository;
import com.piioni.nobsSpring.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchProductService implements Query<String, List<ProductDTO>> {
    private final ProductRepository productRepository;

    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(String name) {
        return ResponseEntity.ok(productRepository.findByNameOrDescriptionContaining(name)
                .stream()
                .map(ProductDTO::new)
                .toList());
    }
}

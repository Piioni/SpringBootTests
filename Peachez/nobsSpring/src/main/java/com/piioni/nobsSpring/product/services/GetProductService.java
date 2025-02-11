package com.piioni.nobsSpring.product.services;

import com.piioni.nobsSpring.Query;
import com.piioni.nobsSpring.product.ProductRepository;
import com.piioni.nobsSpring.product.model.Product;
import com.piioni.nobsSpring.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {
    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        Optional<Product> productOptional = productRepository.findById(input);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }
        // TODO: return 404 Product not found exception

        return null;
    }

}

package com.piioni.nobsSpring.product.services;

import com.piioni.nobsSpring.Command;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Void, String> {

    @Override
    public ResponseEntity<String> execute(Void input) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Create a product");
    }
}

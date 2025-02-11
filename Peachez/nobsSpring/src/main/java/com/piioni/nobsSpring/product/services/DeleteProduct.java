package com.piioni.nobsSpring.product.services;

import com.piioni.nobsSpring.Command;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteProduct implements Command<Void, String> {

    @Override
    public ResponseEntity<String> execute(Void input) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete a product");
    }


}

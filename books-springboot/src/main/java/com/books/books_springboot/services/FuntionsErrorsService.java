package com.books.books_springboot.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class FuntionsErrorsService {

    //METHOD USED FOR RESPONSE IN INTERNAL SERVER ERRORS
    public ResponseEntity<Object> generalError(Exception e){
        
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("Error", e.getMessage());

        return ResponseEntity.ok().body(responseBody);
    }

    public ResponseEntity<Object> notFoundErrorAllEntity(String entitieName){

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "The DB don't have registers of " + entitieName);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }

    public ResponseEntity<Object> notFoundErrorId(Long id){

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "THE Id: " + id + " isn`t present in DB");
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }

    public ResponseEntity<?> validationMessages(BindingResult result){

        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {

            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

}

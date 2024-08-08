package com.books.books_springboot.services.book;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookfuntionsService {

    //METHOD USED FOR RESPONSE IN INTERNAL SERVER ERRORS
    public ResponseEntity<Object> generalError(Exception e){

        return ResponseEntity.internalServerError().body(new HashMap<>().
        put("Message", "Error: " + e));

    }

    public ResponseEntity<Object> notFoundError(){

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "The DB don't have registers of books");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }
}

package com.books.books_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.books_springboot.entities.Language;
import com.books.books_springboot.services.language.LanguageServiceImpl;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/language")
public class LanguageController {

    private LanguageServiceImpl languageServiceImpl;

    public LanguageController(LanguageServiceImpl languageServiceImpl){

        this.languageServiceImpl = languageServiceImpl;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllLanguage() {
        
        return languageServiceImpl.getAllLanguages(); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLanguageById(@PathVariable("id") Long id) {
        
        return languageServiceImpl.getLanguageById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLanguage(@Valid @RequestBody Language language, BindingResult result) {
        
        return languageServiceImpl.createLanguage(language, result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateLanguage(@Valid @PathVariable("id") Long id, @RequestBody Language language, BindingResult result) {
        
        return languageServiceImpl.updateLanguage(id, language, result);
    }
    
    @DeleteMapping("/{id}")    
    public ResponseEntity<?> deleteLanguage(@PathVariable("id") Long id) {
        
        return languageServiceImpl.deleteLanguage(id);
    }
}

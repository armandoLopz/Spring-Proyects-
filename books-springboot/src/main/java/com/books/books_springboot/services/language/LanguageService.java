package com.books.books_springboot.services.language;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.books.books_springboot.entities.Language;

public interface LanguageService {

    ResponseEntity<?> getAllLanguages();

    ResponseEntity<?> getLanguageById(Long id);
    
    ResponseEntity<?> createLanguage(Language language,  BindingResult result);
    
    ResponseEntity<?> updateLanguage(Long id, Language language, BindingResult result);

    ResponseEntity<?> deleteLanguage(Long id);

    ResponseEntity<?> addGenreInLanguage(Long id);
    
    ResponseEntity<?> addAuthorInLanguage(Long id);
}

package com.books.books_springboot.services.language;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.books.books_springboot.entities.Language;
import com.books.books_springboot.repositories.LanguageRepositories;
import com.books.books_springboot.services.FuntionsErrorsService;

@Service
public class LanguageServiceImpl implements LanguageService{

    private LanguageRepositories languageRepositories;
    private FuntionsErrorsService funtionsErrorsService;
    
    public LanguageServiceImpl(LanguageRepositories languageRepositories, FuntionsErrorsService funtionsErrorsService){

        this.languageRepositories = languageRepositories;
        this.funtionsErrorsService = funtionsErrorsService;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllLanguages() {
        
        try {

            List<Language> languages = (List<Language>) languageRepositories.findAll();

            if (languages.isEmpty()) {
                
                return funtionsErrorsService.notFoundErrorAllEntity("Languages");
            }

            return ResponseEntity.ok(languages);

        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    public ResponseEntity<?> getLanguageById(Long id) {
        
        try {
            
            Optional<Language> languageOptional = languageRepositories.findById(id);

            if (languageOptional.isPresent()) {
                
                return ResponseEntity.ok(languageOptional.orElseThrow());
            }

            return funtionsErrorsService.notFoundErrorId(id);

        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> createLanguage(Language language, BindingResult result) {
        
        try {

            if (result.hasFieldErrors()) {
                
                return funtionsErrorsService.validationMessages(result);
            }

            languageRepositories.save(language);

            return ResponseEntity.status(HttpStatus.CREATED).body(language);

        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateLanguage(Long id, Language languageRequest, BindingResult result) {
        
        try {
            
            if (result.hasFieldErrors()) {
                
                return funtionsErrorsService.validationMessages(result);
            }

            languageRequest.setId(id);
            Optional<Language> languageOptional = languageRepositories.findById(languageRequest.getId());

            if (languageOptional.isPresent()) {
                
                Language languageUpdate = languageOptional.orElseThrow();
                
                languageUpdate.setId(languageRequest.getId());
                languageUpdate.setName(languageRequest.getName());
                languageUpdate.setBooks(languageRequest.getBooks());

                languageRepositories.save(languageUpdate);
                
                return ResponseEntity.status(HttpStatus.CREATED).body(languageUpdate);
            }
            
            return funtionsErrorsService.notFoundErrorId(id);

        } catch (Exception e) {
            
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteLanguage(Long id) {

        try {

            Optional<Language> languageOptional =  languageRepositories.findById(id);

            if (languageOptional.isPresent()) {
                
                languageRepositories.delete(languageOptional.orElseThrow());

                return ResponseEntity.noContent().build();

            }

            return funtionsErrorsService.notFoundErrorId(id);
            
        } catch (Exception e) {
            return funtionsErrorsService.generalError(e);
        }
    }

    @Override
    public ResponseEntity<?> addGenreInLanguage(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addGenreInLanguage'");
    }

    @Override
    public ResponseEntity<?> addAuthorInLanguage(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAuthorInLanguage'");
    }

}

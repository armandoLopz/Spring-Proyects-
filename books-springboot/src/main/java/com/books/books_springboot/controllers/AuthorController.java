package com.books.books_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.books_springboot.entities.Author;
import com.books.books_springboot.models.dto.AuthorDto;
import com.books.books_springboot.services.author.AuthorServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("api/author")
@Tag(name = "Authors", 
description = "Authors controller")

public class AuthorController {

    private AuthorServiceImpl authorServiceImpl;

    public AuthorController(AuthorServiceImpl authorServiceImpl){

        this.authorServiceImpl = authorServiceImpl;
    }

    @GetMapping("")
    @Operation(

        summary = "Get all authors",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(

            required = false
        ),
        responses = {

            @ApiResponse(
                
                responseCode = "200",
                description = "All authors were successfully obtained",
                
                content = @Content(

                mediaType = "application/json",
                schema = @Schema(implementation = AuthorDto.class)

                )
            ),
            @ApiResponse(

                responseCode = "404",
                description = "The DB don't have registers of authors"
                
            ),
            @ApiResponse(

                responseCode = "500",
                description = "Unexpected error in processing the request"
                
            )
        }
    )
    public ResponseEntity<?> getAllAuthors() {
        return authorServiceImpl.getAllAuthors();
    }

    @GetMapping("/{id}")
    @Operation(

        summary = "Get author by id",
        responses = {

            @ApiResponse(
                
                responseCode = "200",
                description = "The author successfully obtained",
                content = @Content(

                mediaType = "application/json",
                schema = @Schema(implementation = AuthorDto.class)

                )
            ),
            @ApiResponse(

                responseCode = "404",
                description = "The author ID doesn't exist in the DB"
                
            ),
            @ApiResponse(

                responseCode = "500",
                description = "Unexpected error in processing the request"
                
            )
        }
    )
    public ResponseEntity<?> getAuthorById(@PathVariable("id") Long id) {
        return authorServiceImpl.getAuthorkById(id);
    }

    @PutMapping("/{id}")
    @Operation(

        summary = "Update author by id",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(

            description = "Update author Request with the author ID and attributes of author",
            required = true,
            content = @Content(

                mediaType = "application/json",
                schema = @Schema(implementation = AuthorDto.class)

                )
        ),
        responses = {

            @ApiResponse(
                
                responseCode = "201",
                description = "The author successfully updated",
                content = @Content(

                mediaType = "application/json",
                schema = @Schema(implementation = AuthorDto.class)

                )
            ),
            @ApiResponse(

                responseCode = "404",
                description = "verify the request, validation of the attributes is not valid"
                
            ),
            @ApiResponse(

                responseCode = "404",
                description = "The author ID doesn't exist in the DB"
                
            ),
            @ApiResponse(

                responseCode = "500",
                description = "Unexpected error in processing the request"
                
            )
        }
    )
    public ResponseEntity<?> updateAuthor(@Valid @PathVariable("id") Long id, @RequestBody Author author, BindingResult result) {
        
        return authorServiceImpl.updateAuthor(id, author, result);
    }

    @PostMapping("/create")
    @Operation(

        summary = "Create author",
         requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(

            description = "Get author Request with the author ID",
            content = @Content(

                mediaType = "application/json",
                schema = @Schema(implementation = Author.class)

            )
        ),
        responses = {

            @ApiResponse(
                
                responseCode = "204",
                description = "The author successfully delete"
            ),
            @ApiResponse(

                responseCode = "201",
                description = "The author successfully created"
                
            ),
            @ApiResponse(

                responseCode = "500",
                description = "Unexpected error in processing the request"
                
            )
        }
    )
    public ResponseEntity<?> createAuthor(@RequestBody Author author, BindingResult result) {
        
        return authorServiceImpl.createAuthor(author, result);
    }    

    @DeleteMapping("/{id}")
    @Operation(

        summary = "Delete author by id",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(

            description = "Delete author Request with the author ID",
            required = true
        ),
        responses = {

            @ApiResponse(
                
                responseCode = "204",
                description = "The author successfully delete"
            ),
            @ApiResponse(

                responseCode = "404",
                description = "The author ID doesn't exist in the DB"
                
            ),
            @ApiResponse(

                responseCode = "500",
                description = "Unexpected error in processing the request"
                
            )
        }
    )
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id) {
        
        return authorServiceImpl.deleteAuthor(id);
    }

}

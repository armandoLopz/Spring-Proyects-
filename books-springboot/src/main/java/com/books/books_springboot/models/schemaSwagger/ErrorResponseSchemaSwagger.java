package com.books.books_springboot.models.schemaSwagger;

public class ErrorResponseSchemaSwagger {

    private String error;

    public ErrorResponseSchemaSwagger(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}

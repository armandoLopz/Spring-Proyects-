package com.books.books_springboot.models.schemaSwagger;

import java.util.Map;

public class Error {

    private Map<String, String> errorMap;

    
    public Error(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    

}

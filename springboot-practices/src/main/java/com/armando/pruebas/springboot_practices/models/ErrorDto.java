package com.armando.pruebas.springboot_practices.models;

import java.util.Date;

public class ErrorDto {
    
    private String message, error;
    private Date date;
    private int status;

    public ErrorDto() {
    }

    public ErrorDto(String message, String error, Date date, int status) {
        this.message = message;
        this.error = error;
        this.date = date;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
 
}

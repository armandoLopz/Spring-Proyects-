package com.armando.pruebas.springboot_practices.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.armando.pruebas.springboot_practices.models.ErrorDto;

@RestControllerAdvice
public class HandlerController {
    
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorDto> errorManage(Exception e){

        ErrorDto errorDto = new ErrorDto();
        errorDto.setDate(new Date());
        errorDto.setError("Error en el Request, verifique su solicitud");
        errorDto.setMessage(e.getMessage());
        errorDto.setStatus(HttpStatus.NOT_FOUND.value());

        //return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errorDto);

        //return ResponseEntity.notFound().build();
        return ResponseEntity.status(404).body(errorDto);
    }
}

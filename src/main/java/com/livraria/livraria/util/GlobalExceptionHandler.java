package com.livraria.livraria.util;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ExceptionReturn.builder()
                        .status(500)
                        .error(ex.getMessage())
                        .build()
                );
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleException(ResponseStatusException ex) {
        return ResponseEntity
                .status(ex.getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(ExceptionReturn.builder()
                        .status(ex.getStatusCode().value())
                        .error(ex.getMessage())
                        .build()
                );
    }
}


package com.dh.meli.spring02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// QUANDO ACONTECER ESSA EXCEÇÃO, QUERO DEVOLVER UM STATUS PERSONALIZADO
@ResponseStatus(HttpStatus.NOT_FOUND)

// CRIANDO UMA EXCEÇÃO PERSONALIZADA A PARTIR DA HERANÇA DO RUNTIME EXPECTION
public class NotFoundException extends RuntimeException{
    // construtor
    public NotFoundException(String message) {
        super(message);
    }
}

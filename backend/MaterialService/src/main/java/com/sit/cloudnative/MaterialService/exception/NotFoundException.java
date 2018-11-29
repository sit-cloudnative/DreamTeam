package com.sit.cloudnative.MaterialService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
    
    public NotFoundException(Throwable thrwbl) {
        super(thrwbl);
    }

    public NotFoundException(String message, Throwable thrwbl) {
        super(message, thrwbl);
    }
    
}

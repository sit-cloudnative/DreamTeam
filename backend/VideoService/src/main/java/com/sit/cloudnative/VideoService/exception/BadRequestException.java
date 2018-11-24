package com.sit.cloudnative.VideoService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
    
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
    
    public BadRequestException(Throwable thrwbl) {
        super(thrwbl);
    }

    public BadRequestException(String message, Throwable thrwbl) {
        super(message, thrwbl);
    }
    
}

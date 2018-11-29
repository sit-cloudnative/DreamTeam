package com.sit.cloudnative.MaterialService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException{
    
    public UnauthorizedException() {
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(Throwable thrwbl) {
        super(thrwbl);
    }
    
    public UnauthorizedException(String message, Throwable thrwbl) {
        super(message, thrwbl);
    }
    
}

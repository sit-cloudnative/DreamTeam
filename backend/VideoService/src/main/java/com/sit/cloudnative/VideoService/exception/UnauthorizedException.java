package com.sit.cloudnative.VideoService.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException{
    
    private final Logger logger = LoggerFactory.getLogger(UnauthorizedException.class);

    public UnauthorizedException() {
    }

    public UnauthorizedException(String message) {
        super(message);
        logger.warn(message);
    }

    public UnauthorizedException(Throwable thrwbl) {
        super(thrwbl);
        logger.warn("", thrwbl);
    }
    
    public UnauthorizedException(String message, Throwable thrwbl) {
        super(message, thrwbl);
        logger.warn(message, thrwbl);
    }
    
}

package com.sit.cloudnative.UserService.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
    
    private final Logger logger = LoggerFactory.getLogger(BadRequestException.class);

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
        logger.info(message);
    }
    
    public BadRequestException(Throwable thrwbl) {
        super(thrwbl);
        logger.info("", thrwbl);
    }

    public BadRequestException(String message, Throwable thrwbl) {
        super(message, thrwbl);
        logger.info(message, thrwbl);
    }
    
}

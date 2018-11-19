package com.sit.cloudnative.UserService.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    private final Logger logger = LoggerFactory.getLogger(NotFoundException.class);
    
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
        logger.info(message);
    }
    
    public NotFoundException(Throwable thrwbl) {
        super(thrwbl);
        logger.info("", thrwbl);
    }

    public NotFoundException(String message, Throwable thrwbl) {
        super(message, thrwbl);
        logger.info(message, thrwbl);
    }
    
}

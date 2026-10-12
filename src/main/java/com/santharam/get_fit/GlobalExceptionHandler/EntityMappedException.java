package com.santharam.get_fit.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT)
public class EntityMappedException extends RuntimeException{
    public EntityMappedException(String message) {
        super(message);
    }
}

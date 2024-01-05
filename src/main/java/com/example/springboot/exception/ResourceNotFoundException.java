package com.example.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    public String firldName;
    private Long fieldValue;

    public ResourceNotFoundException(String resourceName, String firldName, Long fieldValue) {
        super(String.format("%s not found with %s : '%s' ",resourceName,firldName,fieldValue));
        this.resourceName = resourceName;
        this.firldName = firldName;
        this.fieldValue = fieldValue;
    }
}

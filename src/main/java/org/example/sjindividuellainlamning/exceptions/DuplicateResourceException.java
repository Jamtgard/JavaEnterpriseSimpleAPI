package org.example.sjindividuellainlamning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateResourceException extends RuntimeException {

    private final String resource;
    private final String field;
    private final Object duplicatedValue;

    public DuplicateResourceException(String resource, String field, Object duplicatedValue) {
        super(String.format("Database already contains %s with value: %s - (%s)", resource, duplicatedValue, field));
        this.resource = resource;
        this.field = field;
        this.duplicatedValue = duplicatedValue;
    }

    public String getResource() {return resource;}
    public String getField() {return field;}
    public Object getDuplicatedValue() {return duplicatedValue;}

}

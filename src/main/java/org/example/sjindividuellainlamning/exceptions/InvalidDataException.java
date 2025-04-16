package org.example.sjindividuellainlamning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidDataException extends RuntimeException {

    private final String resource;
    private final String field;
    private final Object invalidValue;

    public InvalidDataException(String resource, String field, Object invalidValue) {
        super(String.format("%s - %s: Can not contain invalid data: %s", resource, field, invalidValue));
        this.resource = resource;
        this.field = field;
        this.invalidValue = invalidValue;
    }

    public String getResource() {return resource;}
    public String getField() {return field;}
    public Object getInvalidValue() {return invalidValue;}

}

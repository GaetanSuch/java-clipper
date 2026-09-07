package com.bootstrap.clipper.configurations.exceptions.type;

import com.bootstrap.clipper.configurations.exceptions.ResponseException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ResponseException {
    public NotFoundException() {
        this("Not found");
    }

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}

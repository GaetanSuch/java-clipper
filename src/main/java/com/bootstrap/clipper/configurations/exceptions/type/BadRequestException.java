package com.bootstrap.clipper.configurations.exceptions.type;

import com.bootstrap.clipper.configurations.exceptions.ResponseException;
import org.springframework.http.HttpStatus;

public class BadRequestException extends ResponseException {
    public BadRequestException() {
        this("Bad request");
    }

    public BadRequestException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}

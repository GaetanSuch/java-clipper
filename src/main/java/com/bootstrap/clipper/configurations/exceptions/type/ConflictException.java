package com.bootstrap.clipper.configurations.exceptions.type;

import com.bootstrap.clipper.configurations.exceptions.ResponseException;
import org.springframework.http.HttpStatus;

public class ConflictException extends ResponseException {
    public ConflictException() {
        this("Conflict");
    }

    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }
}

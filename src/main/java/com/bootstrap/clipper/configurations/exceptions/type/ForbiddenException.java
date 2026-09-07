package com.bootstrap.clipper.configurations.exceptions.type;

import com.bootstrap.clipper.configurations.exceptions.ResponseException;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends ResponseException {
    public ForbiddenException() {
        this("Forbidden");
    }

    public ForbiddenException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.FORBIDDEN;
    }
}

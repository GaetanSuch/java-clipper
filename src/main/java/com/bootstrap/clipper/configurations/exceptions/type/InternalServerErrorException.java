package com.bootstrap.clipper.configurations.exceptions.type;

import com.bootstrap.clipper.configurations.exceptions.ResponseException;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ResponseException {
    public InternalServerErrorException() {
        this("Internal server error");
    }

    public InternalServerErrorException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}

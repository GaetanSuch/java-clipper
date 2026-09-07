package com.bootstrap.clipper.configurations.exceptions;


import org.springframework.http.HttpStatus;

public abstract class ResponseException extends RuntimeException {
    public ResponseException(String message) {
        super(message);
    }

    public abstract HttpStatus getHttpStatus();
}

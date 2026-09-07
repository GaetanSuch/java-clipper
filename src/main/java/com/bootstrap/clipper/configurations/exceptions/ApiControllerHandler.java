package com.bootstrap.clipper.configurations.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiControllerHandler {

    // Gère toutes nos exceptions métier (NotFoundException, ConflictException, etc.)
    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<MessageError> handleResponseException(ResponseException ex) {
        MessageError message = MessageError.builder().message(ex.getMessage()).build();
        return ResponseEntity.status(ex.getHttpStatus()).body(message);
    }

    // Gère les erreurs de validation (@Valid sur les DTOs)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageError> handleNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(f ->
                errorMap.put(f.getField(), f.getDefaultMessage())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageError.builder().errors(errorMap).build());
    }

    // Filet de sécurité : toute exception non gérée → 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageError> handleGenericException(Exception ex) {
        MessageError message = MessageError.builder().message("Erreur interne du serveur").build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
}

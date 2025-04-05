package com.laqqueta.healthcare.util.exceptions;

import com.laqqueta.healthcare.util.error.ErrorMessage;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionsGlobalHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEntityNotFound(EntityNotFoundException ex) {
        ErrorMessage err = new ErrorMessage(
                ex.getMessage(),
                ex.getClass().getSimpleName(),
                LocalDateTime.now());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

}

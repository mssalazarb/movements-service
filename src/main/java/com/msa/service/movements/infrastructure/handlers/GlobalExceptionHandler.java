package com.msa.service.movements.infrastructure.handlers;

import com.msa.service.movements.domain.exceptions.ConflictException;
import com.msa.service.movements.model.Error;
import com.msa.service.movements.model.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<Error> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Error error = new Error();
        error.title("Error");
        error.detail("Your request cannot be processed because there are required fields");

        List<ErrorDetail> errors = new ArrayList<>();
        for (FieldError err : ex.getFieldErrors()) {
            ErrorDetail detail = new ErrorDetail();
            detail.setMessage(err.getField() + " " + err.getDefaultMessage());
            errors.add(detail);
        }
        error.setErrors(errors);
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());

        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({ ConflictException.class })
    public ResponseEntity<Error> conflictException(ConflictException ex) {
        Error error = new Error();
        error.title("Error");
        error.detail(ex.getMessage());
        error.setErrors(Collections.emptyList());
        error.setStatus(HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}

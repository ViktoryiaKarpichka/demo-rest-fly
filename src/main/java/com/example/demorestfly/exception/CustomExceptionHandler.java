package com.example.demorestfly.exception;

import com.example.demorestfly.model.BaseResponse;
import com.example.demorestfly.model.ErrorValidationResponse;
import com.example.demorestfly.model.ExceptionResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.demorestfly.utils.ResponseUtils.*;

@Component
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<BaseResponse> handleException(BadCredentialsException exception) {
        ExceptionResponse response = getExceptionResponse(
                HttpStatus.UNAUTHORIZED,
                BAD_CREDENTIALS_EXCEPTION_MESSAGE,
                exception
        );
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponse> handleException(AccessDeniedException exception) {
        ExceptionResponse response = getExceptionResponse(
                HttpStatus.FORBIDDEN,
                exception.getMessage(),
                exception
        );
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<BaseResponse> handleException(EntityNotFoundException exception) {
        ExceptionResponse response = getExceptionResponse(
                HttpStatus.NOT_FOUND,
                NOT_FOUND_EXCEPTION_MESSAGE,
                exception
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<BaseResponse> handleException(BookNotFoundException exception) {
        ExceptionResponse response = getExceptionResponse(
                HttpStatus.NOT_FOUND,
                BOOK_NOT_FOUND_EXCEPTION_MESSAGE,
                exception
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<BaseResponse> handleException(DataIntegrityViolationException exception) {
        ExceptionResponse response = getExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                DATA_INTEGRITY_VIOLATION_EXCEPTION_MESSAGE,
                exception
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataSourceLookupFailureException.class)
    private ResponseEntity<BaseResponse> handleException(DataSourceLookupFailureException exception) {
        ExceptionResponse response = getExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                DATA_SOURCE_LOOKUP_FAILURE_EXCEPTION_MESSAGE,
                exception
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    private ResponseEntity<BaseResponse> handleException(JpaObjectRetrievalFailureException exception) {
        ExceptionResponse response = getExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                JPA_OBJECT_RETRIEVAL_FAILURE_EXCEPTION_MESSAGE,
                exception
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<BaseResponse> handleException(HttpMessageNotReadableException exception) {
        ExceptionResponse response = getExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                HTTP_NOT_READABLE_EXCEPTION_MESSAGE,
                exception
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<BaseResponse> handleException(MethodArgumentNotValidException exception) {
        ErrorValidationResponse errorValidationResponse = new ErrorValidationResponse(
                HttpStatus.BAD_REQUEST,
                getErrorValidationMessages(exception),
                METHOD_ARGUMENT_NOT_VALID_EXCEPTION_MESSAGE
        );
        return new ResponseEntity<>(errorValidationResponse, HttpStatus.BAD_REQUEST);
    }
}

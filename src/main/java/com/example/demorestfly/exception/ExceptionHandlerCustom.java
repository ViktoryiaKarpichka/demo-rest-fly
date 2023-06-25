package com.example.demorestfly.exception;

import com.example.demorestfly.model.ExceptionResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionHandlerCustom {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ResponseEntity<ExceptionResponse> handleException(MethodArgumentTypeMismatchException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("Failed to convert value");
        response.setType(exception.getClass().getSimpleName());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalStateException.class)
    private ResponseEntity<ExceptionResponse> handleException(IllegalStateException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("Unknown exception");
        response.setType(exception.getClass().getSimpleName());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionResponse> handleException(NotFoundException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("Specify the entered data");
        response.setType(exception.getClass().getSimpleName());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFound.class)
    private ResponseEntity<ExceptionResponse> handleException(BookNotFound exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("The entered book is not listed in the database");
        response.setType(exception.getClass().getSimpleName());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    private ResponseEntity<ExceptionResponse> handleException(HttpRequestMethodNotSupportedException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("Request method is not supported");
        response.setType(exception.getClass().getSimpleName());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<ExceptionResponse> handleException(DataIntegrityViolationException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("The input data does not correspond to the required");
        response.setType(exception.getClass().getSimpleName());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    private ResponseEntity<ExceptionResponse> handleException(JpaObjectRetrievalFailureException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("The data entered violates the established requirements");
        response.setType(exception.getClass().getSimpleName());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<ExceptionResponse> handleException(HttpMessageNotReadableException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("The entered data is incorrect and leads to an error");
        response.setType(exception.getClass().getSimpleName());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

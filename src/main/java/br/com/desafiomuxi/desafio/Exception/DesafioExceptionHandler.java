package br.com.desafiomuxi.desafio.Exception;

import br.com.desafiomuxi.desafio.model.dto.ErrorDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class DesafioExceptionHandler {

    @ExceptionHandler (value = { ConstraintViolationException.class })
    protected ResponseEntity<ErrorDto> handleConflict(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorDto(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (value = { DataIntegrityViolationException.class })
    protected ResponseEntity<ErrorDto> handleDataIntegrity(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<ErrorDto>(new ErrorDto("Terminal insertion error. You are violating constraint database"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (value = { NotFoundException.class })
    protected ResponseEntity<ErrorDto> HandleNotFound(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<ErrorDto>(new ErrorDto("Terminal not found. =p"), HttpStatus.NOT_FOUND);
    }
}
package demo.ipConsulting.controller;

import demo.ipConsulting.exception.IPAddressException;
import demo.ipConsulting.model.entity.common.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MainExceptionHandler {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(Exception.class)
    public ErrorResponse genericException(final Exception e) {
        return ErrorResponse.builder()
                .errorType("Generic error")
                .description(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(IPAddressException.class)
    public ErrorResponse handleIPAddressException(final IPAddressException e) {
        return ErrorResponse.builder()
                .errorType("There was an unexpected error")
                .description(e.getMessage())
                .build();
    }
}

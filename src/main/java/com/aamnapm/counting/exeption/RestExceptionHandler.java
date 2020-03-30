package com.aamnapm.counting.exeption;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@Order(Ordered.HIGHEST_PRECEDENCE)
//@ControllerAdvice
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    protected Logger logger = LoggerFactory.getLogger(getClass());


    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(notFoundException.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler({ConflictException.class})
    protected ResponseEntity<Object> handleConflictException(ConflictException conflictException) {
        ApiError apiError = new ApiError(CONFLICT);
        apiError.setMessage(conflictException.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler({RunTimeException.class})
    protected ResponseEntity<Object> handleInternalServerErrorException(RunTimeException runTimeException) {
        ApiError apiError = new ApiError(INTERNAL_SERVER_ERROR);
        apiError.setMessage(runTimeException.getMessage());
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}

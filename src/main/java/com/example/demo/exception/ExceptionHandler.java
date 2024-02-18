package com.example.demo.exception;

import com.example.demo.controller.FreelancerController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice(assignableTypes = {FreelancerController.class})
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({AuthenticationException.class})
    ResponseEntity<ErrorResponse> handleConstraintViolationException(AuthenticationException e) {

        return new ResponseEntity<>(
                new ErrorResponse(e.getMessage()),
                e.getHttpStatus()
        );
    }


}

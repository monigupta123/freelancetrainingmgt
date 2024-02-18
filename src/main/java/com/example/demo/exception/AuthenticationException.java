package com.example.demo.exception;

import com.example.demo.constants.ErrorCode;
import org.springframework.http.HttpStatus;

public class AuthenticationException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;

    public AuthenticationException(HttpStatus httpStatus,  String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

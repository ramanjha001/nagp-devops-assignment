package com.nagarro.nagp.userservice.exception;

public class UserException extends Exception {

    public UserException(String errorMessage) {
        super(errorMessage);
    }

    public UserException(String errorMessage, Exception exception) {
        super(errorMessage, exception);
    }
}

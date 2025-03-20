package com.user.restuser.exception;

public class UserExistEmailException extends RuntimeException {
    public UserExistEmailException(String message) {
        super(message);
    }

    public UserExistEmailException(String message, Throwable cause) {
        super(message, cause);
    }

}

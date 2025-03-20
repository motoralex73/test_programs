package com.user.restuser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler( value = {UserNotFoundException.class} )
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        UserException userException = new UserException(
                userNotFoundException.getMessage(),
                userNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userException, userException.getHttpStatus());
    }

    @ExceptionHandler( value = {UserExistEmailException.class} )
    public ResponseEntity<Object> handleUserExistEmailException(UserExistEmailException userExistEmailException) {
        UserException userException = new UserException(
                userExistEmailException.getMessage(),
                userExistEmailException.getCause(),
                HttpStatus.CONFLICT);
        return new ResponseEntity<>(userException, userException.getHttpStatus());
    }

}

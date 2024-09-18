package com.codelsoft.userservice.exception;

public class CustomException {

    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public class EmailAlreadyExistsException extends RuntimeException {
        public EmailAlreadyExistsException(String message) {
            super(message);
        }
    }

    public class NoUsersFoundException extends RuntimeException {
        public NoUsersFoundException(String message) {
            super(message);
        }
    }
}


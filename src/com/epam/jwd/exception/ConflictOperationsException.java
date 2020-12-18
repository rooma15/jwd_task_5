package com.epam.jwd.exception;

public class ConflictOperationsException extends RuntimeException{
    public ConflictOperationsException() {
        super();
    }

    public ConflictOperationsException(String message) {
        super(message);
    }
}

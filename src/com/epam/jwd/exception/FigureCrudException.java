package com.epam.jwd.exception;

public class FigureCrudException extends RuntimeException{
    public FigureCrudException() {
    }

    public FigureCrudException(String message) {
        super(message);
    }
}

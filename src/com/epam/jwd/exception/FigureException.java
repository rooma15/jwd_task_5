package com.epam.jwd.exception;

public class FigureException extends RuntimeException{
    public FigureException() {
        super();
    }

    public FigureException(String message) {
        super(message);
    }

    public FigureException(String message, Throwable cause) {
        super(message, cause);
    }

    public FigureException(Throwable cause) {
        super(cause);
    }
}

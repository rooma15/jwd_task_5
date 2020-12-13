package com.epam.jwd.exception;

public class FigureNotExistException extends FigureException{
    public FigureNotExistException() {
        super();
    }

    public FigureNotExistException(String message) {
        super(message);
    }
}

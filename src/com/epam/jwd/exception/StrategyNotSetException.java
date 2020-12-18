package com.epam.jwd.exception;

public class StrategyNotSetException extends StrategyException{
    public StrategyNotSetException() {
    }

    public StrategyNotSetException(String message) {
        super(message);
    }
}

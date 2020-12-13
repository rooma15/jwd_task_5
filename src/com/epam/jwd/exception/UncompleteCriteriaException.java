package com.epam.jwd.exception;

public class UncompleteCriteriaException extends CriteriaException{
    public UncompleteCriteriaException() {
    }

    public UncompleteCriteriaException(String message) {
        super(message);
    }
}

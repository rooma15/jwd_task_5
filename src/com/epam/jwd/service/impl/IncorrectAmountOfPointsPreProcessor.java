package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.api.FigurePreProcessor;

public class IncorrectAmountOfPointsPreProcessor implements FigurePreProcessor {

    private IncorrectAmountOfPointsPreProcessor(){};

    private static IncorrectAmountOfPointsPreProcessor preProcessor;

    public static FigurePreProcessor getPreProcessor(){
        if(preProcessor == null){
            preProcessor = new IncorrectAmountOfPointsPreProcessor();
        }
        return preProcessor;
    }

    @Override
    public boolean process(FigureType type, Point... points) throws FigureException {
        if(points.length > 6){
            throw new FigureNotExistException("Incorrect amount of points");
        }
        return true;
    }

    @Override
    public String toString() {
        return "IncorrectAmountOfPointsPreProcessor";
    }
}

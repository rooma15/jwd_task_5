package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.api.FigurePreProcessor;

public final class FigureTypeMatchPreProcessor implements FigurePreProcessor {

    private FigureTypeMatchPreProcessor(){};

    private static FigureTypeMatchPreProcessor preProcessor;

    public static FigurePreProcessor getPreProcessor(){
        if(preProcessor == null){
            preProcessor = new FigureTypeMatchPreProcessor();
        }
        return preProcessor;
    }

    @Override
    public boolean process(FigureType type, Point... points) throws FigureException{
        if(type.getCountOfPoints() != points.length){
            throw new FigureNotExistException("type of figure and count of points does not match");
        }
        return true;
    }

    @Override
    public String toString() {
        return "FigureTypeMatchPreProcessor";
    }
}

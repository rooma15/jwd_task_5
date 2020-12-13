package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.api.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    private FigureExistencePostProcessor(){};
    private static FigureExistencePostProcessor postProcessor;

    public static FigurePostProcessor getPostProcessor(){
        if(postProcessor == null){
            postProcessor = new FigureExistencePostProcessor();
        }
        return postProcessor;
    }

    @Override
    public Figure process(Figure figure) throws FigureException {
        if(!figure.isPossibleToBuild()){
            throw new FigureNotExistException("Figure does not exist");
        }
        return figure;
    }

    @Override
    public String toString() {
        return "FigureExistencePostProcessor";
    }
}

package com.epam.jwd.decorator;

import com.epam.jwd.ProcessorStrorage.impl.FigurePreProcessorStorage;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.api.FigurePreProcessor;


public class PreProcessingFigureDecorator extends FigureFactoryDecorator{

    private final FigureFactory factory;
    private final FigurePreProcessorStorage processorStorage;
    public PreProcessingFigureDecorator(FigureFactory factory, FigurePreProcessorStorage storage){
        this.processorStorage = storage;
        this.factory = factory;
    }

    @Override
    public Figure createFigure(FigureType type, Point... points) throws FigureException {
        if(processorStorage != null){
            for(FigurePreProcessor processor: processorStorage){
                processor.process(type, points);
            }
        }
        return factory.createFigure(type, points);
    }
}

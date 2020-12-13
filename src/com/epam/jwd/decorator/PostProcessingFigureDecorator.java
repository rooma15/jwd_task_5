package com.epam.jwd.decorator;


import com.epam.jwd.ProcessorStrorage.impl.FigurePostProcessorStorage;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.api.FigurePostProcessor;

public class PostProcessingFigureDecorator extends FigureFactoryDecorator{

    private final FigureFactory factory;
    private final FigurePostProcessorStorage processorStorage;

    public PostProcessingFigureDecorator(FigureFactory factory, FigurePostProcessorStorage storage) {
        this.factory = factory;
        processorStorage = storage;
    }


    @Override
    public Figure createFigure(FigureType type, Point... points) throws FigureException {
        Figure figure = factory.createFigure(type, points);
        if(processorStorage != null){
            for(FigurePostProcessor processor : processorStorage){
                processor.process(figure);
            }
        }
        return figure;
    }
}

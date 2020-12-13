package com.epam.jwd.model;

import com.epam.jwd.ProcessorStrorage.impl.FigurePostProcessorStorage;
import com.epam.jwd.ProcessorStrorage.impl.FigurePreProcessorStorage;
import com.epam.jwd.decorator.PostProcessingFigureDecorator;
import com.epam.jwd.decorator.PreProcessingFigureDecorator;
import com.epam.jwd.exception.ProcessorStorageException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.service.impl.FigureTypeMatchPreProcessor;

public class FigureApplicationContext implements ApplicationContext {


    private static FigureApplicationContext context;
    private FigurePostProcessorStorage postProcessorStorage;
    private FigurePreProcessorStorage preProcessorStorage;

    private FigureApplicationContext(){
        postProcessorStorage = new FigurePostProcessorStorage();
        preProcessorStorage = new FigurePreProcessorStorage();

        try {
            postProcessorStorage.addProcessor(FigureExistencePostProcessor.getPostProcessor());
            preProcessorStorage.addProcessor(FigureTypeMatchPreProcessor.getPreProcessor());
        } catch (ProcessorStorageException e) {
            System.out.println(e.getMessage());
        }
    };

    @Override
    public void setPreProcessorStorage(FigurePreProcessorStorage storage) {
        preProcessorStorage = storage;
    }

    @Override
    public void setPostProcessorStorage(FigurePostProcessorStorage storage){
        postProcessorStorage = storage;
    }

    public static FigureApplicationContext getFigureApplicationContext(){
        if(context == null){
            context = new FigureApplicationContext();
        }
        return context;
    }


    @Override
    public FigureFactory createFigureFactory() {
        return new PreProcessingFigureDecorator(new PostProcessingFigureDecorator(new SimpleFigureFactory(), postProcessorStorage), preProcessorStorage);
    }
}

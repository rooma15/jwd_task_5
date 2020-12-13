package com.epam.jwd.ProcessorStrorage.impl;

import com.epam.jwd.ProcessorStrorage.api.PostProcessorStorage;
import com.epam.jwd.exception.ProcessorStorageException;
import com.epam.jwd.service.PostProcessorType;
import com.epam.jwd.service.api.FigurePostProcessor;

import java.util.ArrayList;
import java.util.Iterator;

public class FigurePostProcessorStorage implements PostProcessorStorage, Iterable<FigurePostProcessor> {

    private final ArrayList<FigurePostProcessor> postProcessors;
    private int amountOfProcessors;


    public FigurePostProcessorStorage(){
        amountOfProcessors = 0;
        postProcessors = new ArrayList<FigurePostProcessor>();
    }


    @Override
    public void deleteProcessor(PostProcessorType type) throws ProcessorStorageException {
        if(!postProcessors.removeIf(postProcessor -> postProcessor.toString().equals(type.toString()))) {
            throw new ProcessorStorageException("This processor is not in the storage");
        }else{
            amountOfProcessors--;
        }
    }

    @Override
    public void addProcessor(FigurePostProcessor postProcessor) throws ProcessorStorageException {
        if(!postProcessors.contains(postProcessor)){
            postProcessors.add(postProcessor);
            amountOfProcessors++;
        }else{
            throw new ProcessorStorageException("This processor is already in storage");
        }
    }

    @Override
    public Iterator<FigurePostProcessor> iterator() {
        return postProcessors.iterator();
    }
}

package com.epam.jwd.ProcessorStrorage.impl;

import com.epam.jwd.ProcessorStrorage.api.PreProcessorStorage;
import com.epam.jwd.exception.ProcessorStorageException;
import com.epam.jwd.service.PreProcessorType;
import com.epam.jwd.service.api.FigurePreProcessor;

import java.util.ArrayList;
import java.util.Iterator;

public class FigurePreProcessorStorage implements PreProcessorStorage, Iterable<FigurePreProcessor> {

    private final ArrayList<FigurePreProcessor> preProcessors;
    private int amountOfProcessors;


    public FigurePreProcessorStorage(){
        amountOfProcessors = 0;
        preProcessors = new ArrayList<FigurePreProcessor>();
    }


    @Override
    public void deleteProcessor(PreProcessorType type) throws ProcessorStorageException {
        if(!preProcessors.removeIf(preProcessor -> preProcessor.toString().equals(type.toString()))) {
            throw new ProcessorStorageException("This processor is not in the storage");
        }else{
            amountOfProcessors--;
        }
    }

    @Override
    public void addProcessor(FigurePreProcessor preProcessor) throws ProcessorStorageException {
        if(!preProcessors.contains(preProcessor)){
            preProcessors.add(preProcessor);
            amountOfProcessors++;
        }else{
            throw new ProcessorStorageException("This processor is already in storage");
        }
    }

    @Override
    public Iterator<FigurePreProcessor> iterator() {
        return preProcessors.iterator();
    }
}

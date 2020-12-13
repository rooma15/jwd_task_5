package com.epam.jwd.ProcessorStrorage.api;
import com.epam.jwd.exception.ProcessorStorageException;
import com.epam.jwd.service.PreProcessorType;
import com.epam.jwd.service.api.FigurePreProcessor;

public interface PreProcessorStorage {
    void deleteProcessor(PreProcessorType type) throws ProcessorStorageException;
    void addProcessor(FigurePreProcessor preProcessor) throws ProcessorStorageException;
}

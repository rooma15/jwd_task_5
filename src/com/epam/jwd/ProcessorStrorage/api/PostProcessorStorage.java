package com.epam.jwd.ProcessorStrorage.api;

import com.epam.jwd.exception.ProcessorStorageException;
import com.epam.jwd.service.PostProcessorType;
import com.epam.jwd.service.api.FigurePostProcessor;

public interface PostProcessorStorage {
    void deleteProcessor(PostProcessorType type) throws ProcessorStorageException;
    void addProcessor(FigurePostProcessor postProcessor) throws ProcessorStorageException;
}

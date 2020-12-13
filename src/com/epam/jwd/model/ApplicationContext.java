package com.epam.jwd.model;

import com.epam.jwd.ProcessorStrorage.impl.FigurePostProcessorStorage;
import com.epam.jwd.ProcessorStrorage.impl.FigurePreProcessorStorage;
import com.epam.jwd.factory.FigureFactory;

public interface ApplicationContext {
    FigureFactory createFigureFactory();
    void setPreProcessorStorage(FigurePreProcessorStorage storage);
    void setPostProcessorStorage(FigurePostProcessorStorage storage);
}

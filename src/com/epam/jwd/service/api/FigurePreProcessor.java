package com.epam.jwd.service.api;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public interface FigurePreProcessor {
    boolean process(FigureType type, Point... points) throws FigureException;
}

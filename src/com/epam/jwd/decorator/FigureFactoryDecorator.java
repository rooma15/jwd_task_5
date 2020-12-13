package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public abstract class FigureFactoryDecorator implements FigureFactory {
    @Override
    public abstract Figure createFigure(FigureType type, Point... points) throws FigureException;
}

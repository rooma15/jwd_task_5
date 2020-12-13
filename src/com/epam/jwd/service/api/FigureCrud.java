package com.epam.jwd.service.api;

import com.epam.jwd.service.impl.FigureStorage;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

import java.util.List;

public interface FigureCrud<T extends Figure> {
    T create(FigureFactory factory, FigureType type, Point... points) throws FigureException;
    List<T> multiCreate(FigureFactory factory, int quantity, FigureType type, Point... points) throws FigureException;
    void delete(int index);
    boolean find(T Figure);
    void update(T newFigure, int index);
    Figure findById(int index);
}

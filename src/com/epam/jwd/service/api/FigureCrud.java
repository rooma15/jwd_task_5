package com.epam.jwd.service.api;

import com.epam.jwd.service.impl.FigureStorage;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

import java.util.List;
import java.util.Optional;

public interface FigureCrud<T extends Figure> {
    T create(FigureType type, Point... points) throws FigureException;
    List<T> multiCreate(int quantity, FigureType type, Point... points) throws FigureException;
    void delete(int index);
    T find(int index);
    void update(T newFigure, int index);
    Optional<T> findById(int index);
}

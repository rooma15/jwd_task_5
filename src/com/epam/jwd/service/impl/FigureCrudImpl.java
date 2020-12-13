package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureCrudException;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;
import com.epam.jwd.service.api.FigureCrud;
import com.epam.jwd.strategy.SquareFirstStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FigureCrudImpl<T extends Figure> implements FigureCrud<T> {

    private FigureStorage<T> storage;

    public void setStorage(FigureStorage<T> storage){
        this.storage = storage;
    }

    @Override
    public T create(FigureFactory factory, FigureType type, Point... points) throws FigureException {
        if(storage == null){
            throw new FigureCrudException("Storage is not set");
        }
        return (T)factory.createFigure(type, points);
    }

    @Override
    public List<T> multiCreate(FigureFactory factory, int quantity, FigureType type, Point... points) throws FigureException {
        if(storage == null){
            throw new FigureCrudException("Storage is not set");
        }
        List<T> figures = new ArrayList<>();
        for(int i = 0; i < quantity; i++) {
            figures.add((T)factory.createFigure(type, points));
        }
        return figures;
    }

    @Override
    public void delete(int index) {
        if(storage == null){
            throw new FigureCrudException("Storage is not set");
        }
        storage.asList().remove(index);
    }

    @Override
    public boolean find(T figure) {
        if(storage == null){
            throw new FigureCrudException("Storage is not set");
        }
        return storage.asList().contains(figure);
    }

    @Override
    public void update(T newFigure, int index) {
        if(storage == null){
            throw new FigureCrudException("Storage is not set");
        }
        storage.asList().set(index, newFigure);
    }

    @Override
    public T findById(int index) {if(storage == null){
        throw new FigureCrudException("Storage is not set");
    }

        return storage.asList().get(index);
    }

    public List<T> findByCriteria(FigureCriteria criteria){
        if(storage == null){
            throw new FigureCrudException("Storage is not set");
        }
        return storage.asList().stream().filter((s) -> checkCriteria(s, criteria)).collect(Collectors.toList());
    }

    private boolean checkCriteria(T figure, FigureCriteria criteria){
        figure.setFigurePropertiesStrategy(SquareFirstStrategy.SQUARE_FIRST_STRATEGY);
        return figure.getFigureColor() == criteria.getFigureColor() &&
                figure.getType().equals(criteria.getFigureType().toString()) &&
                figure.execute() > criteria.getBottomSquareLimit();
    }
}

package com.epam.jwd.service.impl;

import com.epam.jwd.exception.ConflictOperationsException;
import com.epam.jwd.exception.FigureCrudException;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;
import com.epam.jwd.service.api.FigureCrud;
import com.epam.jwd.strategy.SquareFirstStrategy;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class FigureCrudImpl<T extends Figure> implements FigureCrud<T> {

    private FigureStorage<T> storage;
    private final FigureFactory factory;

    {
        factory = FigureApplicationContext.getFigureApplicationContext().createFigureFactory();
    }

    public void setStorage(FigureStorage<T> storage){
        this.storage = storage;
    }


    @Override
    public T create(FigureType type, Point... points) throws FigureException {
        if(storage == null){
            throw new FigureCrudException("Storage is not set");
        }
        T figure = (T)factory.createFigure(type, points);
        storage.add(figure);
        return figure;
    }

    @Override
    public List<T> multiCreate(int quantity, FigureType type, Point... points) throws FigureException {
        if(storage == null){
            throw new FigureCrudException("Storage is not set");
        }
        List<T> figures = new ArrayList<>();
        for(int i = 0; i < quantity; i++) {
            figures.add((T)factory.createFigure(type, points));
        }
        storage.addAll(figures);
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
    public T find(int index) {
        if(storage == null){
            throw new FigureCrudException("Storage is not set");
        }
        return storage.asList().get(index);
    }

    @Override
    public void update(T newFigure, int index) {
        if(storage == null){
            throw new FigureCrudException("Storage is not set");
        }
        if(newFigure != null){
            storage.asList().set(index, newFigure);
        }else throw new NullPointerException("New figure can not be null");
    }

    @Override
    public Optional<T> findById(int id) {
        if(storage == null){
        throw new FigureCrudException("Storage is not set");
        }
        for(T figure : storage) {
            if(figure.getId() == id){
                return Optional.of(figure);
            }
        }
        return Optional.empty();
    }

    public List<T> findByCriteria(FigureCriteria criteria){
        if(storage == null){
            throw new FigureCrudException("Storage is not set");
        }

        if(criteria == null){
            throw new NullPointerException("Criteria can not be null");
        }

        return storage.asList().stream().filter((s) -> checkCriteria(s, criteria)).collect(Collectors.toList());
    }

    private boolean checkCriteria(T figure, FigureCriteria criteria){
        figure.setFigurePropertiesStrategy(SquareFirstStrategy.SQUARE_FIRST_STRATEGY);
        List<Boolean> booleanList = new ArrayList<>();
        criteria.getBottomSquareLimit().ifPresent((limit) -> booleanList.add(limit < figure.execute()));
        criteria.getFigureType().ifPresent((figureType) -> booleanList.add(figureType == figure.getType()));
        criteria.getFigureColor().ifPresent((figureColor) -> booleanList.add(figureColor == figure.getFigureColor()));
        criteria.getFigureId().ifPresent((figureId) -> booleanList.add(figureId.equals(figure.getId())));
        criteria.getRangId().ifPresent((range) -> {
            if(criteria.getFigureId().isEmpty()){
                booleanList.add(figure.getId() >= range[0] && figure.getId() <= range[1]);
            }else{
                throw new ConflictOperationsException("There is conflict between setFigureId() and setIdRange()");
            }
        });
        for(Boolean concl : booleanList) {
            if(!concl){
                return false;
            }
        }
        return true;
    }
}

package com.epam.jwd.service.impl;

import com.epam.jwd.model.Figure;
import com.epam.jwd.service.api.Storage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FigureStorage<T extends Figure> implements Storage<T>, Iterable<T>{

    private final ArrayList<T> storage = new ArrayList<>();



    @Override
    public final void add(T figure) {
        for(T item : storage) {
            if(item.getId() != figure.getId()){
                storage.add(figure);
            }
        }
    }

    @Override
    public final void addAll(List<T> figures) {
        for(T figure : figures) {
            for(T storageFigure : storage) {
                if(storageFigure.getId() == figure.getId()){
                    break;
                }
            }
            storage.add(figure);
        }
    }

    @Override
    public List<T> asList() {
        return storage;
    }

    @Override
    public void insert(T figure, int index) {
        if(figure == null){
            throw new NullPointerException("figure can not be null");
        }
        storage.add(index, figure);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        int count = 1;
        for(T figure : storage) {
            str.append(count).append(": ").append(figure.toString()).append("\n");
            count++;
        }
        return str.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}

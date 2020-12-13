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
        storage.add((T)figure);
    }

    @Override
    public final void addAll(List<T> figures) {
        storage.addAll(figures);
    }

    @Override
    public List<T> asList() {
        return storage;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        int count = 1;
        for(T figure : storage) {
            str.append(count + ": " + figure.toString() + "\n");
            count++;
        }
        return str.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator() ;
    }
}

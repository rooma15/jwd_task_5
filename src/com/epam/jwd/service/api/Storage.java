package com.epam.jwd.service.api;

import com.epam.jwd.model.Figure;

import java.util.List;

public interface Storage<T extends Figure> {
    void add(T figure);
    void addAll(List<T> figures);
    List<T> asList();
}

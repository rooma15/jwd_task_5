package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;

public class SimpleFigureFactory implements FigureFactory{
    public Figure createFigure(FigureType type, Point... points) throws FigureException {
        Figure figure = null;
        switch (type){
            case Line:
                figure = new Line(points);
                break;
            case Triangle:
                figure = new Triangle(points);
                break;
            case Square:
                figure = new Square(points);
                break;
            case MultiAngle:
                figure = new MultiAngleFigure(points);
                break;
        }
        return figure;
    }
}

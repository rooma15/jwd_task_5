package com.epam.jwd.model;

public enum FigureType {
    Line(2), Triangle(3), Square(4), MultiAngle(5);

    private final int countOfPoints;

    FigureType(int countOfPoints) {
        this.countOfPoints = countOfPoints;
    }

    public int getCountOfPoints(){
        return countOfPoints;
    }
}

package com.epam.jwd.model;

public class FigureCriteria {
    private FigureType figureType;
    private Color figureColor;
    private double bottomSquareLimit;

    public FigureCriteria(FigureType figureType, Color figureColor, double bottomSquareLimit) {
        this.figureType = figureType;
        this.figureColor = figureColor;
        this.bottomSquareLimit = bottomSquareLimit;
    }

    public Color getFigureColor() {
        return figureColor;
    }

    public double getBottomSquareLimit() {
        return bottomSquareLimit;
    }

    public FigureType getFigureType(){
        return figureType;
    }
}

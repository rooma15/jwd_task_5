package com.epam.jwd.model;

import com.epam.jwd.exception.StrategyNotSetException;
import com.epam.jwd.strategy.Strategy;

public abstract class Figure {
    protected Point[] points;

    protected Color figureColor;

    protected final int id;

    protected FigureType type;

    private static int figureCount;

    static {
        figureCount = 1;
    }

    private Strategy figurePropertiesStrategy;

    Figure() {
        setFigureColor(Color.BLUE);
        figurePropertiesStrategy = null;
        id = figureCount++;
    }

    public final void setFigurePropertiesStrategy(Strategy strategy) {
        this.figurePropertiesStrategy = strategy;
    }

    public final double execute() {
        try {
            return figurePropertiesStrategy.calculate(this.points);
        } catch (NullPointerException e) {
            throw new StrategyNotSetException("you have to choose strategy before executing!");
        }
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }


    public abstract boolean pointsMatch();

    public abstract FigureType getType();

    public abstract boolean isPossibleToBuild();

    public void setFigureColor(Color figureColor) {
        this.figureColor = figureColor;
    }

    public Color getFigureColor() {
        return figureColor;
    }

    public int getId() {
        return id;
    }
}

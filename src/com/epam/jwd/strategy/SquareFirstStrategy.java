package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import com.epam.jwd.util.SquareCalculators;

public enum SquareFirstStrategy implements Strategy{
    SQUARE_FIRST_STRATEGY;
    @Override
    public double calculate(Point[] points) {
        return SquareCalculators.GaussFormula(points);
    }
}

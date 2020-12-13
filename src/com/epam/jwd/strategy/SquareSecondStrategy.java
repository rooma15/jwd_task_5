package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import com.epam.jwd.util.SquareCalculators;

public final class SquareSecondStrategy implements Strategy{
    private SquareSecondStrategy(){}

    private static final SquareSecondStrategy strategy = new SquareSecondStrategy();

    public static SquareSecondStrategy getStrategy(){
        return strategy;
    }

    @Override
    public double calculate(Point[] points) {
        System.out.println("You just calculated square with double integrals!!! Its another strategy!!!");
        return SquareCalculators.GaussFormula(points);
    }
}

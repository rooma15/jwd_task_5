package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;

public final class PerimeterStrategy implements Strategy{
    private PerimeterStrategy(){}

    private static PerimeterStrategy strategy;

    public static PerimeterStrategy getStrategy(){
        if(strategy == null){
            strategy = new PerimeterStrategy();
        }
        return strategy;
    }

    @Override
    public double calculate(Point[] points) {
        double result = 0;
        double catetX;
        double catetY;
        if(points.length < 3){
            catetX = Math.abs(points[0].getX() - points[1].getX());
            catetY = Math.abs(points[0].getY() - points[1].getY());
            return Math.hypot(catetX, catetY);
        }

        for(int i = 0; i < points.length - 1; i++) {
            catetX = Math.abs(points[i].getX() - points[i + 1].getX());
            catetY = Math.abs(points[i].getY() - points[i + 1].getY());
            result += Math.hypot(catetX, catetY);
        }

        catetX = Math.abs(points[points.length - 1].getX() - points[0].getX());
        catetY = Math.abs(points[points.length - 1].getY() - points[0].getY());
        result += Math.hypot(catetX, catetY);

        return result;
    }


}

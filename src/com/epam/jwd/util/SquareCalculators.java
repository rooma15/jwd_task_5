package com.epam.jwd.util;

import com.epam.jwd.model.Point;

public class SquareCalculators {
    public static double GaussFormula(Point[] points){
        if(points.length < 3){
            return 0;
        }
        double firstSum = 0;
        double result = 0;
        double secondSum = 0;
        for(int i = 0; i <= points.length - 2; i++) {
            firstSum += points[i].getX() * points[i + 1].getY();
        }

        result += firstSum;

        result += points[points.length - 1].getX() * points[0].getY();
        for(int i = 0; i <= points.length - 2; i++) {
            secondSum += points[i + 1].getX() * points[i].getY();
        }

        result -= secondSum;

        result -= points[0].getX() * points[points.length - 1].getY();
        return Math.abs(result / 2);
    }
}

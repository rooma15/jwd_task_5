package com.epam.jwd.model;

public class MultiAngleFigure extends Figure {

    MultiAngleFigure(Point[] points){
        this.points = points;
    }

    @Override
    public boolean pointsMatch() {
        int i = 0;
        int j;
        while(i < points.length - 1) {
            j = i + 1;
            while(j < points.length) {
                if(points[i].equals(points[j])) {
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }

    @Override
    public String getType() {
        return "MultiAngleFigure";
    }

    @Override
    public boolean isPossibleToBuild() {
        return !pointsMatch();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        for(int i = 0; i < points.length; i++) {
            string.append(String.format("{%1$d, %2$d}, ", points[i].getX(), points[i].getY()));
        }
        string.delete(string.length() - 2, string.length());
        string.append("}");
        string.append(String.format("Color = %1$s", getFigureColor()));
        return string.toString();
    }
}

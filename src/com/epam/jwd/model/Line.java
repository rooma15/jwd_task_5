package com.epam.jwd.model;


public class Line extends Figure {

    Line(){
        points = new Point[2];
        points[0] = new Point();
        points[1] = new Point();
    }

    Line(Point[] points){
        this.points = points;
    }


    @Override
    public boolean isPossibleToBuild() {
        return !pointsMatch();
    }


    public void setPoints(Point point1, Point point2){
        this.points[0] = point1;
        this.points[1] = point2;
    }

    @Override
    public boolean pointsMatch() {
        return points[0].equals(points[1]);
    }

    @Override
    public FigureType getType() {
        return FigureType.Line;
    }



    @Override
    public String toString() {
        return String.format("{{%1$d, %2$d}, {%3$d, %4$d}}, Color = %5$s",
                points[0].getX(),
                points[0].getY(),
                points[1].getX(),
                points[1].getY(),
                getFigureColor());
    }
}

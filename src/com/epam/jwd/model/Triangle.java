package com.epam.jwd.model;

public class Triangle extends Figure {

    Triangle(){
        points = new Point[3];
        points[0] = new Point();
        points[1] = new Point();
        points[2] = new Point();
    }

    Triangle(Point[] points){
        this.points = points;
    }


    public void setPoints(Point point1, Point point2, Point point3) {
        points[0] = point1;
        points[1] = point2;
        points[2] = point3;
    }

    @Override
    public boolean pointsMatch() {
        return (points[0].equals(points[1]) || points[0].equals(points[2]) || points[1].equals(points[2]));
    }

    @Override
    public boolean isPossibleToBuild(){
        double square = ((points[0].getX() - points[2].getX())*(points[1].getY() - points[2].getY()) - (points[1].getX() - points[2].getX())*(points[0].getY() - points[2].getY()));
        return square != 0;
    }

    @Override
    public FigureType getType() {
        return FigureType.Triangle;
    }

    @Override
    public String toString() {
        return String.format("{{%1$d, %2$d}, {%3$d, %4$d}, {%5$d, %6$d}}, Color = %7$s, id = %8$d",
                points[0].getX(),
                points[0].getY(),
                points[1].getX(),
                points[1].getY(),
                points[2].getX(),
                points[2].getY(),
                getFigureColor(),
                id);
    }
}

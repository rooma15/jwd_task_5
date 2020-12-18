package com.epam.jwd.app;


import com.epam.jwd.service.impl.FigureStorage;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;
import com.epam.jwd.model.ApplicationContext;
import com.epam.jwd.model.FigureApplicationContext;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.FigureCrudImpl;

import java.util.List;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        Point[] points = new Point[3];
        points[0] = new Point(1, 2);
        points[1] = new Point(3, 4);
        points[2] = new Point(1, 4);
        Point[] points2 = new Point[3];
        points2[0] = new Point(10, 20);
        points2[1] = new Point(30, 40);
        points2[2] = new Point(10, 40);
        ApplicationContext context = FigureApplicationContext.getFigureApplicationContext();

        FigureFactory factory = context.createFigureFactory();

        FigureStorage<Triangle> storage = new FigureStorage<>();

        FigureCrudImpl<Triangle> figureCrud = new FigureCrudImpl<>();

        figureCrud.setStorage(storage);

        try {
            figureCrud.multiCreate(3, FigureType.Triangle, points);
        } catch (FigureException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("before updating element:");
        System.out.println(storage);



        try {
            figureCrud.update((Triangle) factory.createFigure(FigureType.Triangle, points2), 1);
            Optional<Triangle> opt = figureCrud.findById(1);
            opt.ifPresent(triangle -> triangle.setFigureColor(Color.RED));
        } catch (FigureException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("after updating element:");
        System.out.println(storage);

        FigureCriteria.CriteriaBuilder builder = new FigureCriteria.CriteriaBuilder();
        builder.setFigureType(FigureType.Triangle).setBottomSquareLimit(0).setIdRange(1, 3);
        FigureCriteria criteria = builder.getCriteria();


        System.out.println("All sorted triangles:");
        List<Triangle> redTriangles = figureCrud.findByCriteria(criteria);
        for(Triangle triangle : redTriangles) {
            System.out.println(triangle);
        }
    }
}
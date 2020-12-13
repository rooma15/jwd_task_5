package com.epam.jwd.app;

import com.epam.jwd.CriteriaBuilder.CriteriaBuilder;
import com.epam.jwd.service.impl.FigureStorage;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;
import com.epam.jwd.model.ApplicationContext;
import com.epam.jwd.model.FigureApplicationContext;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.FigureCrudImpl;

import java.util.List;


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
                storage.addAll(figureCrud.multiCreate(factory, 3, FigureType.Triangle, points));
        } catch (FigureException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("before updating element:");
        System.out.println(storage);

        try {
            figureCrud.update(figureCrud.create(factory, FigureType.Triangle, points2), 1);
            figureCrud.findById(1).setFigureColor(Color.RED);
        } catch (FigureException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("after updating element:");
        System.out.println(storage);

        CriteriaBuilder builder = new CriteriaBuilder();
        builder.setFigureType(FigureType.Triangle).setFigureColor(Color.RED).setBottomSquareLimit(0);
        FigureCriteria criteria = builder.getCriteria();


        System.out.println("All red triangles:");
        List<Triangle> redTriangles = figureCrud.findByCriteria(criteria);
        for(Triangle triangle : redTriangles) {
            System.out.println(triangle);
        }
    }
}
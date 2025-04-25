package com.technogise.foundation;

import com.technogise.foundation.geometry.Point;
import com.technogise.foundation.geometry.Line;
import com.technogise.foundation.geometry.Quadrilateral;
import com.technogise.foundation.geometry.Square;
import com.technogise.foundation.geometry.Rectangle;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(1, 1);
        Point b = new Point(4, 5);

        Line line = new Line(a, b);

        System.out.println("Length of the Line: " + line.length());

        Point x = new Point(0, 0);
        Point y = new Point(3, 4);

        Line line2 = new Line(x, y);
        if (line2.isParallelTo(line)) {
            System.out.println("Line and Line2 are parallel.");
        }

        Point p = new Point(0, 0);
        Point q = new Point(-4, 3);

        Line line3 = new Line(p, q);
        if (line3.isPerpendicularTo(line2)) {
            System.out.println("Line2 and Line3 are perpendicular.");
        }

        System.out.println("---");

        System.out.println("\nLiskov Substitution Principle Demonstration:");
        
        Point s1 = new Point(0, 0);
        Point s2 = new Point(2, 0);
        Point s3 = new Point(2, 2);
        Point s4 = new Point(0, 2);
        
        Line sqLine1 = new Line(s1, s2);
        Line sqLine2 = new Line(s2, s3);
        Line sqLine3 = new Line(s3, s4);
        Line sqLine4 = new Line(s4, s1);
        
        Square square = new Square(sqLine1, sqLine2, sqLine3, sqLine4);
        
        Point r1 = new Point(0, 0);
        Point r2 = new Point(4, 0);
        Point r3 = new Point(4, 2);
        Point r4 = new Point(0, 2);
        
        Line rectLine1 = new Line(r1, r2);
        Line rectLine2 = new Line(r2, r3);
        Line rectLine3 = new Line(r3, r4);
        Line rectLine4 = new Line(r4, r1);
        
        Rectangle rectangle = new Rectangle(rectLine1, rectLine2, rectLine3, rectLine4);
        
        Quadrilateral[] shapes = {square, rectangle};
        
        for (Quadrilateral shape : shapes) {
            System.out.println("Shape perimeter: " + shape.calculatePerimeter());
            System.out.println("Shape area: " + shape.calculateArea());
            System.out.println("---");
        }
    }
}
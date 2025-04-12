package com.technogise.foundation;

import com.technogise.foundation.geometry.Point;
import com.technogise.foundation.geometry.Line;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(1, 1);
        Point b = new Point(4, 5);

        Line line = new Line(a, b);

        System.out.println("Length of line: " + line.length());

        Point x = new Point(0, 0);
        Point y = new Point(3, 4);

        Line line2 = new Line(x, y);
        if (line2.isParallelTo(line)) {
            System.out.println("line and line2 are parallel.");
        }

        Point p = new Point(0, 0);
        Point q = new Point(-4, 3);

        Line line3 = new Line(p, q);
        if (line3.isPerpendicularTo(line2)) {
            System.out.println("line2 and line3 are perpendicular.");
        }
    }
}
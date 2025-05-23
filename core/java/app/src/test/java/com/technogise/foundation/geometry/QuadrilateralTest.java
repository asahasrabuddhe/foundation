package com.technogise.foundation.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuadrilateralTest {
    @Test
    public void quadrilateralHasFourConnectedLines() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(4, 3);
        Point d = new Point(0, 3);

        Line ab = new Line(a, b);
        Line bc = new Line(b, c);
        Line cd = new Line(c, d);
        Line da = new Line(d, a);

        Quadrilateral quad = new Quadrilateral(ab, bc, cd, da);
    }

    @Test
    public void quadrilateralThrowsWithoutConnectedLines() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(4, 3);
        Point d = new Point(1, 4); // Not connected back to a

        Line ab = new Line(a, b);
        Line bc = new Line(b, c);
        Line cd = new Line(c, d);
        Line da = new Line(d, new Point(5, 5)); // Invalid endpoint

        assertThrows(IllegalArgumentException.class, () -> new Quadrilateral(ab, bc, cd, da));
    }

    @Test
    void perimeterCalculationShouldBeAccurate() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 0);
        Point c = new Point(3, 4);
        Point d = new Point(0, 4);

        Line ab = new Line(a, b);
        Line bc = new Line(b, c);
        Line cd = new Line(c, d);
        Line da = new Line(d, a);

        Quadrilateral quad = new Quadrilateral(ab, bc, cd, da);

        assertEquals(14.0, quad.calculatePerimeter());
    }

    @Test
    void areaMethodShouldThrowUnsupportedException() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(1, 1);
        Point d = new Point(0, 1);

        Quadrilateral quad = new Quadrilateral(
                new Line(a, b),
                new Line(b, c),
                new Line(c, d),
                new Line(d, a)
        );

        assertThrows(UnsupportedOperationException.class, quad::calculateArea);
    }

}

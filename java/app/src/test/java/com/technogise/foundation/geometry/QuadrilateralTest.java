package com.technogise.foundation.geometry;

import org.junit.jupiter.api.Test;

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
}

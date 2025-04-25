package com.technogise.foundation.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {
    @Test
    void validSquareShouldPass() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(2, 2);
        Point d = new Point(0, 2);

        Line ab = new Line(a, b);
        Line bc = new Line(b, c);
        Line cd = new Line(c, d);
        Line da = new Line(d, a);

        Square square = new Square(ab, bc, cd, da);

        assertEquals(4.0, square.calculateArea());
        assertEquals(8.0, square.calculatePerimeter());
    }

    @Test
    void unequalSidesShouldThrow() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 0);
        Point c = new Point(3, 2);
        Point d = new Point(0, 2);

        Line ab = new Line(a, b); // 3
        Line bc = new Line(b, c); // 2
        Line cd = new Line(c, d); // 3
        Line da = new Line(d, a); // 2

        assertThrows(IllegalArgumentException.class, () -> new Square(ab, bc, cd, da));
    }

    @Test
    void nonRightAngleShouldThrow() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(3, 2); // not at 90°
        Point d = new Point(0, 2);

        Line ab = new Line(a, b);
        Line bc = new Line(b, c);
        Line cd = new Line(c, d);
        Line da = new Line(d, a);

        // Should fail rectangle validation due to non-perpendicular sides
        assertThrows(IllegalArgumentException.class, () -> new Square(ab, bc, cd, da));
    }
}

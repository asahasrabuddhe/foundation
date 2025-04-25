package com.technogise.foundation.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void validRectangleShouldPass() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(4, 3);
        Point d = new Point(0, 3);

        Line ab = new Line(a, b);
        Line bc = new Line(b, c);
        Line cd = new Line(c, d);
        Line da = new Line(d, a);

        Rectangle rectangle = new Rectangle(ab, bc, cd, da);

        assertEquals(12.0, rectangle.calculateArea());
        assertEquals(14.0, rectangle.calculatePerimeter());
    }

    @Test
    void invalidRectangleShouldThrow() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(5, 3); // Slight misalignment
        Point d = new Point(0, 3);

        Line ab = new Line(a, b);
        Line bc = new Line(b, c);
        Line cd = new Line(c, d);
        Line da = new Line(d, a);

        assertThrows(IllegalArgumentException.class, () -> new Rectangle(ab, bc, cd, da));
    }
}

package com.technogise.foundation.geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.technogise.foundation.geometry.Point;

import org.junit.jupiter.api.Test;

class PointTest {
    @Test
    void pointHoldsCoordinates() {
        Point p = new Point(3, 4);
        assertEquals(3, p.x());
        assertEquals(4, p.y());
    }
}
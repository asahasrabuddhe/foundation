package com.technogise.foundation.geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LineTest {
    Point a;
    Point b;
    Line line;

    @BeforeEach
    void setup() {
        a = new Point(0, 0);
        b = new Point(3, 4);
        line = new Line(a, b);
    }

    @AfterEach
    void cleanup() {
        a = null;
        b = null;
        line = null;
    }

    @Test
    void runIsTheDifferenceBetweenXCoordinates() {
        double run = line.run();

        assertEquals(3, run);
    }


    @Test
    void riseIsTheDifferenceBetweenYCoodrinates() {
        double rise = line.rise();

        assertEquals(4, rise);
    }

    @Test 
    void lengthIsTheEuclideanDistanceBetweenTwoPoints() {
        double length = line.length();

        assertEquals(5, length);
    }

    @Test
    void slopeIsTheRatioOfRiseToRun() {
        double slope = line.rise() / line.run();

        assertEquals(4.0 / 3.0, slope);
    }

    @Test
    void parallelLinesHaveTheSameSlope() {
        Point x = new Point(1, 1);
        Point y =  new Point(4, 5);

        Line otherLine = new Line(x, y);

        double slope1 = line.slope();
        double slope2 = otherLine.slope();

        assertEquals(slope1, slope2);
    }


    @Test
    void perpendicularLinesHaveNegativeReciprocalSlopes() {
        Point x = new Point(0, 0);
        Point y = new Point(-4, 3);

        Line otherLine = new Line(x, y);
        
        double slope1 = line.slope();
        double slope2 = otherLine.slope();

        assertEquals(-1, slope1 * slope2);
    }

    @Test
    void horizontalAndVerticalLinesArePerpendicular() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0); // horizontal
        Point c = new Point(4, 3); // vertical

        Line ab = new Line(a, b);
        Line bc = new Line(b, c);

        assertTrue(ab.isPerpendicularTo(bc));
    }

}

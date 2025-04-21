package com.technogise.foundation.geometry;

public class Quadrilateral extends Shape{
    protected final Line ab, bc, cd, da;

    public Quadrilateral(Line ab, Line bc, Line cd, Line da) {
        if (!areLinesConnected(ab, bc, cd, da)) {
            throw new IllegalArgumentException("Lines must form a closed quadrilateral.");
        }
        this.ab = ab;
        this.bc = bc;
        this.cd = cd;
        this.da = da;
    }

    protected boolean areLinesConnected(Line... lines) {
        return lines[0].b().equals(lines[1].a()) &&
                lines[1].b().equals(lines[2].a()) &&
                lines[2].b().equals(lines[3].a()) &&
                lines[3].b().equals(lines[0].a());
    }

    @Override
    public double calculatePerimeter() {
        return ab.length() + bc.length() + cd.length() + da.length();
    }

    @Override
    public double calculateArea() {
        throw new UnsupportedOperationException("Quadrilateral calculate area is not implemented yet.");
    }
}

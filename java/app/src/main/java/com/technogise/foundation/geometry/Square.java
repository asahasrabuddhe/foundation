package com.technogise.foundation.geometry;

public class Square extends Quadrilateral {

    public Square(Line ab, Line bc, Line cd, Line da) {
        super(ab, bc, cd, da);
        validateSquare();
    }

    private void validateSquare() {
        double side = ab.length();
        if (bc.length() != side || cd.length() != side || da.length() != side) {
            throw new IllegalArgumentException("All sides must be equal in a square.");
        }
        if (!ab.isPerpendicularTo(bc) &&
                !bc.isPerpendicularTo(cd) &&
                !cd.isPerpendicularTo(da) &&
                !da.isPerpendicularTo(ab)) {
            throw new IllegalArgumentException("All sides must be equal in a square.");
        }
    }

    @Override
    public double calculateArea() {
        double side = ab.length();
        return side * side;
    }
}

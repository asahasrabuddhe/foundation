package com.technogise.foundation.geometry;


public class Rectangle extends Quadrilateral {

    public Rectangle(Line ab, Line bc, Line cd, Line da) {
        super(ab, bc, cd, da);
        validateRectangle();
    }

    private void validateRectangle() {
        if (!ab.isPerpendicularTo(bc) ||
                !bc.isPerpendicularTo(cd) ||
                !cd.isPerpendicularTo(da) ||
                !da.isPerpendicularTo(ab)) {
            throw new IllegalArgumentException("Rectangle sides must be perpendicular.");
        }

        if (!(ab.length() == cd.length()) || !(bc.length() == da.length())) {
            throw new IllegalArgumentException("Opposite sides must be equal.");
        }
    }

    @Override
    public double calculateArea() {
        return ab.length() * bc.length(); // Assuming right angle between ab and bc
    }
}

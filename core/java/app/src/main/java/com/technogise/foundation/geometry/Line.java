package com.technogise.foundation.geometry;

public record Line(Point a, Point b) {
    public double run() {
        return b.x() - a.x();
    }

    public double rise() {
        return b.y() - a.y();
    }

    public double length() {
        double dx = run();
        double dy = rise();

        return Math.sqrt(dx*dx + dy*dy);
    }

    public double slope() {
        return rise() / run();
    }

    public boolean isParallelTo(Line other) {
        return this.slope() == other.slope();
    }

    public boolean isPerpendicularTo(Line other) {
        double slope1 = this.slope();
        double slope2 = other.slope();

        // Handle horizontal vs vertical case
        if ((Double.isInfinite(slope1) && slope2 == 0.0) ||
                (Double.isInfinite(slope2) && slope1 == 0.0)) {
            return true;
        }

        // General case
        return Math.abs(slope1 * slope2 + 1) < 1e-9;
    }
}
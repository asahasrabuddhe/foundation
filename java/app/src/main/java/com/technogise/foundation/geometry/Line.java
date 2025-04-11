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
        return this.slope() * other.slope() == -1;
    }
}
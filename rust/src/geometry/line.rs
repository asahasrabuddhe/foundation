use super::point::Point;

pub struct Line {
    pub start: Point,
    pub end: Point,
}

impl Line {
    pub fn rise(&self) -> f64 {
        self.end.y - self.start.y
    }

    pub fn run(&self) -> f64 {
        self.end.x - self.start.x
    }

    pub fn length(&self) -> f64 {
        (self.rise().powi(2) + self.run().powi(2)).sqrt()
    }

    pub fn slope(&self) -> f64 {
        if self.run() == 0.0 {
            f64::INFINITY
        } else {
            self.rise() / self.run()
        }
    }

    pub fn is_parallel_to(&self, other: &Line) -> bool {
        self.slope() == other.slope()
    }

    pub fn is_perpendicular_to(&self, other: &Line) -> bool {
        let slope1 = self.slope();
        let slope2 = other.slope();

        // Handle special cases for vertical and horizontal lines
        if slope1.is_infinite() && slope2 == 0.0 {
            return true;
        }
        if slope2.is_infinite() && slope1 == 0.0 {
            return true;
        }

        slope1 * slope2 == -1.0
    }
}

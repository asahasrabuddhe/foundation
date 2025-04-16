use super::point::Point;

pub struct Line {
    pub start: Point,
    pub end: Point,
}

impl Line {
    pub fn rise(&self) -> f64 {
        self.end.y - self.start.y
    }
}

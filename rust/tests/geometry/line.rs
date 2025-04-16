use crate::geometry::{line::Line, point::Point};

#[test]
fn test_line_calculate_rise() {
    let start = Point { x: 1.0, y: 2.0 };
    let end = Point { x: 3.0, y: 5.0 };
    let line = Line { start, end };
    
    assert_eq!(line.rise(), 3.0);
}

#[test]
fn test_line_calculate_run() {
    let start = Point { x: 1.0, y: 2.0 };
    let end = Point { x: 3.0, y: 5.0 };
    let line = Line { start, end };
    
    assert_eq!(line.run(), 2.0);
}

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

#[test]
fn test_line_calculate_length() {
    let start = Point { x: 0.0, y: 0.0 };
    let end = Point { x: 3.0, y: 4.0 };
    let line = Line { start, end };
    
    assert_eq!(line.length(), 5.0);
}

#[test]
fn test_line_calculate_slope() {
    let start = Point { x: 1.0, y: 2.0 };
    let end = Point { x: 3.0, y: 5.0 };
    let line = Line { start, end };
    
    assert_eq!(line.slope(), 1.5);
}

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

#[test]
fn test_line_is_parallel() {
    let start1 = Point { x: 1.0, y: 2.0 };
    let end1 = Point { x: 3.0, y: 5.0 };
    let line1 = Line { start: start1, end: end1 };

    let start2 = Point { x: 2.0, y: 3.0 };
    let end2 = Point { x: 4.0, y: 6.0 };
    let line2 = Line { start: start2, end: end2 };

    assert!(line1.is_parallel_to(&line2));
}

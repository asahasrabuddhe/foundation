mod geometry;

use geometry::line::Line;
use geometry::point::Point;

fn main() {
    // Create points
    let point1 = Point { x: 0.0, y: 0.0 };
    let point2 = Point { x: 3.0, y: 4.0 };
    
    // Create a line
    let line = Line {
        start: point1,
        end: point2,
    };

    println!("Length of the line is: {}", line.length());

    let x = Point { x: 0.0, y: 0.0 };
    let y = Point { x: 3.0, y: 4.0 };

    let line2 = Line {
        start: x,
        end: y,
    };

    if line2.is_parallel_to(&line) {
        println!("line and line2 are parallel.");
    }

    let p = Point { x: 0.0, y: 0.0 };
    let q = Point { x: -4.0, y: 3.0 };

    let line3 = Line {
        start: p,
        end: q,
    };

    if line3.is_perpendicular_to(&line) {
        println!("line2 and line3 are perpendicular.");
    }
}

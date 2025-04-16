use crate::geometry::Point;

#[test]
fn test_point_stores_coordinates() {
    let p = Point { x: 5.0, y: 10.0 };
    
    assert_eq!(p.x, 5.0);
    assert_eq!(p.y, 10.0);
}

package geometry

import (
	"testing"
)

func TestLine_CalculateRise(t *testing.T) {
	// Test that the rise (difference in y-coordinates) is calculated correctly

	p1 := Point{X: 1.0, Y: 2.0}
	p2 := Point{X: 3.0, Y: 5.0}

	l := Line{Start: p1, End: p2}
	expectedRise := 3.0 // 5.0 - 2.0

	if l.Rise() != expectedRise {
		t.Errorf("Expected rise to be %f, got %f", expectedRise, l.Rise())
	}
}

func TestLine_CalculateRun(t *testing.T) {
	// Test that the run (difference in x-coordinates) is calculated correctly

	p1 := Point{X: 1.0, Y: 2.0}
	p2 := Point{X: 3.0, Y: 5.0}

	l := Line{Start: p1, End: p2}
	expectedRun := 2.0 // 3.0 - 1.0

	if l.Run() != expectedRun {
		t.Errorf("Expected run to be %f, got %f", expectedRun, l.Run())
	}
}

func TestLine_CalculateLength(t *testing.T) {
	// Test that the length (distance between points) is calculated correctly

	p1 := Point{X: 0.0, Y: 0.0}
	p2 := Point{X: 3.0, Y: 4.0}

	l := Line{Start: p1, End: p2}
	expectedLength := 5.0 // Pythagorean theorem: sqrt(3^2 + 4^2)

	if l.Length() != expectedLength {
		t.Errorf("Expected length to be %f, got %f", expectedLength, l.Length())
	}
}

func TestLine_CalculateSlope(t *testing.T) {
	// Test that the slope (rise/run) is calculated correctly

	p1 := Point{X: 1.0, Y: 2.0}
	p2 := Point{X: 3.0, Y: 5.0}

	l := Line{Start: p1, End: p2}
	expectedSlope := 1.5 // 3.0 / 2.0

	if l.Slope() != expectedSlope {
		t.Errorf("Expected slope to be %f, got %f", expectedSlope, l.Slope())
	}
}

func TestLine_IsParallel(t *testing.T) {
	// Test that parallel lines have the same slope

	p1 := Point{X: 1.0, Y: 2.0}
	p2 := Point{X: 3.0, Y: 5.0}
	l1 := Line{Start: p1, End: p2}

	p3 := Point{X: 2.0, Y: 3.0}
	p4 := Point{X: 4.0, Y: 6.0}
	l2 := Line{Start: p3, End: p4}

	if !l1.IsParallelTo(l2) {
		t.Error("Expected lines to be parallel as they have the same slope")
	}
}

func TestLine_IsPerpendicular(t *testing.T) {
	// Test that perpendicular lines have slopes which are negative reciprocals

	p1 := Point{X: 1.0, Y: 2.0}
	p2 := Point{X: 3.0, Y: 5.0}
	l1 := Line{Start: p1, End: p2}

	p3 := Point{X: 2.0, Y: 3.0}
	p4 := Point{X: 4.0, Y: 1.0}
	l2 := Line{Start: p3, End: p4}

	if !l1.IsPerpendicularTo(l2) {
		t.Error("Expected lines to be perpendicular as their slopes are negative reciprocals")
	}
}

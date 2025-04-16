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

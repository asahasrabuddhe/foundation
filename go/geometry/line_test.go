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

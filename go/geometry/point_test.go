package geometry

import (
	"testing"
)

func TestPoint_StoresCoordinates(t *testing.T) {
	// Test that Point stores coordinates correctly

	x, y := 5.0, 10.0

	p := Point{
		X: x,
		Y: y,
	}

	if p.X != x {
		t.Errorf("Expected X coordinate to be %f, got %f", x, p.X)
	}

	if p.Y != y {
		t.Errorf("Expected Y coordinate to be %f, got %f", y, p.Y)
	}
}

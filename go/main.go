package main

import (
	"fmt"
	"foundation/geometry"
)

func main() {
	a, b := geometry.Point{X: 1.0, Y: 1.0}, geometry.Point{X: 4.0, Y: 5.0}
	line := geometry.Line{Start: a, End: b}

	fmt.Println("Length of the line is:", line.Length())

	x, y := geometry.Point{X: 0.0, Y: 0.0}, geometry.Point{X: 3.0, Y: 4.0}
	line2 := geometry.Line{Start: x, End: y}

	if line2.IsParallelTo(line) {
		fmt.Println("line and line2 are parallel.")
	}

	p, q := geometry.Point{X: 0.0, Y: 0.0}, geometry.Point{X: -4.0, Y: 3.0}
	line3 := geometry.Line{Start: p, End: q}

	if line3.IsPerpendicularTo(line) {
		fmt.Println("line and line3 are perpendicular.")
	}
}

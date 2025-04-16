package geometry

import "math"

type Line struct {
	Start Point
	End   Point
}

func (l Line) Rise() float64 {
	return l.End.Y - l.Start.Y
}

func (l Line) Run() float64 {
	return l.End.X - l.Start.X
}

func (l Line) Length() float64 {
	return math.Sqrt(l.Rise()*l.Rise() + l.Run()*l.Run())
}

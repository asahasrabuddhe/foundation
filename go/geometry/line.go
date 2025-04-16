package geometry

type Line struct {
	Start Point
	End   Point
}

func (l Line) Rise() float64 {
	return l.End.Y - l.Start.Y
}

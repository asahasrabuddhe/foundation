import { Point } from "./src/Point";
import { Line } from "./src/Line";

const a = new Point(1, 1);
const b = new Point(4, 5);

const line = new Line(a, b);

console.log((`Length of the line is: ${line.length}`));

const x = new Point(0, 0);
const y = new Point(3, 4);

const line2 = new Line(x, y);
line2.isParallelTo(line) ? console.log("line and line2 are parallel") : console.log("line and line2 are not parallel");

const p = new Point(0, 0);
const q = new Point(-4, 3);

const line3 = new Line(p, q);
line3.isPerpendicularTo(line) ? console.log("line and line3 are perpendicular") : console.log("line and line3 are not perpendicular");


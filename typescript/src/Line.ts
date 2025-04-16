import { Point } from './Point';

export class Line {
    constructor(public readonly a: Point, public readonly b: Point) {}

    get rise(): number {
        return this.b.y - this.a.y;
    }

    get run(): number {
        return this.b.x - this.a.x;
    }

    get length(): number {
        return Math.sqrt(this.rise ** 2 + this.run ** 2);
    }
}
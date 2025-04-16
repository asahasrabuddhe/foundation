import { Point } from './Point';

export class Line {
    constructor(public readonly a: Point, public readonly b: Point) {}

    get rise(): number {
        return this.b.y - this.a.y;
    }
}
import { test, expect } from 'bun:test';
import { Point } from '../src/Point';

test('Point coordinates are stored correctly', () => {
    const point = new Point(3, 4);
    expect(point.x).toBe(3);
    expect(point.y).toBe(4);
});
import { test, expect } from 'bun:test';
import { Line } from '../src/Line';
import { Point } from '../src/Point';

test('Rise of the line is calculated correctly', () => {
    const a = new Point(0, 0);
    const b = new Point(3, 4);

    const line = new Line(a, b);
    
    expect(line.rise).toBe(4);
});

test('Run of the line is calculated correctly', () => {
    const a = new Point(0, 0);
    const b = new Point(3, 4);

    const line = new Line(a, b);
    
    expect(line.run).toBe(3);
});

test('Length of the line is calculated correctly', () => {
    const a = new Point(0, 0);
    const b = new Point(3, 4);

    const line = new Line(a, b);
    
    expect(line.length).toBe(5);
});

test('Slope of the line is calculated correctly', () => {
    const a = new Point(0, 0);
    const b = new Point(3, 4);

    const line = new Line(a, b);
    
    expect(line.slope).toBe(4 / 3);
});

test('Parallel lines have the same slope', () => {
    const a1 = new Point(0, 0);
    const b1 = new Point(3, 4);
    const line1 = new Line(a1, b1);

    const a2 = new Point(0, 1);
    const b2 = new Point(3, 5);
    const line2 = new Line(a2, b2);

    expect(line1.isParallelTo(line2)).toBe(true);
});

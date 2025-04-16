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

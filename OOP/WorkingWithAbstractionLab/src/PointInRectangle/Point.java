package PointInRectangle;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean greaterOrEqual(Point p) {
       return p.x <= x && p.y <= y;
    }

    public boolean lessOrEqual(Point p) {
        return x <= p.x && y <= p.y;
    }
}
package shapes;

public class Line extends Shape {
    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2, String fill) {
        super(fill);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public String toSVG() {
        return String.format("<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"%s\" />", x1, y1, x2, y2, fill);
    }

    @Override
    public void translate(int dx, int dy) {
        x1 += dx;
        y1 += dy;
        x2 += dx;
        y2 += dy;
    }

    @Override
    public boolean isWithinRectangle(int rx, int ry, int rWidth, int rHeight) {
        return x1 >= rx && y1 >= ry && x2 <= (rx + rWidth) && y2 <= (ry + rHeight);
    }

    @Override
    public boolean isWithinCircle(int cx, int cy, int radius) {
        return distance(x1, y1, cx, cy) <= radius && distance(x2, y2, cx, cy) <= radius;
    }

    private double distance(int x, int y, int cx, int cy) {
        return Math.hypot(x - cx, y - cy);
    }

    @Override
    public String describe() {
        return String.format("line %d %d %d %d %s", x1, y1, x2, y2, fill);
    }
}

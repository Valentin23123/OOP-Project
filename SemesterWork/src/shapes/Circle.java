package shapes;

public class Circle extends Shape
{
    private int cx, cy, r;

    public Circle(int cx, int cy, int r, String fill) {

        super(fill);
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    @Override
    public String toSVG()
    {
        return String.format("<circle cx=\"%d\" cy=\"%d\" r=\"%d\" fill=\"%s\" />", cx, cy, r, fill);
    }

    @Override
    public void translate(int dx, int dy)
    {
        cx += dx;
        cy += dy;
    }

    @Override
    public boolean isWithinRectangle(int x, int y, int width, int height)
    {
        return (cx - r) >= x && (cy - r) >= y && (cx + r) <= (x + width) && (cy + r) <= (y + height);
    }

    @Override
    public boolean isWithinCircle(int cX, int cY, int radius)
    {
        return Math.hypot(cx - cX, cy - cY) + r <= radius;
    }

    @Override
    public String describe()
    {
        return String.format("circle %d %d %d %s", cx, cy, r, fill);
    }
}

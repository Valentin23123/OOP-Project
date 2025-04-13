package shapes;

public abstract class Shape
{
    protected String fill;

    public Shape(String fill)
    {
        this.fill = fill;
    }

    public abstract String toSVG();
    public abstract void translate(int dx, int dy);
    public abstract boolean isWithinRectangle(int x, int y, int width, int height);
    public abstract boolean isWithinCircle(int cx, int cy, int radius);
    public abstract String describe();
}

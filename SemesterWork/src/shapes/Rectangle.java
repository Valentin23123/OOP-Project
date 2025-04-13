package shapes;

public class Rectangle extends Shape
{
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height, String fill)
    {
        super(fill);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toSVG()
    {
        return String.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"%s\" />", x, y, width, height, fill);
    }

    @Override
    public void translate(int dx, int dy)
    {
        x += dx;
        y += dy;
    }

    @Override
    public boolean isWithinRectangle(int rx, int ry, int rWidth, int rHeight)
    {
        return x >= rx && y >= ry && (x + width) <= (rx + rWidth) && (y + height) <= (ry + rHeight);
    }

    @Override
    public boolean isWithinCircle(int cx, int cy, int radius)
    {
        double[] corners =
                {
                distance(x, y, cx, cy),
                distance(x + width, y, cx, cy),
                distance(x, y + height, cx, cy),
                distance(x + width, y + height, cx, cy)
        };

        for (double d : corners)
        {
            if (d > radius) return false;
        }
        return true;
    }

    private double distance(int x1, int y1, int x2, int y2)
    {
        return Math.hypot(x1 - x2, y1 - y2);
    }

    @Override
    public String describe()
    {

        return String.format("rectangle %d %d %d %d %s", x, y, width, height, fill);
    }
}

package shapes;
/**
 * Абстрактен базов клас, представляващ геометрична фигура.
 * Всеки наследник трябва да предоставя SVG представяне, транслация и проверки за принадлежност.
 */
public abstract class Shape {
    protected String fill;

    public Shape(String fill) {
        this.fill = fill;
    }

    public abstract String toSVG();
    public abstract void translate(int dx, int dy);
    public abstract boolean isWithinRectangle(int x, int y, int width, int height);
    public abstract boolean isWithinCircle(int cx, int cy, int radius);
    public abstract String describe();
}

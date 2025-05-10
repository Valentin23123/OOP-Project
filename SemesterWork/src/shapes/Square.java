package shapes;

public class Square extends Rectangle {

    public Square(int x, int y, int size, String fill) {
        super(x, y, size, size, fill);
    }

    @Override
    public String toSVG() {
        return super.toSVG();
    }

    @Override
    public String describe() {
        return String.format("square %d %d %d %s", x, y, width, fill);
    }
}

import shapes.*;
import java.util.*;
import java.io.IOException;

public class SVGEditor {
    private List<Shape> shapes = new ArrayList<>();
    private String currentFile = null;

    public void open(String filename) throws Exception {
        shapes = SVGParser.load(filename);
        currentFile = filename;
        System.out.println("Successfully opened " + filename);
    }

    public void print() {
        for (int i = 0; i < shapes.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, shapes.get(i).describe());
        }
    }

    public void create(String[] tokens) {
        try {
            String type = tokens[1];
            Shape shape = null;
            switch (type) {
                case "rectangle":
                    shape = new Rectangle(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
                    break;
                case "circle":
                    shape = new Circle(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]), tokens[5]);
                    break;
            }
            if (shape != null) {
                shapes.add(shape);
                System.out.println("Successfully created " + type + " (" + shapes.size() + ")");
            }
        } catch (Exception e) {
            System.out.println("Invalid create command.");
        }
    }

    public void erase(int index) {
        if (index < 1 || index > shapes.size()) {
            System.out.println("There is no figure number " + index + "!");
        } else {
            Shape s = shapes.remove(index - 1);
            System.out.println("Erased a " + s.describe().split(" ")[0] + " (" + index + ")");
        }
    }

    public void translate(Integer index, int dx, int dy) {
        if (index == null) {
            for (Shape s : shapes) s.translate(dx, dy);
            System.out.println("Translated all figures");
        } else if (index >= 1 && index <= shapes.size()) {
            shapes.get(index - 1).translate(dx, dy);
            System.out.println("Translated figure " + index);
        } else {
            System.out.println("Invalid index for translate.");
        }
    }

    public void within(String[] tokens) {
        try {
            String type = tokens[1];
            List<Shape> found = new ArrayList<>();
            if (type.equals("rectangle")) {
                int x = Integer.parseInt(tokens[2]), y = Integer.parseInt(tokens[3]),
                        width = Integer.parseInt(tokens[4]), height = Integer.parseInt(tokens[5]);
                for (int i = 0; i < shapes.size(); i++) {
                    if (shapes.get(i).isWithinRectangle(x, y, width, height))
                        found.add(shapes.get(i));
                }
            } else if (type.equals("circle")) {
                int cx = Integer.parseInt(tokens[2]), cy = Integer.parseInt(tokens[3]),
                        r = Integer.parseInt(tokens[4]);
                for (int i = 0; i < shapes.size(); i++) {
                    if (shapes.get(i).isWithinCircle(cx, cy, r))
                        found.add(shapes.get(i));
                }
            }
            if (found.isEmpty()) System.out.println("No figures are located within " + type + "...");
            else {
                for (Shape s : found) System.out.println(s.describe());
            }
        } catch (Exception e) {
            System.out.println("Invalid within command.");
        }
    }

    public void save() throws IOException {
        if (currentFile != null) {
            SVGParser.save(currentFile, shapes);
            System.out.println("Successfully saved the changes to " + currentFile);
        }
    }

    public void saveAs(String newFile) throws IOException {
        SVGParser.save(newFile, shapes);
        System.out.println("Successfully saved as " + newFile);
    }
}

import shapes.*;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class SVGParser {
    public static List<Shape> load(String filename) throws Exception {
        List<Shape> shapes = new ArrayList<>();
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(filename));
        NodeList nodes = doc.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            if (!(nodes.item(i) instanceof Element)) continue;
            Element el = (Element) nodes.item(i);

            switch (el.getTagName()) {
                case "rect":
                    shapes.add(new Rectangle(
                            Integer.parseInt(el.getAttribute("x")),
                            Integer.parseInt(el.getAttribute("y")),
                            Integer.parseInt(el.getAttribute("width")),
                            Integer.parseInt(el.getAttribute("height")),
                            el.getAttribute("fill")
                    ));
                    break;
                case "circle":
                    shapes.add(new Circle(
                            Integer.parseInt(el.getAttribute("cx")),
                            Integer.parseInt(el.getAttribute("cy")),
                            Integer.parseInt(el.getAttribute("r")),
                            el.getAttribute("fill")
                    ));
                    break;
                case "line":
                    shapes.add(new Line(
                            Integer.parseInt(el.getAttribute("x1")),
                            Integer.parseInt(el.getAttribute("y1")),
                            Integer.parseInt(el.getAttribute("x2")),
                            Integer.parseInt(el.getAttribute("y2")),
                            el.getAttribute("stroke")
                    ));
                    break;

            }
        }
        return shapes;
    }

    public static void save(String filename, List<Shape> shapes) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("<?xml version=\"1.0\" standalone=\"no\"?>");
            writer.println("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\"");
            writer.println("  \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
            writer.println("<svg width=\"500\" height=\"300\" xmlns=\"http://www.w3.org/2000/svg\">");
            for (Shape shape : shapes) {
                writer.println("  " + shape.toSVG());
            }
            writer.println("</svg>");
        }
    }
}

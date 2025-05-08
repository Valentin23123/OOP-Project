import java.util.Scanner;
//https://www.svgviewer.dev/
public class Main {
    public static void main(String[] args) {
        SVGEditor editor = new SVGEditor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] tokens = input.trim().split("\\s+");

            try {
                switch (tokens[0]) {
                    case "open": editor.open(tokens[1]); break;
                    case "print": editor.print(); break;
                    case "create": editor.create(tokens); break;
                    case "erase": editor.erase(Integer.parseInt(tokens[1])); break;
                    case "translate":
                        Integer index = null;
                        int dx = 0, dy = 0;
                        for (String t : tokens) {
                            if (t.startsWith("vertical=")) dy = Integer.parseInt(t.split("=")[1]);
                            else if (t.startsWith("horizontal=")) dx = Integer.parseInt(t.split("=")[1]);
                            else if (!t.equals("translate")) index = Integer.parseInt(t);
                        }
                        editor.translate(index, dx, dy); break;
                    case "within": editor.within(tokens); break;
                    case "save": editor.save(); break;
                    case "saveas": editor.saveAs(tokens[1]); break;
                    case "help":
                        System.out.println("Available commands:");
                        System.out.println("  open <filename>");
                        System.out.println("  print");
                        System.out.println("  create <shape> <params>");
                        System.out.println("  erase <index>");
                        System.out.println("  translate <index> horizontal=<dx> vertical=<dy>");
                        System.out.println("  within <shape> <params>");
                        System.out.println("  save");
                        System.out.println("  saveas <filename>");
                        System.out.println("  exit");
                        break;
                    case "exit": return;
                    default: System.out.println("Unknown command.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

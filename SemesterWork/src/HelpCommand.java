public class HelpCommand implements Command {
    @Override
    public void execute(String[] tokens, SVGEditor editor) {
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
    }
}

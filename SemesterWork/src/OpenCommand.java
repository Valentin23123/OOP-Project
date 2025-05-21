public class OpenCommand implements Command {
    @Override
    public void execute(String[] tokens, SVGEditor editor) {
        try {
            editor.open(tokens[1]);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

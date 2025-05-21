public class SaveAsCommand implements Command {
    @Override
    public void execute(String[] tokens, SVGEditor editor) {
        try {
            editor.saveAs(tokens[1]);
        } catch (Exception e) {
            System.out.println("Error saving as new file: " + e.getMessage());
        }
    }
}

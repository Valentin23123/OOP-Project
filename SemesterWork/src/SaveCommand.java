public class SaveCommand implements Command {
    @Override
    public void execute(String[] tokens, SVGEditor editor) {
        try {
            editor.save();
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

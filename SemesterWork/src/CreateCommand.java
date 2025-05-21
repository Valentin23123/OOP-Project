public class CreateCommand implements Command {
    @Override
    public void execute(String[] tokens, SVGEditor editor) {
        editor.create(tokens);
    }
}

public class WithinCommand implements Command {
    @Override
    public void execute(String[] tokens, SVGEditor editor) {
        editor.within(tokens);
    }
}

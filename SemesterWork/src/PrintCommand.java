public class PrintCommand implements Command {
    @Override
    public void execute(String[] tokens, SVGEditor editor) {
        editor.print();
    }
}

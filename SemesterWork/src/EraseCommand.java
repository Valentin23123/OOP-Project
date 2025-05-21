public class EraseCommand implements Command {
    @Override
    public void execute(String[] tokens, SVGEditor editor) {
        try {
            int index = Integer.parseInt(tokens[1]);
            editor.erase(index);
        } catch (Exception e) {
            System.out.println("Invalid erase command.");
        }
    }
}

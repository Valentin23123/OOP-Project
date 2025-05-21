public class TranslateCommand implements Command {
    @Override
    public void execute(String[] tokens, SVGEditor editor) {
        try {
            Integer index = null;
            int dx = 0, dy = 0;
            for (String t : tokens) {
                if (t.startsWith("vertical=")) {
                    dy = Integer.parseInt(t.split("=")[1]);
                } else if (t.startsWith("horizontal=")) {
                    dx = Integer.parseInt(t.split("=")[1]);
                } else if (!t.equals("translate")) {
                    index = Integer.parseInt(t);
                }
            }
            editor.translate(index, dx, dy);
        } catch (Exception e) {
            System.out.println("Invalid translate command.");
        }
    }
}

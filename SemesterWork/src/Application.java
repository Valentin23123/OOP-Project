import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Клас, управляващ командния интерфейс на приложението.
 * Регистрира всички поддържани команди и препраща изпълнението към SVGEditor.
 */
public class Application {
    private final Map<String, Command> commandMap = new HashMap<>();
    private final SVGEditor editor = new SVGEditor();

    public Application() {
        commandMap.put("open", new OpenCommand());
        commandMap.put("print", new PrintCommand());
        commandMap.put("create", new CreateCommand());
        commandMap.put("erase", new EraseCommand());
        commandMap.put("translate", new TranslateCommand());
        commandMap.put("within", new WithinCommand());
        commandMap.put("save", new SaveCommand());
        commandMap.put("saveas", new SaveAsCommand());
        commandMap.put("help", new HelpCommand());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] tokens = input.trim().split("\\s+");
            if (tokens.length == 0) continue;

            if (tokens[0].equals("exit")) return;

            Command command = commandMap.get(tokens[0]);
            if (command != null) {
                try {
                    command.execute(tokens, editor);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("Unknown command.");
            }
        }
    }
}

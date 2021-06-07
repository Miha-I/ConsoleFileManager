package ua.itea.app;

import ua.itea.command.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandHandler {

    private final Map<String, Command> registeredCommand;

    public CommandHandler() {
        registeredCommand = new HashMap<>();
    }

    public void registerCommand(String name, Command command) {
        registeredCommand.put(name, command);
    }

    public void execute(String inputString) {
        String[] arguments = inputString.split(" ", 2);
        if(arguments[0].equals("help")){
            System.out.println("Available command " + String.join(", ", registeredCommand.keySet()));
            return;
        }
        Command command = registeredCommand.get(arguments[0]);
        if (command != null) {
            arguments = arguments.length > 1 ? arguments[1].split(" ") : null;
            command.execute(arguments);
        } else {
            System.out.println("Not found command - " + arguments[0] + " , available command " + String.join(", ", registeredCommand.keySet()));
        }
    }
}

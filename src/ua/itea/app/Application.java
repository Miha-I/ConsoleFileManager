package ua.itea.app;

import ua.itea.command.*;
import ua.itea.util.FileUtils;

import java.util.Scanner;

public class Application {

    private final CommandHandler commandHandler;
    private boolean running;

    public Application() {
        commandHandler = new CommandHandler();
        commandHandler.registerCommand("copy", new CopyCommand());
        commandHandler.registerCommand("list", new ListCommand());
        commandHandler.registerCommand("print", new PrintCommand());
        commandHandler.registerCommand("rename", new RenameCommand());
        commandHandler.registerCommand("cd", new MoveCommand());
        running = true;
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        while (running) {
            System.out.println("Current dir - " + FileUtils.getCurrentPath());
            String inputString = input.nextLine();
            if (inputString.startsWith("exit")) {
                running = false;
            }
            commandHandler.execute(inputString);
        }
    }
}

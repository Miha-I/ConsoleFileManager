package ua.itea.command;

import ua.itea.util.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PrintCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (args != null && !args[0].isEmpty()) {
            Path file = Paths.get(FileUtils.getCurrentPath()).resolve(args[0]);
            if (Files.exists(file)) {
                try {
                    List<String> lines = Files.readAllLines(file);
                    for (String line : lines) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.getMessage();
                }
            } else {
                System.out.println("File '" + file.getFileName() + "' not exist");
            }
        }
    }
}

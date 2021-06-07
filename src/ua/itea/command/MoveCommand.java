package ua.itea.command;

import ua.itea.util.FileUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MoveCommand implements Command {

    @Override
    public void execute(String[] args) {
        if(args != null && !args[0].isEmpty()){
            Path path = Paths.get(args[0]);
            if(Files.isDirectory(path)){
                FileUtils.setCurrentPath(args[0]);
            } else {
                System.out.println("Directory '" + path.getFileName() + "' not exist");
            }
        }
    }
}

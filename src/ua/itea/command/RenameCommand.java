package ua.itea.command;

import ua.itea.util.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class RenameCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (args != null && (args.length == 2 || args.length == 3)) {
            Path oldFile = Paths.get(FileUtils.getCurrentPath()).resolve(args[args.length - 2]);
            if (Files.exists(oldFile)) {
                Path newFile = oldFile.resolveSibling(args[args.length - 1]);
                boolean isReplace = args.length == 3 && args[0].equals("-f");
                if (Files.exists(newFile) && !isReplace) {
                    String inputString;
                    Scanner input = new Scanner(System.in);
                    System.out.println("File " + newFile.toAbsolutePath().getFileName() + " already exist, replace file y(yes), n(noe)");
                    while (!(inputString = input.nextLine()).equals("y") && !inputString.equals("n")) {
                        System.out.println("Enter 'y' or 'n'");
                    }
                    isReplace = inputString.equals("y");
                }
                if(!Files.exists(newFile) || isReplace){
                    try {
                        Files.move(oldFile, newFile, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.getMessage();
                    }
                }
            } else {
                System.out.println("File '" + oldFile.getFileName() + "' not exist");
            }
        } else if (args != null && (args[0].equals("help") || args[0].equals("-h"))) {
            System.out.println("Available command [option] <old name> <new name>\n[option]\n\t-f - replace file");
        } else {
            System.out.println("Wrong command. Available command [option] <old name> <new name>\n[option]\n\t-f - replace file");
        }
    }
}
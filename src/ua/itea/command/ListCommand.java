package ua.itea.command;

import ua.itea.util.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ListCommand implements Command {

    @Override
    public void execute(String[] args) {
        try (Stream<Path> stream = Files.list(Paths.get(FileUtils.getCurrentPath()))) {
            stream
                    .peek(path -> {
                        if (Files.isDirectory(path)) {
                            System.out.println(path.getFileName());
                        }
                    })
                    .forEach(path -> {
                        if (!Files.isDirectory(path)) {
                            System.out.println(path.getFileName());
                        }
                    });
        } catch (IOException x) {
            x.getMessage();
        }
    }
}

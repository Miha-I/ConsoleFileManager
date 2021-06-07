package ua.itea.util;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static boolean setCurrentPath(String directoryName) {
        boolean result = false;
        File directory = new File(directoryName).getAbsoluteFile();
        if (directory.exists()) {
            try {
                result = System.setProperty("user.dir", directory.getCanonicalPath()) != null;
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return result;
    }

    public static String getCurrentPath() {
        return System.getProperty("user.dir");
    }
}

import FileManager.FileManager;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Folfer path: " + args[0]);
        File directory = new File(args[0]);

        List<File> allFiles = FileManager.getFilesFromDirectory(directory);

        File result = FileManager.concatFiles(allFiles, args[0]);
        System.out.println("Path of result file: " + result);
    }
}

package FileManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {
    public static List<File> getFilesFromDirectory(File root) {
        List<File> files = new ArrayList<>();
        if (root.isDirectory()) {
            File[] folderFiles = root.listFiles();
            if (folderFiles != null) {
                for (File file : folderFiles) {
                    if (file.isDirectory()) {
                        files.addAll(getFilesFromDirectory(file));
                    } else {
                        files.add(file);
                    }
                }
                return files.stream()
                            .sorted((f1, f2) -> f1.getName().compareTo(f2.getName()))
                            .collect(Collectors.toList());
            } else {
                return files;
            }
        } else {
            files.add(root);
            return files;
        }
    }

    public static File concatFiles (List<File> files, String resultFilePath) {
        File result = new File(resultFilePath + "\\result.txt");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(result));
            for (File file : files) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String sBuffer;
                while ((sBuffer = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(sBuffer);
                }
                bufferedWriter.write('\n');
                bufferedReader.close();
            }
            bufferedWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}

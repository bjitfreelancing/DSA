package javacode;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FileContent {
    public static List<File> findFilesOverSize(String path, long size) {
        List<File> resultFiles = new ArrayList<>();
        File directory = new File(path);
        findFilesOverSize(directory, size, resultFiles);
        return resultFiles;
    }

    public static List<File> findFilesWithExtension(String path, String extension) {
        List<File> resultFiles = new ArrayList<>();
        File directory = new File(path);
        findFilesWithExtension(directory, extension.toLowerCase(), resultFiles);
        return resultFiles;
    }

    private static void findFilesOverSize(File directory, long size, List<File> resultFiles) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile() && file.length() > size) {
                    resultFiles.add(file);
                } else {
                    findFilesOverSize(file, size, resultFiles);
                }
            }
        }
    }

    private static void findFilesWithExtension(File directory, String extension, List<File> resultFiles) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(extension)) {
                    resultFiles.add(file);
                } else {
                    findFilesWithExtension(file, extension, resultFiles);
                }
            }
        }
    }

    public static void main(String[] args) {
        String inputDirectory = "/Users/biswajit/Documents/Resume";
        long threshholdSize = 14000;
        String extension = "pdf";

        System.out.println("List of file under Directory: "+inputDirectory+ "for size over " +threshholdSize+" :: "
                +findFilesOverSize(inputDirectory, threshholdSize));
        System.out.println("List of file under Directory: "+inputDirectory+ "for extension " +extension+" :: "
                +findFilesWithExtension(inputDirectory, extension));
    }
}

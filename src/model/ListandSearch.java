
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ListandSearch {
      private static final Scanner sc = new Scanner(System.in);

    public int countWordInFile(String fileSource, String word) {
        FileReader fr = null;

        try {
            fr = new FileReader(fileSource);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while (line != null) {
                String[] parts = line.split(" ");
                for (String w : parts) {
                    if (w.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
                line = br.readLine();
            }
            return count;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }


    public void countWordInFile(){
        System.out.println("Enter Path: ");
        String path = sc.nextLine();
        System.out.println("Enter word: ");
        String word = sc.nextLine();
        int count = countWordInFile(path, word);
        System.out.println("Count: " + count);
    }
      public  void searchFilesContainingWord() {
        System.out.print("Enter the folder path: ");
        String folderPath = sc.nextLine();

        System.out.print("Enter the word to search: ");
        String wordToSearch = sc.nextLine();

        List<String> foundFiles = new ArrayList<>();
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            searchFilesInDirectory(folder, wordToSearch, foundFiles);
        } else {
            System.out.println("Folder not found.");
            return;
        }

        if (foundFiles.isEmpty()) {
            System.out.println("No files found containing the word '" + wordToSearch + "'.");
        } else {
            System.out.println("Files found containing the word '" + wordToSearch + "':");
            for (String fileName : foundFiles) {
                System.out.println(fileName);
            }
        }
    }

    public  void searchFilesInDirectory(File folder, String wordToSearch, List<String> foundFiles) {
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    if (containsWordInFile(file, wordToSearch)) {
                        foundFiles.add(file.getName());
                    }
                }
            }
        }
    }
    public  boolean containsWordInFile(File file, String wordToSearch) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                if (line.contains(wordToSearch)) {
                    fileScanner.close();
                    return true;
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return false;
    }
}

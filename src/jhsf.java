/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author son
 */
public class jhsf {
     public static void searchFilesContainingWord() {
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

    public static void searchFilesInDirectory(File folder, String wordToSearch, List<String> foundFiles) {
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

    public static boolean containsWordInFile(File file, String wordToSearch) {
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

package lockedmeapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class lockedmeapp {
    private static List<String> fileNames = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("********************************************");
        System.out.println("Welcome to LockedMe.com");
        System.out.println("Developer: [Arpit Singh]");
        System.out.println("********************************************");

        Scanner scanner = new Scanner(System.in);

        int option = 0;
        do {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Retrieve all file names (sorted)");
            System.out.println("2. Add a file");
            System.out.println("3. Delete a file");
            System.out.println("4. Search for a file");
            System.out.println("5. Close the application");

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume the invalid input
                continue;
            }

            switch (option) {
                case 1:
                    retrieveFileNames();
                    break;
                case 2:
                    addFile(scanner);
                    break;
                case 3:
                    deleteFile(scanner);
                    break;
                case 4:
                    searchFile(scanner);
                    break;
                case 5:
                    System.out.println("Closing the application...");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        } while (option != 5);

        scanner.close();
    }

    private static void retrieveFileNames() {
        if (fileNames.isEmpty()) {
            System.out.println("No files found.");
            return;
        }

        System.out.println("Retrieving all file names (sorted):");

        Collections.sort(fileNames);

        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    private static void addFile(Scanner scanner) {
        System.out.println("Enter the file name: ");
        String fileName = scanner.nextLine();

        if (fileName.trim().isEmpty()) {
            System.out.println("Invalid file name. Please enter a valid file name.");
            return;
        }

        if (fileNames.contains(fileName)) {
            System.out.println("File already exists.");
            return;
        }

        fileNames.add(fileName);
        System.out.println("File added successfully.");
    }

    private static void deleteFile(Scanner scanner) {
        System.out.println("Enter the file name to delete: ");
        String fileName = scanner.nextLine();

        if (fileName.trim().isEmpty()) {
            System.out.println("Invalid file name. Please enter a valid file name.");
            return;
        }

        if (fileNames.contains(fileName)) {
            fileNames.remove(fileName);
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("File not found.");
        }
    }

    private static void searchFile(Scanner scanner) {
        System.out.println("Enter the file name to search: ");
        String fileName = scanner.nextLine();

        if (fileName.trim().isEmpty()) {
            System.out.println("Invalid file name. Please enter a valid file name.");
            return;
        }

        int index = Collections.binarySearch(fileNames, fileName, String.CASE_INSENSITIVE_ORDER);

        if (index >= 0) {
            System.out.println("File found.");
        } else {
            System.out.println("File not found.");
        }
    }
}
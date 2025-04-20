import services.LibraryService;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📚 Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Edit Book");
            System.out.println("4. Read Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> LibraryService.addBook(scanner);
                case 2 -> LibraryService.viewBooks();
                case 3 -> LibraryService.editBook(scanner);
                case 4 -> LibraryService.readBook(scanner);
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}

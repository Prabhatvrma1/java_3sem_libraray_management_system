package services;

import model.Book;
import utils.FileManager;

import java.io.*;
import java.util.*;

public class LibraryService {
    public static void addBook(Scanner scanner) {
        System.out.print("Enter Book ID (number): ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        List<Book> books = FileManager.loadBooks();
        books.add(new Book(id, title, author, quantity));
        FileManager.saveBooks(books);
        System.out.println("✅ Book added.");
    }

    public static void viewBooks() {
        List<Book> books = FileManager.loadBooks();
        if (books.isEmpty()) {
            System.out.println("❌ No books found.");
            return;
        }
        books.forEach(System.out::println);
    }

    public static void editBook(Scanner scanner) {
        List<Book> books = FileManager.loadBooks();
        System.out.print("Enter Book ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == id) {
                System.out.print("New Title: ");
                book.setTitle(scanner.nextLine());
                System.out.print("New Author: ");
                book.setAuthor(scanner.nextLine());
                System.out.print("New Quantity: ");
                book.setQuantity(scanner.nextInt());
                FileManager.saveBooks(books);
                System.out.println("✅ Book updated.");
                return;
            }
        }

        System.out.println("❌ Book not found.");
    }

    public static void readBook(Scanner scanner) {
        System.out.print("Enter Book ID or Title to read: ");
        String input = scanner.nextLine().trim();

        String filePath = "book_contents/" + input + ".txt";
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("❓ Book content file not found.");
            return;
        }

        System.out.println("\n📖 Book Content:\n----------------------");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("\n----------------------\n");
        } catch (IOException e) {
            System.out.println("❌ Error reading book content: " + e.getMessage());
        }
    }
}

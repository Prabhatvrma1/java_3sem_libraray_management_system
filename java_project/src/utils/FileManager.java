package utils;

import model.Book;
import java.io.*;
import java.util.*;

public class FileManager {
    private static final String FILE_PATH = "books.dat";

    public static List<Book> loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Book>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveBooks(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("❌ Error saving books: " + e.getMessage());
        }
    }
}

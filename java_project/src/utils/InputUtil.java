package utils;

import java.util.Scanner;

public class InputUtil {
    public static int getChoice(Scanner sc) {
        System.out.print("Enter your choice: ");
        while (!sc.hasNextInt()) {
            System.out.println("❌ Invalid input. Please enter a number.");
            sc.next();
        }
        return sc.nextInt();
    }
}

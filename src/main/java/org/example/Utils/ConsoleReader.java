package org.example.Utils;

import java.util.Scanner;

/** Thin wrapper around {@link Scanner} that keeps the menu code readable. */
public class ConsoleReader implements AutoCloseable {

    private final Scanner scanner = new Scanner(System.in);

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public int readInt(String prompt) {
        while (true) {
            String input = readLine(prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    @Override
    public void close() {
        scanner.close();
    }
}

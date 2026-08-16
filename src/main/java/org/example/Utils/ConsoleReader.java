package org.example.Utils;

import java.io.Console;
import java.util.Scanner;

public class ConsoleReader implements AutoCloseable {

    private final Scanner scanner;

    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    public String readLine(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public int readInt(String message) {

        while (true) {

            System.out.print(message);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public String readPassword(String message) {

        Console systemConsole = System.console();

        if (systemConsole != null) {

            char[] password =
                    systemConsole.readPassword(message);

            if (password == null) {
                return "";
            }

            return new String(password);
        }

        // IntelliJ Run Console does not support hidden input.
        System.out.print(message);
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
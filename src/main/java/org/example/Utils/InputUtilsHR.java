package org.example.Utils;

import javax.swing.JOptionPane;

public final class InputUtilsHR {

    private InputUtilsHR() {
    }

    public static String readString(String message) {

        return JOptionPane.showInputDialog(
                null,
                message
        );
    }

    public static int readInt(String message) {

        while (true) {

            try {

                return Integer.parseInt(
                        readString(message)
                );

            } catch (Exception e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Enter a valid integer."
                );
            }
        }
    }

    public static double readDouble(String message) {

        while (true) {

            try {

                return Double.parseDouble(
                        readString(message)
                );

            } catch (Exception e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Enter a valid number."
                );
            }
        }
    }
}
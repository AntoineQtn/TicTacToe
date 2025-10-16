package org.example.game;

import java.util.Scanner;

public class UserInteraction {
    private final Scanner scanner = new Scanner(System.in);

    public String askForRepresentation() {
        while (true) {
            System.out.print("Welcome to TicTacToe! Please choose your representation (X or O): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("X") || input.equals("O")) {
                return input;
            } else {
                System.out.println("Invalid representation! Please type 'X' or 'O'.");
            }
        }
    }

    public int[] askForPosition() {
        try {
            System.out.print("Enter line position (0-2): ");
            int x = scanner.nextInt();
            System.out.print("Enter column position (0-2): ");
            int y = scanner.nextInt();
            return new int[]{x, y};
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter only numbers between 0 and 2.");
            scanner.nextLine();
            return askForPosition();
        }
    }
}

package org.example.display;

import java.util.Scanner;

public class UserInteraction {
    private final Scanner scanner = new Scanner(System.in);
    private final View view;

    public UserInteraction(View view) {
        this.view = view;
    }

//  Fonctionnalité à implémenter
//    public String askForRepresentation() {
//        while (true) {
//            view.displayMessage("Choose your representation (X or O): ");
//            String input = scanner.nextLine().trim().toUpperCase();
//            if (input.equals("X") || input.equals("O")) {
//                return input;
//            }
//            view.displayMessage("Invalid representation! Please type 'X' or 'O'.");
//        }
//    }

    public int[] askForPosition() {
        try {
            view.displayMessage("Enter line position (0-2): ");
            int x = scanner.nextInt();
            view.displayMessage("Enter column position (0-2): ");
            int y = scanner.nextInt();
            return new int[]{x, y};
        } catch (Exception e) {
            view.displayMessage("Invalid input! Please enter only numbers between 0 and 2.");
            scanner.nextLine();
            return askForPosition();
        }
    }
}

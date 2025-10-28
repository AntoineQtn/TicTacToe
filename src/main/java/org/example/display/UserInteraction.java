package org.example.display;


import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInteraction {
    private final Scanner scanner = new Scanner(System.in);
    private final View view;

    public UserInteraction(View view) {
        this.view = view;
    }

    public int displayMenu() {
        while (true) {
            try {
                view.displayMessage("Welcome! What game do you want to play?");
                view.displayMessage("1 - Tic Tac Toe");
                view.displayMessage("2 - Gomoku");
                view.displayMessage("3 - For In Row");
                int choice = scanner.nextInt();

                if (choice < 1 || choice > 3) {
                    throw new Exception("Please choose between 1 and 3 !");
                }
                return choice;

            } catch (InputMismatchException e) {
                scanner.nextLine();
                view.displayMessage("Invalid input! Please enter one of the following numbers.");
            } catch (Exception e) {
                view.displayMessage(e.getMessage());
            }
        }
    }


    public int[] askForPosition() {
        try {
            view.displayMessage("Enter line position : ");
            int x = scanner.nextInt();
            view.displayMessage("Enter column position : ");
            int y = scanner.nextInt();
            return new int[]{x, y};
        } catch (Exception e) {
            view.displayMessage("Invalid input! Please enter only numbers.");
            scanner.nextLine();
            return askForPosition();
        }
    }
}

package org.example;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public Menu(Scanner scanner){
        this.scanner = scanner;
    }

    public String askForRepresentation(){
        System.out.println("Welcome to TicTacToe ! Please choose your representation : X or O :");
        return scanner.nextLine();
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

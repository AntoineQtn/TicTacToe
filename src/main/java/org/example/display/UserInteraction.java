package org.example.display;

import org.example.controller.GameState;
import org.example.model.game.FourInRow;
import org.example.model.game.Game;
import org.example.model.game.Gomoku;
import org.example.model.game.TicTacToe;
import org.example.model.game.player.ArtificialPlayer;
import org.example.model.game.player.HumanPlayer;
import org.example.model.game.player.Player;

import java.util.Scanner;

public class UserInteraction {
    private final Scanner scanner = new Scanner(System.in);
    private final View view;

    public UserInteraction(View view) {
        this.view = view;
    }

    public int displayMenu(){


        view.displayMessage("Welcome! What game do you want to play?");
        view.displayMessage("1 - Tic Tac Toe");
        view.displayMessage("2 - Gomoku");
        view.displayMessage("3 - For In Row");

        return scanner.nextInt();
    }


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

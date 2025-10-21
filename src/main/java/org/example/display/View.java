package org.example.display;

import org.example.game.Cell;
import org.example.player.Player;

public class View {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayCell(String cell) {
        System.out.print(cell);
    }

    public void displayRowSeparator() {
        System.out.println("---+---+---");
    }

    public void displayNewLine() {
        System.out.println();
    }

    public void displayBoard(Cell[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                displayCell(board[i][j].getRepresentation());
                if (j < board[i].length - 1) displayCell("|");
            }
            displayNewLine();
            if (i < board.length - 1) displayRowSeparator();
        }
    }

    public void displayWinner(Player winner) {
        displayMessage("Player " + winner.getRepresentation() + " won!");
    }

    public void displayTurn(Player player) {
        displayMessage("Player " + player.getRepresentation() + ", it's your turn.");
    }

    public void displayDraw() {
        displayMessage("It's a draw!");
    }

    public void displayInvalidMove() {
        displayMessage("Invalid move! Try again.");
    }
}
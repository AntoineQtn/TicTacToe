package org.example.game;

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
        int size = board.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                displayCell(board[i][j].getRepresentation());
                if (j < size - 1) displayCell("|");
            }
            displayNewLine();
            if (i < size - 1) displayRowSeparator();
        }
    }

    public void displayWinner(Player winner) {
        displayMessage("Player " + winner.getRepresentation() + " won!");
    }

    public void displayDraw() {
        displayMessage("It's a draw!");
    }
}
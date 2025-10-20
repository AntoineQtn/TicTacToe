package org.example.game;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.player.Player;

public class FourInRow extends Game {

    public FourInRow(int size, Player player1, Player player2, UserInteraction userInteraction, View view) {
        super(size * (size + 1), new Player[]{player1, player2}, userInteraction, view);
    }

    public FourInRow(int size, Player player1, Player player2) {
        super(size * (size + 1), new Player[]{player1, player2}, new UserInteraction(new View()), new View());
    }

    @Override
    protected void setOwner(int x, int y, Player player) {
        for (int i = 1; i < getBoard(); i++) {
            if (getBoard()[x][y - 1] == "   ") {
                System.out.println("You can't place your pawn here");
            } else {
                getBoard()[x][y].setOwner(player);
            }
        }
        getBoard()[x][y].setOwner(player);
    }

    @Override
    protected void play(){
        int currentPlayerIndex = 0;
        view.displayMessage("Welcome to Four in Row!");

        while (!isOver()) {
            view.displayBoard(getBoard());
            Player currentPlayer = player[currentPlayerIndex];
            view.displayMessage("Player " + currentPlayer.getRepresentation() + ", it's your turn.");

            int[] move = currentPlayer.move(getBoard());
            setOwner(move[0], move[1], currentPlayer);

            if (isOver()) {
                view.displayBoard(getBoard());
                Player winner = getWinner();
                if (winner != null) {
                    view.displayWinner(winner);
                } else {
                    view.displayDraw();
                }
                return;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % player.length;
        }
        view.displayBoard(getBoard());
        view.displayDraw();
    }

    @Override
    protected boolean isOver() {
        // lignes
        for (int i = 0; i < size; i++) {
            if (!getBoard()[i][0].hasNoOwner() &&
                    getBoard()[i][0].getOwner() == getBoard()[i][1].getOwner() &&
                    getBoard()[i][1].getOwner() == getBoard()[i][2].getOwner()) {
                return true;
            }
        }

        // colonnes
        for (int j = 0; j < size; j++) {
            if (!getBoard()[0][j].hasNoOwner() &&
                    getBoard()[0][j].getOwner() == getBoard()[1][j].getOwner() &&
                    getBoard()[1][j].getOwner() == getBoard()[2][j].getOwner()) {
                return true;
            }
        }

        // diagonales
        if (!getBoard()[0][0].hasNoOwner() &&
                getBoard()[0][0].getOwner() == getBoard()[1][1].getOwner() &&
                getBoard()[1][1].getOwner() == getBoard()[2][2].getOwner()) {
            return true;
        }

        Cell[][] board;
        if (!getBoard()[0][2].hasNoOwner() &&
                getBoard()[0][2].getOwner() == getBoard()[1][1].getOwner() &&
                getBoard()[1][1].getOwner() == board[2][0].getOwner()) {
            return true;
        }

        // plateau plein
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].hasNoOwner()) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    protected Player getWinner() {
        for (int i = 0; i < size; i++) {
            if (!getBoard()[i][0].hasNoOwner() &&
                    getBoard()[i][0].getOwner() == getBoard()[i][1].getOwner() &&
                    getBoard()[i][1].getOwner() == getBoard()[i][2].getOwner()) {
                return getBoard()[i][0].getOwner();
            }
        }

        for (int j = 0; j < size; j++) {
            if (!getBoard()[0][j].hasNoOwner() &&
                    getBoard()[0][j].getOwner() == getBoard()[1][j].getOwner() &&
                    getBoard()[1][j].getOwner() == getBoard()[2][j].getOwner()) {
                return getBoard()[0][j].getOwner();
            }
        }

        if (!getBoard()[0][0].hasNoOwner() &&
                getBoard()[0][0].getOwner() == board[1][1].getOwner() &&
                board[1][1].getOwner() == board[2][2].getOwner()) {
            return board[0][0].getOwner();
        }

        if (!board[0][2].hasNoOwner() &&
                board[0][2].getOwner() == board[1][1].getOwner() &&
                board[1][1].getOwner() == board[2][0].getOwner()) {
            return board[0][2].getOwner();
        }

        return null;
    }

    @Override
    protected int getSize() {
        return size;
    }

    @Override
    protected Cell[][] getBoard() {
        return board;
    }

}

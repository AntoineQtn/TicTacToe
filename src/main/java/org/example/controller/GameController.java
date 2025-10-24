package org.example.controller;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.model.game.*;

import org.example.model.game.player.Player;

import java.util.Random;

public class GameController {

    private Game game;
    private View view;
    private UserInteraction ui;
    private GameFactory gameFactory;


    public GameController(Game game, View view, UserInteraction ui) {
        this.game = game;
        this.view = view;
        this.ui = ui;

    }


    public void play() {

        while (true) {
            displayBoard(game.getBoard());
            view.displayMessage("Player " + game.getCurrentPlayer().getRepresentation() + ", it's your turn.");

            int[] move = move(game.getBoard());
            int row = move[0];
            int col = move[1];

            game.setOwner(row, col, game.getCurrentPlayer());
            view.displayMessage("Player " + game.getCurrentPlayer().getRepresentation() + "put a pawn at (" + row + ", " + col + ").");

            if (game.hasWinner(game.getCurrentPlayer())) {
                displayBoard(game.getBoard());
                displayWinner(game.getCurrentPlayer());
                break;
            }

            if (game.isBoardFull()) {
                displayBoard(game.getBoard());
                view.displayDraw();
                break;
            }
            game.setCurrentPlayerIndex((game.getCurrentPlayerIndex() + 1) % game.getPlayers().length);
            game.setCurrentPlayer(game.getPlayers()[game.getCurrentPlayerIndex()]);
        }
    }

    public void displayWinner(Player winner) {
        view.displayMessage("Player " + winner.getRepresentation() + " won!");
    }

    public void displayBoard(Cell[][] board) {

        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                view.displayCell(board[i][j].getRepresentation());
                if (j < cols - 1) {
                    view.displayCell("|");
                }
            }
            view.displayNewLine();

            if (i < rows - 1) {
                view.displayRowSeparator(cols);
            }
        }
    }

    public int[] move(Cell[][] board) {
        if (game.getCurrentPlayer().getIsHuman()) {
            UserInteraction userInteraction = new UserInteraction(view);
            int[] move;
            while (true) {
                move = userInteraction.askForPosition();
                int x = move[0];
                int y = move[1];
                if (board[x][y].hasNoOwner()) {
                    break;
                } else {
                    view.displayOccupied();
                }
            }
            return move;
        } else {
            Random random = new Random();
            int size = board.length;
            int x, y;
            do {
                x = random.nextInt(size);
                y = random.nextInt(size);
            } while (!board[x][y].hasNoOwner());
            return new int[]{x, y};
        }
    }



}

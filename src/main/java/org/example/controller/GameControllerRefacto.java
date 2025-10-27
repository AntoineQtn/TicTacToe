package org.example.controller;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.model.game.*;
import org.example.model.game.player.Player;

import java.util.Random;


public class GameControllerRefacto {

    private Game game;
    private View view;
    private UserInteraction ui;

    private GameState gameState;


    public GameControllerRefacto(Game game, View view, UserInteraction ui) {
        this.game = game;
        this.view = view;
        this.ui = ui;
        this.gameState = GameState.INITIALIZE;
    }

    public void startGame() {
        System.out.println("Starting game");
        while (gameState != GameState.EXITGAME) {
            switch (gameState) {
//            case CHOOSE:
//                ui.displayMenu();
//                System.out.println(gameState);
//                gameState = GameState.INITIALIZE;
//            break;
                case INITIALIZE:
                    displayBoard(game.getBoard());
                    gameState = GameState.START;
                    break;
                case START:
                    play();
                    gameState = GameState.TURN;
                    break;
                case TURN:
                    move(game.getBoard());
                    gameState = GameState.DRAW;
                    break;
                case DRAW:
                    view.displayDraw();
                    break;
                case WIN:
                    displayWinner(game.getCurrentPlayer());
                    break;
                    case EXITGAME:
                        exitGame();
                        break;
                default:
                    gameState = GameState.EXITGAME;
            }
        }
    }

    public boolean play() {

        while (true) {
//            displayBoard(game.getBoard());
            view.displayMessage("Player " + game.getCurrentPlayer().getRepresentation() + ", it's your turn.");

            int[] move = move(game.getBoard());
            int row = move[0];
            int col = move[1];

            game.setOwner(row, col, game.getCurrentPlayer());
            view.displayMessage("Player " + game.getCurrentPlayer().getRepresentation() + "put a pawn at (" + row + ", " + col + ").");


            game.setCurrentPlayerIndex((game.getCurrentPlayerIndex() + 1) % game.getPlayers().length);
            game.setCurrentPlayer(game.getPlayers()[game.getCurrentPlayerIndex()]);

            if (getWinner()) {
                displayWinner(game.getCurrentPlayer());
                gameState = GameState.EXITGAME;
            } else if (getDraw()) {
                view.displayDraw();
                gameState = GameState.EXITGAME;

            } else return false;

        }
    }

    public boolean getWinner() {
        if (game.hasWinner(game.getCurrentPlayer())) {
//                displayBoard(game.getBoard());
//            displayWinner(game.getCurrentPlayer());
            System.out.println("win");
            return true;
        }
        System.out.println("win false");
        return false;
    }

    public boolean getDraw() {
        if (game.isBoardFull()) {
//                displayBoard(game.getBoard());
//            view.displayDraw();
            System.out.println("Draw");
            gameState = GameState.EXITGAME;
            return true;
        }
        System.out.println("Draw False");
        return false;
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
        displayBoard(game.getBoard());
        System.out.println("move");
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

    public void exitGame() {
        System.exit(0);
    }


}

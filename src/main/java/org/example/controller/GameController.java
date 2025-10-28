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
    private GameState gameState;


    public GameController(Game game, View view, UserInteraction ui) {
        this.game = game;
        this.view = view;
        this.ui = ui;
        this.gameState = GameState.INITIALIZE;
    }

    public void startGame() {
        System.out.println("Starting game");
        while (gameState != GameState.EXITGAME) {
            switch (gameState) {
                case INITIALIZE:
                    displayBoard(game.getBoard());
                    gameState = GameState.START;
                    break;
                case START:
                    play();
                    break;
                case DRAW:
                    view.displayDraw();
                    gameState = GameState.EXITGAME;
                    break;
                case WIN:
                    displayWinner(game.getCurrentPlayer());
                    gameState = GameState.EXITGAME;
                    break;
            }
        }
        System.out.println("Ending game");
    }

    public void play() {

        while (gameState == GameState.START) {
            view.displayMessage("Player " + game.getCurrentPlayer().getRepresentation() + ", it's your turn.");

            int[] move = move(game.getBoard());
            int row = move[0];
            int col = move[1];


            game.setOwner(row, col, game.getCurrentPlayer());
            view.displayMessage("Player " + game.getCurrentPlayer().getRepresentation() + "put a pawn at (" + row + ", " + col + ").");

            displayBoard(game.getBoard());

            if(game.hasWinner(game.getCurrentPlayer())) {
                gameState = GameState.WIN;
                break;
            }

            if(game.isBoardFull()){
                gameState = GameState.DRAW;
                break;
            }
            game.setCurrentPlayerIndex((game.getCurrentPlayerIndex() + 1) % game.getPlayers().length);
            game.setCurrentPlayer(game.getPlayers()[game.getCurrentPlayerIndex()]);

        }
    }

    /**
     * Method that use the displayMessage method from View to print the winning player.
     * @param winner
     */
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

    public String displayError(){
    return "Please enter numbers superior to 0 and inferior to " +
            game.getRows()+" for the rows and, for the cols, inferior to " +game.getCols();
    }

    public int[] move(Cell[][] board) {
        while (true) {
            try {
                if (game.getCurrentPlayer().getIsHuman()) {
                    UserInteraction userInteraction = new UserInteraction(view);
                    int[] move;
                    while (true) {
                        displayBoard(game.getBoard());

                        move = userInteraction.askForPosition();
                        int x = move[0];
                        if (x > game.getRows() || x < 0) {
                            throw new Exception(displayError());
                        }
                        int y = move[1];
                        if (y > game.getCols() || y < 0) {
                            throw new Exception(displayError());
                        }
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
            } catch (Exception e) {
                view.displayMessage(e.getMessage());
            }
        }
    }
}

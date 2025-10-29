package org.example.model.game.playablegame;

import org.example.controller.Game;
import org.example.view.UserInteraction;
import org.example.view.View;
import org.example.model.player.Player;

/**
 * Model class for the Gomoku game.
 */
public class Gomoku extends Game {
    private int rows;
    private int cols;

    public Gomoku(int rows, int cols, Player player1, Player player2, int winningPawn) {
        super(rows, cols, new Player[]{player1, player2}, 5);
        this.rows = rows;
        this.cols = cols;
        this.view = new View();
        this.userInteraction = new UserInteraction(view);
        initializeBoard();
    }
}

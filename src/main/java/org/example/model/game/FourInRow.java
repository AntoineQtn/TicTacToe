package org.example.model.game;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.model.game.player.Player;

public class FourInRow extends Game {

    private int rows;
    private int cols;

    public FourInRow(int rows, int cols, Player player1, Player player2, int winningPawn) {
        super(rows, cols, new Player[]{player1, player2}, winningPawn);
        this.rows = rows;
        this.cols = cols;
//        this.view = new View();
//        this.userInteraction = new UserInteraction(view);
        initializeBoard();
    }

    @Override
    public void setOwner(int row, int col, Player player) {

        for (int i = rows - 1; i >= 0; i--) {
            if (getBoard()[i][col].hasNoOwner()) {
                getBoard()[i][col].setOwner(player);
                return;
            }
        }
    }


}
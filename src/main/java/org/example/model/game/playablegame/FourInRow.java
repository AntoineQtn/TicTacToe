package org.example.model.game.playablegame;
import org.example.controller.Game;
import org.example.model.player.Player;

/**
 * Model class that extends from Game overrideing the setOwner method.
 */
public class FourInRow extends Game {

    private int rows;
    private int cols;

    public FourInRow(int rows, int cols, Player player1, Player player2, int winningPawn) {
        super(rows, cols, new Player[]{player1, player2}, winningPawn);
        this.rows = rows;
        this.cols = cols;
        initializeBoard();
    }

    /**
     * Override method that add the specific gravity system of the foour in row.
     * @param row
     * @param col
     * @param player
     */
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
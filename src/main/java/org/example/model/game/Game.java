package org.example.model.game;

import org.example.view.UserInteraction;
import org.example.view.View;
import org.example.model.Cell;
import org.example.model.IGameStrategy;
import org.example.model.player.Player;

/**
 * Model class that represents the abstraction of our games, implementing the essential methods of the IGameStrategy interface.
 * It is the main entry of the GameController that handle the interactions between models and views.
 */
public abstract class Game implements IGameStrategy {

    private final int rows;
    private final int cols;
    private Cell[][] board;
    private final Player[] player;
    protected View view;
    protected UserInteraction userInteraction;
    private final int winningPawn;
    private int currentPlayerIndex = 0;
    private Player currentPlayer;

    protected Game(int rows, int cols, Player[] players, int winningPawn) {
        this(rows, cols, players, winningPawn, null, new View(), new Cell[rows][cols]);
        this.userInteraction = new UserInteraction(this.view);

    }

    protected Game(int rows, int cols, Player[] players, int winningPawn, UserInteraction userInteraction, View view, Cell[][] board) {

        this.rows = rows;
        this.cols = cols;
        this.player = players;
        this.userInteraction = userInteraction;
        this.view = view;
        this.board = board;
        this.winningPawn = winningPawn;
        this.currentPlayer = players[currentPlayerIndex];

    }

    /**
     * Method that creates
     * @param board
     * @param row
     * @param col
     * @param dirX
     * @param dirY
     * @return
     */
    public boolean checkDirection(Cell[][] board, int row, int col, int dirX, int dirY) {
        Player owner = board[row][col].getOwner();
        for (int i = 0; i < getWinningPawn(); i++) {
            int newRow = row + i * dirX;
            int newCol = col + i * dirY;

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                return false;
            }
            if (getBoard()[newRow][newCol].getOwner() != owner) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that create the board of cells.
     */
    public void initializeBoard() {
        Cell[][] board = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Cell(null);
            }
        }
        setBoard(board);
    }

    /**
     * Method that return either all the cells of the board have been taken or not.
     * @return
     */
    public boolean isBoardFull() {
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < getBoard()[0].length; j++) {
                if (getBoard()[i][j].hasNoOwner()) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Method that checks by scanning every winning directions ( calling checkDirection method ) if a player has won or not.
     * @param player
     * @return
     */
    public boolean hasWinner(Player player) {
        Cell[][] board = getBoard();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!board[i][j].hasNoOwner() && board[i][j].getOwner() == player) {
                    if (checkDirection(board, i, j, 0, 1) ||  // Horizontal
                            checkDirection(board, i, j, 1, 0) ||  // Vertical
                            checkDirection(board, i, j, 1, 1) ||  // Diagonal down-right
                            checkDirection(board, i, j, -1, 1)) { // Diagonal up-right
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    protected void setBoard(Cell[][] board) {
        this.board = board;
    }

    public int getRows() {

        return rows;
    }

    public int getCols() {

        return cols;
    }

    public Cell[][] getBoard() {

        return board;
    }

    public Player[] getPlayers() {

        return player;
    }

    public int getWinningPawn() {

        return winningPawn;
    }

    public void setOwner(int row, int col, Player player) {

        getBoard()[row][col].setOwner(player);

    }

    public Player getCurrentPlayer() {

        return currentPlayer;

    }

    public int getSize() {

        return rows * cols;
    }

}
package org.example.game;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.player.Player;

public abstract class Game {

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

    protected void setBoard(Cell[][] board) {
        this.board = board;
    }

    protected int getRows() {
        return rows;
    }

    protected int getCols() {
        return cols;
    }

    protected Cell[][] getBoard() {
        return board;
    }

    protected View getView() {
        return view;
    }

    protected Player[] getPlayers() {
        return player;
    }

    protected int getWinningPawn() {
        return winningPawn;
    }

    protected View setView(View view) {
        this.view = view;
        return view;
    }

    protected void setOwner(int row, int col, Player player) {

        getBoard()[row][col].setOwner(player);

    }

    protected boolean checkDirection(Cell[][] board, int row, int col, int dirX, int dirY) {
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

    protected void initializeBoard() {
        Cell[][] board = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Cell(null);
            }
        }
        setBoard(board);
    }

    protected int getSize() {
        return rows * cols;
    }


    protected boolean isOver() {
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < getBoard()[0].length; j++) {
                if (getBoard()[i][j].hasNoOwner()) {
                    return false;
                }
            }
        }
        return true;
    }


    public void play() {

        getView().displayMessage("Welcome to Four in Row!");

        while (!isOver() || !getWinner()) {

            getView().displayBoard(getBoard());

            getView().displayMessage("Player " + currentPlayer.getRepresentation() + ", it's your turn.");

            int[] move = currentPlayer.move(getBoard());
            int col = move[1];
            int row = move[0];


//            boolean targetRow = isPlayable(col, row);
//
//            if (targetRow) {
//                getView().displayInvalidMove();
//                continue;
//            }

            setOwner(row, col, currentPlayer);

            if (isOver()) {
                getView().displayBoard(getBoard());
//                Player winner = getWinner();
//                if (winner != null) {
//                    getView().displayWinner(winner);
//                } else {
//                    getView().displayDraw();
//                }
                getView().displayDraw();
            } else if(getWinner()){
                getView().displayWinner(getCurrentPlayer());
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % getPlayers().length;
        }

        getView().displayBoard(getBoard());
        getView().displayDraw();

    }

//    private int findFirstEmptyCell(int col ) {
//        Cell[][] board = new Cell[rows][cols];
//        for (int i = rows-1; i > 0 ; i--) {
//            for (int j = 0; j < cols; j++) {
//                if (getBoard()[i][j].hasNoOwner()) {
//                    return i;
//                } else {
//                    return i - 1;
//                }
//            }
//        }
//        return 0;
//    }


//       public boolean getIsPlayable(int row, int col){
//        return isPlayable(row, col);
//       }

    protected Player getCurrentPlayer() {
        return currentPlayer;
    }


    protected boolean getWinner() {
        Cell[][] board = getBoard();
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (!board[i][j].hasNoOwner()) {
                    if (checkDirection(board, i, j, 0, 1) ||
                            checkDirection(board, i, j, 1, 0) ||
                            checkDirection(board, i, j, 1, 1) ||
                            checkDirection(board, i, j, -1, 1)) {
                        if (board[i][j].getOwner().getRepresentation().equals(getCurrentPlayer().getRepresentation())) {
                            count++;
                            if (count == getWinningPawn()) {
                                System.out.println("Winner is " + getCurrentPlayer());
                                return true;
                            }
                        }

                    }
                }
            }
        }
        return false;
    }

}
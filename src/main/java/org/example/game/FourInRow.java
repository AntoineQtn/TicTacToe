package org.example.game;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.player.Player;

public class FourInRow extends Game {

    private int rows;
    private int cols;

    public FourInRow(int rows, int cols, Player player1, Player player2) {
        super(rows, new Player[]{player1, player2});  // On garde rows pour compatibilité
        this.rows = rows;
        this.cols = cols;
        this.view = new View();
        this.userInteraction = new UserInteraction(view);
        initializeBoard(rows, cols);
    }

//    public FourInRow(int size, Player player1, Player player2, Cell[][] board) {
//        super(size * (size + 1), new Player[]{player1, player2}, new UserInteraction(new View()), new View(), Cell[][] board);
//    }

    private void initializeBoard(int rows, int cols) {
        Cell[][] board = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Cell(null);
            }
        }
        setBoard(board);
    }

    @Override
    protected void setOwner(int x, int y, Player player) {
        getBoard()[x][y].setOwner(player);
    }

    @Override
    public void play() {
        int currentPlayerIndex = 0;
        getView().displayMessage("Welcome to Four in Row!");

        while (!isOver()) {
            getView().displayBoard(getBoard());
            Player currentPlayer = getPlayers()[currentPlayerIndex];
            getView().displayMessage("Player " + currentPlayer.getRepresentation() + ", it's your turn.");

            int[] move = currentPlayer.move(getBoard());
            int col = move[1];

            int targetRow = findFirstEmptyCell(col);

            if (targetRow == -1) {
                getView().displayInvalidMove();
                continue;
            }

            setOwner(targetRow, col, currentPlayer);

            if (isOver()) {
                getView().displayBoard(getBoard());
                Player winner = getWinner();
                if (winner != null) {
                    getView().displayWinner(winner);
                } else {
                    getView().displayDraw();
                }
                return;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % getPlayers().length;
        }
        getView().displayBoard(getBoard());
        getView().displayDraw();
    }

    @Override
    protected boolean isOver() {
        // lignes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - 4; j++) {
                if (!getBoard()[i][j].hasNoOwner() &&
                        getBoard()[i][j].getOwner() == getBoard()[i][j + 1].getOwner() &&
                        getBoard()[i][j + 1].getOwner() == getBoard()[i][j + 2].getOwner() &&
                        getBoard()[i][j + 2].getOwner() == getBoard()[i][j + 3].getOwner()) {
                    return true;
                }
            }
        }

        // colonnes
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 0; j < cols; j++) {
                if (!getBoard()[i][j].hasNoOwner() &&
                        getBoard()[i][j].getOwner() == getBoard()[i + 1][j].getOwner() &&
                        getBoard()[i + 1][j].getOwner() == getBoard()[i + 2][j].getOwner() &&
                        getBoard()[i + 2][j].getOwner() == getBoard()[i + 3][j].getOwner()) {
                    return true;
                }
            }
        }

        // diagonales descendantes
        for (int i = 0; i < rows - 4; i++) {
            for (int j = 0; j < cols - 4; j++) {
                if (!getBoard()[i][j].hasNoOwner() &&
                        getBoard()[i][j].getOwner() == getBoard()[i + 1][j + 1].getOwner() &&
                        getBoard()[i + 1][j + 1].getOwner() == getBoard()[i + 2][j + 2].getOwner() &&
                        getBoard()[i + 2][j + 2].getOwner() == getBoard()[i + 3][j + 3].getOwner()){
                    return true;
                }
            }
        }
        //montantes
        for (int i = 3; i < rows; i++) {
            for (int j = 0; j < cols - 4; j++) {
                if (!getBoard()[i][j].hasNoOwner() &&
                        getBoard()[i][j].getOwner() == getBoard()[i - 1][j + 1].getOwner() &&
                        getBoard()[i - 1][j + 1].getOwner() == getBoard()[i - 2][j + 2].getOwner() &&
                        getBoard()[i - 2][j + 2].getOwner() == getBoard()[i - 3][j + 3].getOwner()){
                    return true;
                }
            }
        }


        Cell[][] board;
        if (!getBoard()[0][2].hasNoOwner() &&
                getBoard()[0][2].getOwner() == getBoard()[1][1].getOwner() &&
                getBoard()[1][1].getOwner() == getBoard()[2][0].getOwner()) {
            return true;
        }

        // plateau plein
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < getBoard()[0].length; j++) {
                if (getBoard()[i][j].hasNoOwner()) {
                    return false;
                }
            }
        }
        return true;
    }

    private int findFirstEmptyCell(int col) {
        Cell[][] board = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(getBoard()[i][j].hasNoOwner()) {
                    return i;
                }
                else  {
                    return i-1;
                }
            }
        } return 0;
    }

    private boolean checkDirection(Cell[][] board, int row, int col, int dirX, int dirY) {
        Player owner = board[row][col].getOwner();
        for (int i = 0; i < 4; i++) {
            int newRow = row + i * dirX;
            int newCol = col + i * dirY;

            if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                return false;
            }
            if (getBoard()[newRow][newCol].getOwner() != owner) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected Player getWinner() {
        Cell[][] board = getBoard();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!board[i][j].hasNoOwner()) {
                    if(checkDirection(board, i, j, 0, 1) ||
                    checkDirection(board, i, j, 1, 0) ||
                    checkDirection(board, i, j, 1, 1) ||
                    checkDirection(board, i, j, -1, 1)){
                        return board[i][j].getOwner();
                    }
                }
            }
        }
        return null;

    }

    @Override
    protected int getSize() {
        return rows;
    }

    @Override
    protected Cell[][] getBoard() {
        return super.getBoard();
    }

    @Override
    protected View getView() {
        return super.getView();
    }

    protected View setView(View view) {
        this.view = view;
        return view;
    }

    @Override
    protected Player[] getPlayers() {
        return super.getPlayers();
    }

    protected int getCols() {
        return cols;
    }

}

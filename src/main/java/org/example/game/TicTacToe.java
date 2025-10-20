package org.example.game;

import org.example.player.Player;

public class TicTacToe {
    private final int size;
    private final Cell[][] board;
    private final Player[] player;
    private final UserInteraction userInteraction;
    private final View view;

    public TicTacToe(int size, Player player1, Player player2, UserInteraction userInteraction) {
        this.size = size;
        this.board = new Cell[size][size];
        this.userInteraction = userInteraction;
        this.view = new View();
        String representation1 = userInteraction.askForRepresentation();
        String representation2 = representation1.equals("X") ? "O" : "X";
        this.player = new Player[]{player1, player2};

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell(null);
            }
        }
    }

    public TicTacToe(int size, Player player1, Player player2) {
        this(size, player1, player2, new UserInteraction(new View()));
    }

    /**
     * Method to set the owner of a cell
     * @param x
     * @param y
     * @param player
     */
    public void setOwner(int x, int y, Player player) {
        board[x][y].setOwner(player);
    }

    /**
     * Method that runs the game
     */
    public void play() {
        int currentPlayerIndex = 0;
        view.displayMessage("Welcome to Tic Tac Toe!");

        while (!isOver()) {
            view.displayBoard(board);
            Player currentPlayer = player[currentPlayerIndex];
            view.displayMessage("Player " + currentPlayer.getRepresentation() + ", it's your turn.");

            int[] move = currentPlayer.move(board);
            setOwner(move[0], move[1], currentPlayer);

            if (isOver()) {
                view.displayBoard(board);
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

        view.displayBoard(board);
        view.displayDraw();
    }

    /**
     * Method that make the game stop
     *
     */
    public boolean isOver() {
        // lignes
        for (int i = 0; i < size; i++) {
            if (!board[i][0].hasNoOwner() &&
                    board[i][0].getOwner() == board[i][1].getOwner() &&
                    board[i][1].getOwner() == board[i][2].getOwner()) {
                return true;
            }
        }
        // colonnes
        for (int j = 0; j < size; j++) {
            if (!board[0][j].hasNoOwner() &&
                    board[0][j].getOwner() == board[1][j].getOwner() &&
                    board[1][j].getOwner() == board[2][j].getOwner()) {
                return true;
            }
        }
        // diagonales
        if (!board[0][0].hasNoOwner() &&
                board[0][0].getOwner() == board[1][1].getOwner() &&
                board[1][1].getOwner() == board[2][2].getOwner()) {
            return true;
        }
        if (!board[0][2].hasNoOwner() &&
                board[0][2].getOwner() == board[1][1].getOwner() &&
                board[1][1].getOwner() == board[2][0].getOwner()) {
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

    public Player getWinner() {
        for (int i = 0; i < size; i++) {
            if (!board[i][0].hasNoOwner() &&
                    board[i][0].getOwner() == board[i][1].getOwner() &&
                    board[i][1].getOwner() == board[i][2].getOwner()) {
                return board[i][0].getOwner();
            }
        }
        for (int j = 0; j < size; j++) {
            if (!board[0][j].hasNoOwner() &&
                    board[0][j].getOwner() == board[1][j].getOwner() &&
                    board[1][j].getOwner() == board[2][j].getOwner()) {
                return board[0][j].getOwner();
            }
        }
        if (!board[0][0].hasNoOwner() &&
                board[0][0].getOwner() == board[1][1].getOwner() &&
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


    public int getSize(){
        return size;
    }
    public Cell[][] getBoard() {
        return board;
    }

}

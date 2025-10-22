package org.example.game;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.player.Player;

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

//    private void initializeBoard(int rows, int cols) {
//        Cell[][] board = new Cell[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                board[i][j] = new Cell(null);
//            }
//        }
//        setBoard(board);
//    }

//    @Override
//    protected void setOwner(int x, int y, Player player) {
//        getBoard()[x][y].setOwner(player);
//    }

//    @Override
//    public void play() {
//        int currentPlayerIndex = 0;
//        getView().displayMessage("Welcome to Tic Tac Toe!");
//
//        while (!isOver()) {
//            getView().displayBoard(getBoard());
//            Player currentPlayer = getPlayers()[currentPlayerIndex];
//            getView().displayMessage("Player " + currentPlayer.getRepresentation() + ", it's your turn.");
//
//            int[] move = currentPlayer.move(getBoard());
//            setOwner(move[0], move[1], currentPlayer);
//
//            if (isOver()) {
//                getView().displayBoard(getBoard());
//                Player winner = getWinner();
//                if (winner != null) {
//                    getView().displayWinner(winner);
//                } else {
//                    getView().displayDraw();
//                }
//                return;
//            }
//
//            currentPlayerIndex = (currentPlayerIndex + 1) % getPlayers().length;
//        }
//        getView().displayBoard(getBoard());
//        getView().displayDraw();
//    }
//
//    @Override
//    protected boolean isOver() {
//        // lignes
//        for (int i = 0; i < getSize(); i++) {
//            if (!getBoard()[i][0].hasNoOwner() &&
//                    getBoard()[i][0].getOwner() == getBoard()[i][1].getOwner() &&
//                    getBoard()[i][1].getOwner() == getBoard()[i][2].getOwner() &&
//                    getBoard()[i][2].getOwner() == getBoard()[i][3].getOwner() &&
//                    getBoard()[i][3].getOwner() == getBoard()[i][4].getOwner()
//            ) {
//                return true;
//            }
//        }
//
//        // colonnes
//        for (int j = 0; j < getSize(); j++) {
//            if (!getBoard()[0][j].hasNoOwner() &&
//                    getBoard()[0][j].getOwner() == getBoard()[1][j].getOwner() &&
//                    getBoard()[1][j].getOwner() == getBoard()[2][j].getOwner() &&
//                    getBoard()[2][j].getOwner() == getBoard()[3][j].getOwner() &&
//                    getBoard()[3][j].getOwner() == getBoard()[4][j].getOwner()) {
//                return true;
//            }
//        }
//
//        // diagonales
//        if (!getBoard()[0][0].hasNoOwner() &&
//                getBoard()[0][0].getOwner() == getBoard()[1][1].getOwner() &&
//                getBoard()[1][1].getOwner() == getBoard()[2][2].getOwner() &&
//                getBoard()[2][2].getOwner() == getBoard()[3][3].getOwner() &&
//                getBoard()[3][3].getOwner() == getBoard()[4][4].getOwner()
//        ) {
//            return true;
//        }
////
////        Cell[][] board;
//        if (!getBoard()[4][0].hasNoOwner() &&
//                getBoard()[4][0].getOwner() == getBoard()[3][1].getOwner() &&
//                getBoard()[3][1].getOwner() == getBoard()[2][2].getOwner() &&
//                getBoard()[2][2].getOwner() == getBoard()[1][3].getOwner() &&
//                getBoard()[1][3].getOwner() == getBoard()[0][4].getOwner()) {
//            return true;
//        }
////
////        // plateau plein
//        for (int i = 0; i < getSize(); i++) {
//            for (int j = 0; j < getSize(); j++) {
//                if (getBoard()[i][j].hasNoOwner()) {
//                    return false;
//                }
//            }
//        }
//
//        return false;
//    }

//    @Override
//    protected Player getWinner() {
//        for (int i = 0; i < getSize(); i++) {
//            if (!getBoard()[i][0].hasNoOwner() &&
//                    getBoard()[i][0].getOwner() == getBoard()[i][1].getOwner() &&
//                    getBoard()[i][1].getOwner() == getBoard()[i][2].getOwner() &&
//                    getBoard()[i][2].getOwner() == getBoard()[i][3].getOwner() &&
//                    getBoard()[i][3].getOwner() == getBoard()[i][4].getOwner()
//            ) {
//                return getBoard()[i][0].getOwner();
//            }
//        }
//
//        for (int j = 0; j < getSize(); j++) {
//            if (!getBoard()[0][j].hasNoOwner() &&
//                    getBoard()[0][j].getOwner() == getBoard()[1][j].getOwner() &&
//                    getBoard()[1][j].getOwner() == getBoard()[2][j].getOwner() &&
//                    getBoard()[2][j].getOwner() == getBoard()[3][j].getOwner() &&
//                    getBoard()[3][j].getOwner() == getBoard()[4][j].getOwner()) {
//                return getBoard()[0][j].getOwner();
//            }
//        }
//
//        if (!getBoard()[0][0].hasNoOwner() &&
//                getBoard()[0][0].getOwner() == getBoard()[1][1].getOwner() &&
//                getBoard()[1][1].getOwner() == getBoard()[2][2].getOwner() &&
//                getBoard()[2][2].getOwner() == getBoard()[3][3].getOwner() &&
//                getBoard()[3][3].getOwner() == getBoard()[4][4].getOwner()) {
//            return getBoard()[0][0].getOwner();
//        }
//
//        if (!getBoard()[0][4].hasNoOwner() &&
//                getBoard()[4][0].getOwner() == getBoard()[3][1].getOwner() &&
//                getBoard()[3][1].getOwner() == getBoard()[2][2].getOwner() &&
//                getBoard()[2][2].getOwner() == getBoard()[1][3].getOwner() &&
//                getBoard()[1][3].getOwner() == getBoard()[0][4].getOwner()) {
//            return getBoard()[0][0].getOwner();
//        }
//
//        return null;
//    }

}

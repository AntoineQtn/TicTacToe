package org.example.game;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.player.ArtificialPlayer;
import org.example.player.HumanPlayer;
import org.example.player.Player;

public class TicTacToe extends Game {

    public TicTacToe(int rows, int cols, Player player1, Player player2,int winningPawn) {
        super(rows,cols, new Player[]{player1, player2}, 3);
        this.view = new View();
        this.userInteraction = new UserInteraction(view);
        initializeBoard();
    }

//
//    private void initializeBoard(int rows, int cols) {
//        Cell[][] board = new Cell[getRows()][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
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

//    @Override
//    protected boolean isOver() {
//        // lignes
//        for (int i = 0; i < getSize(); i++) {
//            if (!getBoard()[i][0].hasNoOwner() &&
//                    getBoard()[i][0].getOwner() == getBoard()[i][1].getOwner() &&
//                    getBoard()[i][1].getOwner() == getBoard()[i][2].getOwner()) {
//                return true;
//            }
//        }
//
//        // colonnes
//        for (int j = 0; j < getSize(); j++) {
//            if (!getBoard()[0][j].hasNoOwner() &&
//                    getBoard()[0][j].getOwner() == getBoard()[1][j].getOwner() &&
//                    getBoard()[1][j].getOwner() == getBoard()[2][j].getOwner()) {
//                return true;
//            }
//        }
//
//        // diagonales
//        if (!getBoard()[0][0].hasNoOwner() &&
//                getBoard()[0][0].getOwner() == getBoard()[1][1].getOwner() &&
//                getBoard()[1][1].getOwner() == getBoard()[2][2].getOwner()) {
//            return true;
//        }
//
//        Cell[][] board;
//        if (!getBoard()[0][2].hasNoOwner() &&
//                getBoard()[0][2].getOwner() == getBoard()[1][1].getOwner() &&
//                getBoard()[1][1].getOwner() == getBoard()[2][0].getOwner()) {
//            return true;
//        }
//
//        // plateau plein
//        for (int i = 0; i < getSize(); i++) {
//            for (int j = 0; j < getSize(); j++) {
//                if (getBoard()[i][j].hasNoOwner()) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//
//    @Override
//    protected Player getWinner() {
//        for (int i = 0; i < getSize(); i++) {
//            if (!getBoard()[i][0].hasNoOwner() &&
//                    getBoard()[i][0].getOwner() == getBoard()[i][1].getOwner() &&
//                    getBoard()[i][1].getOwner() == getBoard()[i][2].getOwner()) {
//                return getBoard()[i][0].getOwner();
//            }
//        }
//
//        for (int j = 0; j < getSize(); j++) {
//            if (!getBoard()[0][j].hasNoOwner() &&
//                    getBoard()[0][j].getOwner() == getBoard()[1][j].getOwner() &&
//                    getBoard()[1][j].getOwner() == getBoard()[2][j].getOwner()) {
//                return getBoard()[0][j].getOwner();
//            }
//        }
//
//        if (!getBoard()[0][0].hasNoOwner() &&
//                getBoard()[0][0].getOwner() == getBoard()[1][1].getOwner() &&
//                getBoard()[1][1].getOwner() == getBoard()[2][2].getOwner()) {
//            return getBoard()[0][0].getOwner();
//        }
//
//        if (!getBoard()[0][2].hasNoOwner() &&
//                getBoard()[0][2].getOwner() == getBoard()[1][1].getOwner() &&
//                getBoard()[1][1].getOwner() == getBoard()[2][0].getOwner()) {
//            return getBoard()[0][2].getOwner();
//        }
//
//        return null;
//    }

//    @Override
//    protected int getSize() {
//        return super.getSize();
//    }
//
//    @Override
//    protected Cell[][] getBoard() {
//        return super.getBoard();
//    }
//
//    @Override
//    protected View getView() {
//        return super.getView();
//    }
//
//    protected View setView(View view) {
//        this.view = view;
//        return view;
//    }
//
//    @Override
//    protected Player[] getPlayers() {
//        return super.getPlayers();
//    }

}

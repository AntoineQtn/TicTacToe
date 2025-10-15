package org.example;

public class TicTacToe {
    private int size;
    private Cell[][] board;
    private Player player;
    public TicTacToe(int size) {
        this.size = size;
        board = new Cell[size][size];
        player = new Player();
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
    }
    public int getMoveFromPlayer(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return -1;
        }
        return x;
    }
    public void setOwner(int x, int y, Player player) {

    }
    public void play() {
        while (true) {

        }
    }
    public void isOver(boolean gamewon) {

    }
}

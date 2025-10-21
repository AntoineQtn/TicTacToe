package org.example.game;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.player.Player;

public abstract class Game {

    private final int size;
    private Cell[][] board;
    private final Player[] player;
    protected View view;
    protected UserInteraction userInteraction;

    protected Game(int size, Player[] players) {
        this.size = size;
        this.player = players;
    }

    protected Game(int size, Player[] players, UserInteraction userInteraction, View view, Cell[][] board) {
        this.size = size;
        this.player = players;
        this.userInteraction = userInteraction;
        this.view = view;
        this.board = board;
    }

    protected void setBoard(Cell[][] board) {
        this.board = board;
    }

    protected int getSize() {
        return size;
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

    protected abstract void setOwner(int x, int y, Player player);
    protected abstract void play();
    protected abstract boolean isOver();
    protected abstract Player getWinner();

}
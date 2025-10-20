package org.example.game;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.player.Player;

import static java.nio.file.Files.setOwner;

public abstract class Game {

    private final int size;
    private final Cell[][] board;
    private final Player[] player;
    private final UserInteraction userInteraction;
    private final View view;

    protected Game(int size, Player[] players, UserInteraction userInteraction, View view) {
        this.size = size;
        this.player = players;
        this.userInteraction = userInteraction;
        this.view = view;

        this.board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell(null);
            }
        }
    }

    protected abstract void setOwner(int x, int y, Player player);
    protected abstract void play();
    protected abstract void isOver();
    protected abstract void getWinner();
    protected abstract void getSize();
    protected abstract void getBoard();
}


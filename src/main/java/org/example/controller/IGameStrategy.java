package org.example.controller;

import org.example.model.game.Cell;
import org.example.model.player.Player;

/**
 * Interface to build our strategy pattern, implemented in Game it contains the essential methods for any game.
 */
public interface IGameStrategy {

    Cell[][] getBoard();

    Player getCurrentPlayer();

    void setOwner(int row, int col, Player player);

    boolean hasWinner(Player player);

    boolean isBoardFull();

    void setCurrentPlayer(Player player);

    void setCurrentPlayerIndex(int row);

    int getCurrentPlayerIndex();

    Player[] getPlayers();

    int getRows();

    int getCols();


}

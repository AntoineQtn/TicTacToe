package org.example.model.game;

import org.example.model.game.player.Player;

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

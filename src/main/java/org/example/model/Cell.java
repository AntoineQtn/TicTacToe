package org.example.model;

import org.example.model.player.Player;

/**
 * Model class that represent a cell of a bord that can be taken by a player.
 */
public class Cell {

    private Player player;

    public Cell(Player player) {
        this.player = player;
    }

    /**
     * Method that make a player the owner of a cell
     * @param player
     */
    public void setOwner(Player player) {

        this.player = player;
    }

    public Player getOwner() {
        return player;
    }
    /**
     * Method that assume that a cell has no owner
     * @return
     */
    public boolean hasNoOwner() {
        return player == null;
    }

    /**
     * Method that get an available cell by returning it empty
     */
    public String getRepresentation(){
        if (player == null) {
            return "   ";
        } else {
            return player.getRepresentation();
        }
    }
}

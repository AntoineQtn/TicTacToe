package org.example.model.game.player;

import org.example.model.game.Cell;

public abstract class Player {
    private String representation;
    private boolean isHuman;

    public Player(String representation) {

        this.representation = representation;
    }

    /**
     * Method that return the representation of the player "X" or "O"
     * @return
     */
    public String getRepresentation() {

        return representation;
    }

    public boolean getIsHuman() {

        return isHuman = true;

    }

    public abstract int[] move(Cell[][] board);

}

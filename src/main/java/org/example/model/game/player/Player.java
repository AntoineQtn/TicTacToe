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

    public boolean setIsHuman(boolean isHuman) {
        return isHuman;
    }

    public boolean getIsHuman() {
        return isHuman;
    }
}
//
//    public abstract int[] move (Cell[][] board);
//
//}

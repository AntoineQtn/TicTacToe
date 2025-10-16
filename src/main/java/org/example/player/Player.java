package org.example.player;

import org.example.game.Cell;

public abstract class Player {
    private String representation;

    public Player(String representation){
        this.representation = representation;
    }

    /**
     * Method that return the representation of the player "X" or "O"
     * @return
     */
    public String getRepresentation(){
        return representation;
    }

    public abstract int[] move (Cell[][] board);

}

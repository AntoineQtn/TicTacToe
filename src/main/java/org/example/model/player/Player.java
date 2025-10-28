package org.example.model.player;

/**
 * Model Class that represents the abstraction of a player, either human or artificial.
 */
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


}

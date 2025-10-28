package org.example.model.player;

/**
 * Model class that stores the boolean isHuman.
 */
public class ArtificialPlayer extends Player {
    private boolean isHuman = false;

    public ArtificialPlayer(String representation) {
        super(representation);
    }

    public boolean getIsHuman() {
        return isHuman = false;
    }

}

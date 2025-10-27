package org.example.model.game.player;

import org.example.model.game.Cell;

public class ArtificialPlayer extends Player {
    private boolean isHuman = false;

    public ArtificialPlayer(String representation) {
        super(representation);
    }

    public boolean getIsHuman() {
        return isHuman = false;
    }

}

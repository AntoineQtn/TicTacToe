package org.example.player;

import org.example.game.Cell;
import org.example.game.UserInteraction;
import org.example.game.View;

public class HumanPlayer extends Player {

    public HumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] move(Cell[][] board) {
        UserInteraction userInteraction = new UserInteraction(new View());
        int[] move;
        while (true) {
            move = userInteraction.askForPosition();
            int x = move[0];
            int y = move[1];
            if (board[x][y].hasNoOwner()) {
                break;
            } else {
                System.out.println("Cell already occupied, try again.");
            }
        }
        return move;
    }


}

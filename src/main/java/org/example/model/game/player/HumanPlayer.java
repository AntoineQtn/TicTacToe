package org.example.model.game.player;

import org.example.model.game.Cell;
import org.example.display.UserInteraction;
import org.example.display.View;

public class HumanPlayer extends Player {
    private boolean isHuman = true;

    public HumanPlayer(String representation) {
        super(representation);
    }

//    @Override
//    public int[] move(Cell[][] board) {
//        UserInteraction userInteraction = new UserInteraction(new View());
//        int[] move;
//        while (true) {
//            move = userInteraction.askForPosition();
//            int x = move[0];
//            int y = move[1];
//            if (board[x][y].hasNoOwner()) {
//                break;
//            }

    ////            else {
    ////                System.out.println("Cell already occupied, try again.");
    ////            }
//        }
//        return move;
//    }

    public boolean setIsHuman() {
        return isHuman=true;
    }

}

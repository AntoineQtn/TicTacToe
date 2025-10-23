package org.example.model.game.player;

import org.example.model.game.Cell;

import java.util.Random;

public class ArtificialPlayer extends Player {
    private boolean isHuman = false;

    public ArtificialPlayer(String representation) {
        super(representation);
    }

//    @Override
//    public int[] move(Cell[][] board) {
//        Random random = new Random();
//        int size = board.length;
//        int x, y;
//        do {
//            x = random.nextInt(size);
//            y = random.nextInt(size);
//        } while (!board[x][y].hasNoOwner());
////        System.out.println("ArtificialPlayer plays at: " + x + ", " + y);
//        return new int[]{x, y};
//    }



}

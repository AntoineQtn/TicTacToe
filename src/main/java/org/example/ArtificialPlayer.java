package org.example;

import java.util.Random;

public class ArtificialPlayer extends Player {

    public ArtificialPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] move(Cell[][] board) {
        Random random = new Random();
        int size = board.length;
        int x, y;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (!board[x][y].hasNoOwner());
        System.out.println("ArtificialPlayer plays at: " + x + ", " + y);
        return new int[]{x, y};
    }

}

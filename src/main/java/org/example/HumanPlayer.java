package org.example;

public class HumanPlayer extends Player{

    public HumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] move(Cell[][] board) {
        Menu menu = new Menu();
        int[] move;
        while (true) {
            move = menu.askForPosition();
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

package org.example.game;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.player.Player;

public class FourInRow extends Game {

    private int rows;
    private int cols;

    public FourInRow(int rows, int cols, Player player1, Player player2, int winningPawn) {
        super(rows, cols, new Player[]{player1, player2}, 4);  // On garde rows pour compatibilité
        this.rows = rows;
        this.cols = cols;
        this.view = new View();
        this.userInteraction = new UserInteraction(view);
        initializeBoard();
    }

    @Override
    protected void setOwner(int row, int col, Player player) {
//            if (isPlayable(row, col)) {
//                System.out.println("Empty Row downside, try again");
//                getCurrentPlayer().move(getBoard());
//            }
//        while (row < rows && getBoard()[row][col].hasNoOwner()) {
//            if (getBoard()[row][col].hasNoOwner()) {
//                row += 1;
//                getBoard()[row][col].setOwner(player);
//            } else {
//                row -= 1;
//                getBoard()[row][col].setOwner(player);
//            }
        for (row = 0; row < rows; row++) {
            if (getBoard()[row][col].hasNoOwner()) {
                row += 1;
                getBoard()[row][col].setOwner(player);
            } else {
                row -= 1;
                getBoard()[row][col].setOwner(player);
            }
        }
        }

//    private int isPlayable(int row, int col){
//        while( row < rows && getBoard()[row][col].hasNoOwner()){
//            if(getBoard()[row][col].hasNoOwner()){
//                return row += 1;
//            }else{
//                return row -= 1;
//            }
//        }
//        return getBoard()[row][col];
//    }

//    private boolean isEmpty(int row) {
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (getBoard()[i][j].hasNoOwner()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    }


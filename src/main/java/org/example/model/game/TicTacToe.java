package org.example.model.game;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.model.game.player.Player;

public class TicTacToe extends Game {

//    public TicTacToe(int rows, int cols, Player player1, Player player2,int winningPawn) {
public TicTacToe(int rows, int cols, int winningPawn) {
        super(rows,cols, 3);
//        this.view = new View();
//        this.userInteraction = new UserInteraction(view);
        initializeBoard();
    }

}

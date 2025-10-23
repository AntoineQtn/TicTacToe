package org.example;

import org.example.controller.GameController;
import org.example.display.View;
import org.example.model.game.FourInRow;
import org.example.model.game.TicTacToe;
import org.example.model.game.player.ArtificialPlayer;
import org.example.model.game.player.HumanPlayer;


public class Main {
    public static void main(String[] args) {
        try {
//    TicTacToe ticTacToe = new TicTacToe(3,3, new HumanPlayer(" X "), new ArtificialPlayer(" O "),3);
//    ticTacToe.play();
            GameController gameController = new GameController(new TicTacToe(3, 3, 3), new View(), new HumanPlayer(" X "), new ArtificialPlayer(" O "));
            gameController.play();
//            FourInRow fourInRow = new FourInRow(6, 7, new HumanPlayer(" X "), new ArtificialPlayer(" O "), 4);
//            fourInRow.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        Gomoku gomoku= new Gomoku(6, 7, new HumanPlayer(" X "), new ArtificialPlayer(" O "), 5);
//        gomoku.play();


    }
}

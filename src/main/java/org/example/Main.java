package org.example;

import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.game.*;
import org.example.player.ArtificialPlayer;
import org.example.player.HumanPlayer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
//    TicTacToe ticTacToe = new TicTacToe(3,3, new HumanPlayer(" X "), new ArtificialPlayer(" O "),3);
//    ticTacToe.play();

            FourInRow fourInRow = new FourInRow(6, 7, new HumanPlayer(" X "), new ArtificialPlayer(" O "), 4);
            fourInRow.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        Gomoku gomoku= new Gomoku(6, 7, new HumanPlayer(" X "), new ArtificialPlayer(" O "), 5);
//        gomoku.play();
    }
}

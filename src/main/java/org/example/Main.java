package org.example;

import org.example.game.TicTacToe;
import org.example.player.ArtificialPlayer;
import org.example.player.HumanPlayer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    TicTacToe ticTacToe = new TicTacToe(3, new HumanPlayer("X"), new ArtificialPlayer("O"));
    ticTacToe.play();
    }
}
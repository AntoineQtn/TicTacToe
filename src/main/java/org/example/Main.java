package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    TicTacToe ticTacToe = new TicTacToe(3, new ArtificialPlayer("X"), new ArtificialPlayer("O"));
    ticTacToe.play();
    }
}
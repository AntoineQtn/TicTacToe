package org.example.model;

import org.example.model.game.FourInRow;
import org.example.model.game.Game;
import org.example.model.game.Gomoku;
import org.example.model.game.TicTacToe;
import org.example.model.player.ArtificialPlayer;
import org.example.model.player.HumanPlayer;
import org.example.model.player.Player;

public class GameFactory {

    public Game choosenGame(int choice) {

        Player human = new HumanPlayer(" X ");
        Player ai = new ArtificialPlayer(" O ");

        return switch (choice) {
            case 1 -> new TicTacToe(3, 3, human, ai);
            case 2 -> new Gomoku(5, 5, human, ai, 5);
            case 3 -> new FourInRow(6, 7, human, ai, 4);
            default -> null;
        };

    }
}

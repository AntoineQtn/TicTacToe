package org.example.model.game;

import org.example.model.game.player.ArtificialPlayer;
import org.example.model.game.player.HumanPlayer;
import org.example.model.game.player.Player;

public class GameFactory {
    public Game choosenGame(int choice){

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

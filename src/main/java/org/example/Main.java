package org.example;

import org.example.controller.GameController;
import org.example.view.UserInteraction;
import org.example.view.View;
import org.example.controller.Game;
import org.example.controller.GameFactory;

public class Main {
    public static void main(String[] args) {

        try {
            GameFactory gameFactory = new GameFactory();
            View view = new View();
            UserInteraction ui = new UserInteraction(view);
            int choice = ui.displayMenu();

            Game choosenGame = gameFactory.choosenGame(choice);

            GameController controller = new GameController(choosenGame, view, ui);
            controller.startGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

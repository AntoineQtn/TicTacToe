package org.example;

import org.example.controller.GameController;
import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.model.game.*;
import org.example.model.game.GameFactory;



public class Main {
    public static void main(String[] args) {
        try {
            GameFactory gameFactory = new GameFactory();
            View view = new View();
            UserInteraction ui = new UserInteraction(view);

            int choice = ui.displayMenu();
            Game choosenGame = gameFactory.choosenGame(choice);

            GameController controller = new GameController(choosenGame, view, ui);
            controller.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

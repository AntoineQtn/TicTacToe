package org.example;

import org.example.controller.GameControllerRefacto;
import org.example.controller.GameState;
import org.example.display.UserInteraction;
import org.example.display.View;
import org.example.model.game.*;
import org.example.model.game.GameFactory;

import static org.example.controller.GameState.CHOOSE;


public class MainRefacto {
    public static void main(String[] args) {

        try {
            GameFactory gameFactory = new GameFactory();
            View view = new View();
            UserInteraction ui = new UserInteraction(view);
            int choice = ui.displayMenu();

            Game choosenGame = gameFactory.choosenGame(choice);

            GameControllerRefacto controller = new GameControllerRefacto(choosenGame, view, ui);
            controller.startGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

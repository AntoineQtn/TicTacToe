package org.example.controller;

public enum GameState {
    CHOOSE,
    INITIALIZE,
    START,
    TURN,
    DRAW,
    WIN,
    LOOSE,
    EXITGAME;

    private GameState gameState;

    public GameState getGameState() {
        return this.gameState;
    }

}


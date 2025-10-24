package org.example.controller;

public enum GameState {
    CHOSE, //displayMenu()
    INITIALIZE,//displayBoard()
    START, //play()
    TURN, //move()
    DRAW,//displayDraw()
    WIN,//displayWinner()
    LOOSE,
    EXITGAME,

}

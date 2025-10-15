package org.example;

public class Cell {
    Player player;

    public Cell(Player player) {
        this.player = player;
    }

    public void setOwner(Player player) {
        this.player = player;
    }
    public boolean isEmpty() {
        return true;
    }
    public void getRepresentation(){

    }
}

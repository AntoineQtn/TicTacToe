package org.example;

public class Player {
    private Menu menu;
    private String representation;
    public Player(String representation){
        this.representation = representation;
    }

    /**
     * Method that return the representation of the player "X" or "O"
     * @return
     */
    public String getRepresentation(){
        return representation;
    }

}

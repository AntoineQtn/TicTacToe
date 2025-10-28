package org.example.display;

public class View {

    public void displayMessage(String message) {

        System.out.println(message);


    }

    public void displayCell(String cell) {
        System.out.print(cell);
    }

    public void displayRowSeparator(int cols) {
        for (int j = 0; j < cols; j++) {
            System.out.print("---");
            if (j < cols - 1) {
                System.out.print("+");
            }
        }
        System.out.println();
    }
    public void displayNewLine() {

        System.out.println();

    }

    public void displayOccupied() {
        System.out.println("Cell already occupied");
    }

    public void displayDraw() {
        displayMessage("It's a draw!");
    }



}
package org.example.display;

/**
 * View class that handle our System.out.println().
 */
public class View {

    /**
     * Method containing our sout.
     * @param message
     */
    public void displayMessage(String message) {

        System.out.println(message);

    }

    /**
     * Method to display cells, empty string, "X" or "O".
     * @param cell
     */
    public void displayCell(String cell) {
        System.out.print(cell);
    }

    /**
     * Method to display the graphic aspect of our board.
     * @param cols
     */
    public void displayRowSeparator(int cols) {
        for (int j = 0; j < cols; j++) {
            System.out.print("---");
            if (j < cols - 1) {
                System.out.print("+");
            }
        }
        System.out.println();
    }

    /**
     * Empty sout for new line.
     */
    public void displayNewLine() {

        System.out.println();

    }

    /**
     * Method call to display the error message when the user try to take an occupied cell.
     */
    public void displayOccupied() {
        System.out.println("Cell already occupied");
    }

    /**
     * Game draw message.
     */
    public void displayDraw() {
        displayMessage("It's a draw!");
    }



}
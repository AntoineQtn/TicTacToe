package org.example;

public class TicTacToe {
    private final int size;
    private final Cell[][] board;
    private final Player player;
    private final Menu menu;

    public TicTacToe(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        this.menu = new Menu(new java.util.Scanner(System.in));
        this.player = new Player(menu.askForRepresentation());

        //initializing an empty cell board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell(null);
            }
        }
    }

    /**
     * displaying the board according to its size
     */
    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j].getRepresentation());
                if (j < size - 1) System.out.print("|");
            }
            System.out.println();
            if (i < size - 1) System.out.println("---+---+---");
        }
    }

    /**
     * Managing player prompt
     * @return
     */
    public int[] getMoveFromPlayer() {
        int[] move;
        while (true) {
            move = menu.askForPosition();
            int x = move[0];
            int y = move[1];

            if (x < 0 || y < 0 || x >= size || y >= size) {
                System.out.println("Invalid coordinates, try again.");
                continue;
            }
            if (!board[x][y].hasNoOwner()) {
                System.out.println("Cell already occupied, try again.");
                continue;
            }
            break;
        }
        return move;
    }

    /**
     * Method to set the owner of a cell
     * @param x
     * @param y
     * @param player
     */
    public void setOwner(int x, int y, Player player) {
        board[x][y].setOwner(player);
    }

    /**
     * Method that runs the game
     */
    public void play() {
        while (true) {
            display();
            int[] move = getMoveFromPlayer();
            setOwner(move[0], move[1], player);
            display();
        }
    }

    /**
     * Method that make the game stop
     * @param gamewon
     */
    public void isOver(boolean gamewon) {

    }

}

package org.example;

public class TicTacToe {
    private final int size;
    private final Cell[][] board;
    private final Player[] player;
    private final Menu menu;

    public TicTacToe(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        this.menu = new Menu();
        String representation1 = menu.askForRepresentation();
        String representation2 = representation1.equals("X") ? "O" : "X";
        this.player = new Player[]{
                new Player(representation1),
                new Player(representation2)
        };

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
       int currentPlayerIndex = 0;
       while (!isOver()){
           display();
           System.out.println("Player " + player[currentPlayerIndex].getRepresentation());
           int[] move = getMoveFromPlayer();
           setOwner(move[0], move[1], player[currentPlayerIndex]);
           if(isOver()){
               display();
               System.out.println("Player " + player[currentPlayerIndex].getRepresentation());
               return;
           }
           currentPlayerIndex = (currentPlayerIndex + 1) % player.length;
       }
       display();
        System.out.println("It's a draw");
    }

    /**
     * Method that make the game stop
     *
     */
    public boolean isOver() {
        //lines
        for (int i = 0; i < size; i++) {
            if (!board[i][0].hasNoOwner() &&
                    board[i][0].getOwner() == board[i][1].getOwner() &&
                    board[i][1].getOwner() == board[i][2].getOwner()) {
                System.out.println("You won !");
                return true;
            }
        }
        //columns
        for (int j = 0; j < size; j++) {
            if(!board[0][j].hasNoOwner() &&
            board[0][j].getOwner() == board[1][j].getOwner() &&
            board[1][j].getOwner() == board[2][j].getOwner()) {
                System.out.println("You won !");
                return  true;
            }
        }
        //first diagonal
        if (!board[0][0].hasNoOwner() &&
                board[0][0].getOwner() == board[1][1].getOwner() &&
                board[1][1].getOwner() == board[2][2].getOwner()) {
            System.out.println("You won !");
            return true;
        }
        //second diagonal
        if (!board[0][2].hasNoOwner() &&
                board[0][2].getOwner() == board[1][1].getOwner() &&
                board[1][1].getOwner() == board[2][0].getOwner()) {
            System.out.println("You won !");
            return true;
        }
        //full board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].hasNoOwner()) {
                    return false;
                }
            }
        }
    return true;
    }

}

Tic Tac Toe project.

Description :

Creating a Tic Tac Toe game in java that will be run in the console.

Environnement :

- Java Development Kit (JDK): version 17 or higher.
- Gradle: the project is compatible with Gradle 8+ and it is recommended to use the Gradle Wrapper provided (./gradlew).
- Recommended IDE: IntelliJ IDEA (or any other Gradle-compatible Java IDE).
- Internet connection: required to download dependencies from Maven Central (JUnit 5).

Naming :

We use the classical naming rules :
- classes name in PascalCase.
- methods and attributes in camelCase.
- enums in UPPER_CASE.

UML :

```mermaid
classDiagram
    class Main {
        + void main(String[] args)
    }

class Game {
        - int rows
        - int cols
        - Cell[][] board
        - Player[] player
        - UserInteraction UserInteraction
        - View view
        - int winningPawn
        - Player currentPlayer
        - int currentPlayerIndex
        - Game game

        + void setOwner(int x, int y, Player player)
        + void play()
        + bolean checkDirection(Cell[][] board, int row, int col, int dirX, int dirY)
        + void initializedBoard()
        + boolean isBoardFull()
        + boolean hasWinner(Player player)
        + void setBoard(Cell[][] board)
        + void getBoard()
        + void getPlayers()
        + void getWinningPaws()
        + void getCurrentPlayer()
        + int getCols()
        + int getRows()
        + void setCurrentPlayer(Player player)
        + int getCurrentPlayerIndex()
        + void setCurrentPlayerIndex()


}

    class TicTacToe {

    }
  

    class FourInRow {

    }

    class Gomoku {

    }

    class Cell {
        - Player player
        + void setOwner(Player player)
        + boolean hasNoOwner()
        + Player getOwner()
        + String getRepresentation()
    }

    class Player {
        - String representation
        - boolean isHuman
        + String getRepresentation()
        + boolean getIsHuman()
    }

    class ArtificialPlayer{

    }
    class HumanPlayer{

    }

    class UserInteraction {
        + int[] askForPosition()
    }

    class View {

        + void displayMessage()
        + void displayCell(String cell)
        + void displayRowSeparator(int cols)
        + void displayNewLine() 
        + void displayOccupied()
        + void displayDraw()
    }

    class GameController{
        - Game game
        - View view
        - GameState gameState
        - UserInteraction ui
        + void startGame()
        + void play()
        + void displayWinner(Player player)
        + dysplayBoard(Cell[][] board)
        + string displayError()
        + int[] move(Cell[][] board)
    }
      
class GameFactory {

+ Game choosenGame(int choice)

}

class GameState {
<<Enum>>

INITIALIZE,
    START,
    DRAW,
    WIN,
    EXITGAME;

}

    GameFactory --> Main
    GameState --> GameController

    Game --> Main

    Game <|-- TicTacToe
    Game <|-- Gomoku
    Game <|-- FourInRow

                 
    Cell --> Game
    Player --> Game
    UserInteraction --> Game

    View --> Game
    Player --> Cell
    Player <|-- ArtificialPlayer
    Player <|-- HumanPlayer

    GameController-->Game

```

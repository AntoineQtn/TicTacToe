import org.example.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.example.TicTacToe;


public class TicTacToeTest {

    private TicTacToe tictactoe;
    private Player player;

    @BeforeEach
    void setUp() {
        tictactoe = new TicTacToe(3);
        player = new Player("X");
    }

    @Test
    void getWinner() {
        tictactoe.play();
    }
}

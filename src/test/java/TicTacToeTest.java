//import org.example.game.Cell;
//import org.example.game.TicTacToe;
//import org.example.player.ArtificialPlayer;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TicTacToeTest {
//
//    @Test
//    public void test_constructor_with_mockedUserInteraction() {
//        UserInteractionTest fakeUI = new UserInteractionTest();
//        TicTacToe ticTacToe = new TicTacToe(3, new ArtificialPlayer("X"), new ArtificialPlayer("O"), fakeUI);
//
//        assertEquals(3, ticTacToe.getSize());
//    }
//
//    @Test
//    public void test_setOwner_assignsPlayerToCell() {
//        UserInteractionTest fakeUI = new UserInteractionTest();
//        ArtificialPlayer playerX = new ArtificialPlayer("X");
//        ArtificialPlayer playerO = new ArtificialPlayer("O");
//
//        TicTacToe game = new TicTacToe(3, playerX, playerO, fakeUI);
//
//        game.setOwner(0, 0, playerX);
//
//        Cell cell = game.getBoard()[0][0];
//        assertEquals(playerX, cell.getOwner());
//    }
//
//    @Test
//    public void test_hasNoOwner() {
//        UserInteractionTest fakeUI = new UserInteractionTest();
//        ArtificialPlayer playerX = new ArtificialPlayer("X");
//        ArtificialPlayer playerO = new ArtificialPlayer("O");
//
//        TicTacToe game = new TicTacToe(3, playerX, playerO, fakeUI);
//
//        Cell cell = game.getBoard()[0][0];
//        assertTrue(cell.hasNoOwner(), "The cell must have no owner at the begining");
//
//    }
//
//    @Test
//    public void test_hasOwner() {
//        UserInteractionTest fakeUI = new UserInteractionTest();
//        ArtificialPlayer playerX = new ArtificialPlayer("X");
//        ArtificialPlayer playerO = new ArtificialPlayer("O");
//
//        TicTacToe game = new TicTacToe(3, playerX, playerO, fakeUI);
//
//        Cell cell = game.getBoard()[0][0];
//        game.setOwner(0, 0, playerX);
//        assertEquals(playerX, cell.getOwner());
//    }
//
//@Test
//    public void test_isOver_by_line(){
//        UserInteractionTest fakeUI = new UserInteractionTest();
//        ArtificialPlayer playerX = new ArtificialPlayer("X");
//        ArtificialPlayer playerO = new ArtificialPlayer("O");
//
//        TicTacToe game = new TicTacToe(3, playerX, playerO, fakeUI);
//
//    game.setOwner(0, 0, playerX);
//    game.setOwner(0, 1, playerX);
//    game.setOwner(0, 2, playerX);
//
//    assertTrue(game.isOver(), "The game should assert a win on line 0");
//}
//
//    @Test
//    public void test_isOver_by_column(){
//        UserInteractionTest fakeUI = new UserInteractionTest();
//        ArtificialPlayer playerX = new ArtificialPlayer("X");
//        ArtificialPlayer playerO = new ArtificialPlayer("O");
//
//        TicTacToe game = new TicTacToe(3, playerX, playerO, fakeUI);
//
//        game.setOwner(0, 0, playerX);
//        game.setOwner(1, 0, playerX);
//        game.setOwner(2, 0, playerX);
//
//        assertTrue(game.isOver(), "The game should assert a win on column 0");
//    }
//
//    @Test
//    public void test_isOver_by_first_diagonal(){
//        UserInteractionTest fakeUI = new UserInteractionTest();
//        ArtificialPlayer playerX = new ArtificialPlayer("X");
//        ArtificialPlayer playerO = new ArtificialPlayer("O");
//
//        TicTacToe game = new TicTacToe(3, playerX, playerO, fakeUI);
//
//        game.setOwner(0, 0, playerX);
//        game.setOwner(1, 1, playerX);
//        game.setOwner(2, 2, playerX);
//
//        assertTrue(game.isOver(), "The game should assert a win on diagonal 0");
//    }
//
//    @Test
//    public void test_isOver_by_second_diagonal(){
//        UserInteractionTest fakeUI = new UserInteractionTest();
//        ArtificialPlayer playerX = new ArtificialPlayer("X");
//        ArtificialPlayer playerO = new ArtificialPlayer("O");
//
//        TicTacToe game = new TicTacToe(3, playerX, playerO, fakeUI);
//
//        game.setOwner(0, 2, playerX);
//        game.setOwner(1, 1, playerX);
//        game.setOwner(2, 0, playerX);
//
//        assertTrue(game.isOver(), "The game should assert a win on diagonal 0");
//    }
//
//    @Test
//    public void test_isOver_fullBoard_draw() {
//        UserInteractionTest fakeUI = new UserInteractionTest();
//        ArtificialPlayer playerX = new ArtificialPlayer("X");
//        ArtificialPlayer playerO = new ArtificialPlayer("O");
//
//        TicTacToe game = new TicTacToe(3, playerX, playerO, fakeUI);
//        game.setOwner(0, 0, playerX);
//        game.setOwner(0, 1, playerO);
//        game.setOwner(0, 2, playerX);
//        game.setOwner(1, 0, playerX);
//        game.setOwner(1, 1, playerO);
//        game.setOwner(1, 2, playerO);
//        game.setOwner(2, 0, playerO);
//        game.setOwner(2, 1, playerX);
//        game.setOwner(2, 2, playerX);
//
//        assertTrue(game.isOver(), "The game must be over, full board without winner");
//        assertNull(game.getWinner(), "No player must have won, it's a draw");
//    }
//
//}

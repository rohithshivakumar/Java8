package Games;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Rohith Shivakumar on 4/13/2016.
 */
public class TicTacToeTest {
    TicTacToe ticTacToe = null;
    @Before
    public void setUp() throws Exception {
        ticTacToe = new TicTacToe();
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * Blue is the winner due to column
     * @throws Exception
     */
    @Test
    public void test1TicTacToe() throws Exception {
        TicTacToe.Pawns[][] board =
                new TicTacToe.Pawns[][]{
                        {TicTacToe.Pawns.empty, TicTacToe.Pawns.blue, TicTacToe.Pawns.empty},
                        {TicTacToe.Pawns.empty, TicTacToe.Pawns.blue, TicTacToe.Pawns.red},
                        {TicTacToe.Pawns.empty, TicTacToe.Pawns.blue, TicTacToe.Pawns.red}};
        TicTacToe.Pawns winner = TicTacToe.Pawns.blue;

        TicTacToe.Pawns result = ticTacToe.whoWon(board);
        Assert.assertEquals("Passed blue pawn column winner",winner, result);
    }

    /**
     * Initial board, nobody is the winner
     * @throws Exception
     */
    @Test
    public void test2TicTacToe() throws Exception {
        TicTacToe.Pawns[][] board =
                new TicTacToe.Pawns[][]{
                        {TicTacToe.Pawns.empty, TicTacToe.Pawns.empty, TicTacToe.Pawns.empty},
                        {TicTacToe.Pawns.empty, TicTacToe.Pawns.empty, TicTacToe.Pawns.empty},
                        {TicTacToe.Pawns.empty, TicTacToe.Pawns.empty, TicTacToe.Pawns.empty}};
        TicTacToe.Pawns winner = TicTacToe.Pawns.empty;

        TicTacToe.Pawns result = ticTacToe.whoWon(board);
        Assert.assertEquals("Passed empty pawn no winner",winner, result);
    }

    /**
     * Red is winner due to row
     * @throws Exception
     */
    @Test
    public void test3TicTacToe() throws Exception {
        TicTacToe.Pawns[][] board =
                new TicTacToe.Pawns[][]{
                        {TicTacToe.Pawns.empty, TicTacToe.Pawns.blue, TicTacToe.Pawns.empty},
                        {TicTacToe.Pawns.empty, TicTacToe.Pawns.blue, TicTacToe.Pawns.blue},
                        {TicTacToe.Pawns.red, TicTacToe.Pawns.red, TicTacToe.Pawns.red}};
        TicTacToe.Pawns winner = TicTacToe.Pawns.red;

        TicTacToe.Pawns result = ticTacToe.whoWon(board);
        Assert.assertEquals("Passed red pawn row winner",winner, result);
    }

    /**
     * Red is winner due to principal diagonal
     * @throws Exception
     */
    @Test
    public void test4TicTacToe() throws Exception {
        TicTacToe.Pawns[][] board =
                new TicTacToe.Pawns[][]{
                        {TicTacToe.Pawns.red, TicTacToe.Pawns.blue, TicTacToe.Pawns.empty},
                        {TicTacToe.Pawns.blue, TicTacToe.Pawns.red, TicTacToe.Pawns.blue},
                        {TicTacToe.Pawns.red, TicTacToe.Pawns.blue, TicTacToe.Pawns.red}};
        TicTacToe.Pawns winner = TicTacToe.Pawns.red;

        TicTacToe.Pawns result = ticTacToe.whoWon(board);
        Assert.assertEquals("Passed red pawn principal diagonal winner",winner, result);
    }
}

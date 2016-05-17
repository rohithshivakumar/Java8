package Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Rohith Shivakumar on 4/26/2016.
 */
public class DivingBoardTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void divingBoardTest() throws Exception {
        DivingBoard divingBoard = new DivingBoard(2,3,4);
        int numOfBoardLengths = divingBoard.getNumberOfBoardLengths();
        Assert.assertEquals("5 diving boards",5,numOfBoardLengths);
    }


    /**
     * Corner case - planks are of same size
     * @throws Exception
     */
    @Test
    public void divingBoardTest1() throws Exception {
        DivingBoard divingBoard = new DivingBoard(2,2,4);
        int numOfBoardLengths = divingBoard.getNumberOfBoardLengths();
        Assert.assertEquals("1 diving boards",1,numOfBoardLengths);
    }


    /**
     * Corner case - board size is 0
     * @throws Exception
     */
    @Test
    public void divingBoardTest2() throws Exception {
        DivingBoard divingBoard = new DivingBoard(2,3,0);
        int numOfBoardLengths = divingBoard.getNumberOfBoardLengths();
        Assert.assertEquals("0 diving boards",0,numOfBoardLengths);
    }

    /**
     * Corner case - number of planks to form the board is only 1
     * @throws Exception
     */
    @Test
    public void divingBoardTest3() throws Exception {
        DivingBoard divingBoard = new DivingBoard(2,3,1);
        int numOfBoardLengths = divingBoard.getNumberOfBoardLengths();
        Assert.assertEquals("1 plank diving boards",2,numOfBoardLengths);
    }
}

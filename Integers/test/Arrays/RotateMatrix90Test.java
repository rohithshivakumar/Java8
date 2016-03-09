package Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by srohith85 on 2/16/16.
 */
public class RotateMatrix90Test {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testRotateMatrix() throws Exception {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6}};
        int[][] expected =  new int[][]{{4,1},{5,2},{6,3}};
        RotateMatrix90 rotateMatrix90 = new RotateMatrix90();
        int[][] result = rotateMatrix90.rotateMatrixRightNotInplace(matrix);
        assertArrayEquals(result,expected);

        matrix = new int[][]{{1,2},{3,4}};
        expected =  new int[][]{{3,1},{4,2}};
        result = rotateMatrix90.rotateMatrixRightNotInplace(matrix);
        assertArrayEquals(result,expected);
    }
}
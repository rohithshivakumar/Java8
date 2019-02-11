package Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 3/2/2016.
 */
public class SmallestSubArrayTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSmallestSubArray() throws Exception {
        int[] A = {2, 2, 4, 5, 8, 9};
        int[] B = {2, 5, 9};

        SmallestSubArray.smallestSubsetInOrder(A,B);



//        int[][] result = TransposeMatrix.transposeMatrixExtraMemory(m,m.length,m[0].length);
//        //assertTrue("Result does not match",compareMatrix(result,expected));
//        assertArrayEquals(result,expected);
//
//        m = new int[][]{{1,2},{3,4}};
//        expected =  new int[][]{{1,3},{2,4}};
//        result = TransposeMatrix.transposeMatrixExtraMemory(m,m.length,m[0].length);
//        assertArrayEquals(result,expected);


    }
}
package Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 3/2/2016.
 */
public class TransposeMatrixTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    //Function needed if interviewer asks and there is no assertarrayequals function available
    private boolean compareMatrix(int[][] result , int[][] expected){
        if(result.length != expected.length || result[0].length != expected[0].length){
            return  false;
        }
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){

                if(result[i][j] != expected[i][j]){
                    return  false;
                }
            }
        }
        return true;
    }

    @Test
    public void testTransposeMatrixExtraMemory() throws Exception {
        int[][] m = new int[][]{{1,2,3},{4,5,6}};
        int[][] expected =  new int[][]{{1,4},{2,5},{3,6}};
        TransposeMatrix.printMatrix(m);
        int[][] result = TransposeMatrix.transposeMatrixExtraMemory(m,m.length,m[0].length);
        //assertTrue("Result does not match",compareMatrix(result,expected));
        assertArrayEquals(result,expected);

        m = new int[][]{{1,2},{3,4}};
        expected =  new int[][]{{1,3},{2,4}};
        result = TransposeMatrix.transposeMatrixExtraMemory(m,m.length,m[0].length);
        assertArrayEquals(result,expected);


    }
}
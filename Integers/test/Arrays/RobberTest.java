package Arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by arjun on 7/5/16.
 */
public class RobberTest {
    @Test
    public void robTest() throws Exception {

        int res = Robber.maxVal(new int[]{6, 7, 1, 3, 8, 2, 4});
        System.out.println(res);
        assertEquals(19 , res);
    }

}
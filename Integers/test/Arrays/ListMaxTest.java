package Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun on 7/17/16.
 */
public class ListMaxTest {
    @Test
    public void getMax() throws Exception {
        String[] input = new String[3];
        input[0] = "1 2 100";
        input[1] = "2 5 100";
        input[2] = "3 4 100";

        long max = ListMax.getMax(5,3,input);
        assertEquals(200,max);

    }

}
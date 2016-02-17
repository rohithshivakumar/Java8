package Integers;

import Integers.OneThirdSeries;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 2/15/2016.
 */
public class OneThirdSeriesTest {

    @Test
    public void testIsOneThird() throws Exception {
        int[] arr = new int[]{1,2,-1,4,6,5,8,9,0};
        assertFalse(OneThirdSeries.isOneThird(arr));

        arr = new int[]{1,2,-1};
        assertTrue(OneThirdSeries.isOneThird(arr));

        arr = new int[]{100,2,4,4,4,4,9,10,11,13,5,6,2};
        assertTrue(OneThirdSeries.isOneThird(arr));

        arr = new int[]{1};
        assertTrue(OneThirdSeries.isOneThird(arr));

        arr = new int[]{1,2,3,4,5,5,5,5,5,5};
        assertTrue(OneThirdSeries.isOneThird(arr));

    }
}
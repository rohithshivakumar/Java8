package Arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by arjun on 7/5/16.
 */
public class WaveTest {
    @Test
    public void waveTest() throws Exception {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[]{5, 1, 3, 2, 4}));
        ArrayList<Integer> res = Wave.wave(arr);
        System.out.println(res);
        assertEquals(res, new ArrayList<Integer>(Arrays.asList(new Integer[]{2, 1, 4, 3, 5})));
    }

}
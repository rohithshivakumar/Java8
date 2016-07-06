package Arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by arjun on 7/5/16.
 */
public class NumRangeTest {
    @Test
    public void numRange() throws Exception {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[]{ 10,5,1,0,2}));
        int res = NumRange.numRange(arr,6, 8);
        System.out.println(res);
        assertEquals(3,res);

        arr = new ArrayList<>(Arrays.asList(new Integer[]{76, 22, 81, 77, 95, 23, 27, 35, 24, 38, 15, 90, 19, 46, 53, 6, 77, 96, 100, 85, 43, 16, 73, 18, 7, 66}));
        res = NumRange.numRange(arr, 98, 290);
        System.out.println(res);
        assertEquals(84,res);

        arr = new ArrayList<>(Arrays.asList(new Integer[]{ 80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90}));
        res = NumRange.numRange(arr,99, 269);
        System.out.println(res);
        assertEquals(58,res);
    }

}
package Arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by araja on 7/3/16.
 */
public class TrappingRainWaterTest {
    @Test
    public void trappingRainWater() throws Exception {

        int[] arr = new int[] {3,0,0,2,0,4};
        TrappingRainWater test= new TrappingRainWater();
        assertEquals(10,test.findWater(arr));
        assertEquals(test.findWater(arr), test.findWaterNoExtraMem(arr));

        arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assertEquals(6,test.findWater(arr));
        assertEquals(test.findWater(arr), test.findWaterNoExtraMem(arr));

    }

}
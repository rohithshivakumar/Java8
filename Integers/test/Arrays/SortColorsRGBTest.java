package Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 6/23/2016.
 */
public class SortColorsRGBTest {

    @Test
    public void testSortColors() throws Exception {
        int[] nums = new int[]{1,0};
        SortColorsRGB.sortColors(nums);
        assertArrayEquals(new int[]{0,1}, nums);

        nums = new int[]{0,1,0,2,2,1,0};
        SortColorsRGB.sortColors(nums);
        assertArrayEquals(new int[]{0,0,0,1,1,2,2}, nums);

        nums = new int[]{0,0,1,1,1,1,1,1};
        SortColorsRGB.sortColors(nums);
        assertArrayEquals(new int[]{0,0,1,1,1,1,1,1}, nums);

        nums = new int[]{1,1,1,1,1,1};
        SortColorsRGB.sortColors(nums);
        assertArrayEquals(new int[]{1,1,1,1,1,1}, nums);
    }
}
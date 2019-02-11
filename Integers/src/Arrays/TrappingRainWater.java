package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Input: arr[]   = {2, 0, 2}
 Output: 2
 Structure is like below
 | |
 |_|
 We can trap 2 units of water in the middle gap.

 Input: arr[]   = {3, 0, 0, 2, 0, 4}
 Output: 10
 Structure is like below
 |
 |    |
 |  | |
 |__|_|
 We can trap "3*2 units" of water between 3 an 2,
 "1 unit" on top of bar 2 and "3 units" between 2
 and 4.  See below diagram also.

 Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 Output: 6
 |
 |   || |
 _|_||_||||||
 Trap "1 unit" between first 1 and 2, "4 units" between
 first 2 and 3 and "1 unit" between second last 1 and last 2

 https://www.geeksforgeeks.org/trapping-rain-water/

 Company: Sony Playstation
**/

 public class TrappingRainWater {
    static int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    // Method for maximum amount of water
    public int findWater(int arr[])
    {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[arr.length];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[arr.length];

        // Initialize result
        int water = 0;

        int n = arr.length;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i-1], arr[i]);

        // Fill right array
        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--)
            right[i] = Math.max(right[i+1], arr[i]);

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
            water += Math.min(left[i],right[i]) - arr[i];

        return water;
    }

    public int findWaterNoExtraMem(int arr[])
    {

        int low = 0, high = arr.length - 1;
        int water = 0;
        int lMax = 0;
        int rMax = 0;

        while(low <= high){

            //  |
            //|_|
            if(arr[low] < arr[high]) {
                if(arr[low] > lMax){
                    lMax = arr[low];
                } else {
                    water += lMax - arr[low];
                }
                low++;
            } else {

                //|
                //|_|
                if(arr[high] > rMax){
                    rMax = arr[high];

                } else {
                    water += rMax - arr[high];
                }
                high--;
            }


        }
        return water;

    }
}

package Integers;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given a number series, return true if there is even one number that appears more than 1/3rd the length of the series.
 * Else false.
 *
 * Clarifications
 * Integers (+ve and -ve)
 * Unsorted
 * Only constant additional space allowed (variables temporary)
 *
 *
 * Example :
 *
 *
 */

public class OneThirdSeries {
    public static boolean isOneThird(int[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        if (array.length == 1) return true;

        Arrays.sort(array);

        int size = array.length;
        int oneThirdSize = size / 3;
        int maxCount =0;
        int count = 0 ;
        int num = array[0];

        for(int i = 0; i<array.length; i++){
            if(array[i] == num){
                count ++;
                continue;
            }
            //else update the number to the array[i], and reset the counters
            //and check for maxCount
            if(count>maxCount)maxCount=count;
            count=1;
            num=array[i];
        }
        if(count>maxCount)maxCount=count;
        if(maxCount>= oneThirdSize){
            return true;
        }
        return false;
    }
}

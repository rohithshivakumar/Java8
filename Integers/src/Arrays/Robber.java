package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *   Find maximum possible stolen value from houses
     There are n houses build in a line, each of which contains some value in it. A thief is going to steal the maximal
     value of these houses, but he can’t steal in two adjacent houses because owner of the stolen houses will tell his
     two neighbour left and right side. What is the maximum stolen value.

     Examples:

     Input  : hval[] = {6, 7, 1, 3, 8, 2, 4}
     Output : 19
     Thief will steal 6, 1, 8 and 4 from house.

     Input  : hval[] = {5, 3, 4, 11, 2}
     Output : 16
     Thief will steal 5 and 11
 */
public class Robber {
    public static int maxVal(int[] houses) {

//        dp[i] = max (hval[i] + dp[i-2], dp[i-1])
//
//        hval[i] + dp[i-2] is the case when thief
//        decided to rob house i. In that situation
//        maximum value will be the current value of
//        house + maximum value stolen till last
//        robbery at house not adjacent to house
//        i which will be house i-2.
//
//        dp[i-1] is the case when thief decided not
//        to rob house i. So he will check adjacent
//        house for maximum value stolen till now.
       if(houses.length == 0 ) return  0;
       if(houses.length == 1 ) return  houses[0];
       if(houses.length == 2 ) return  Math.max(houses[0], houses[1]);

        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = houses[1];

        // Fill remaining positions
        for (int i = 2; i< houses.length; i++) {
            dp[i] = Math.max(houses[i] + dp[i - 2], dp[i - 1]);
            System.out.format("At i: %d, Max(%d,%d):%d \n", i , houses[i] + dp[i - 2],  dp[i - 1], Math.max(houses[i] + dp[i - 2], dp[i - 1]));
        }

        return dp[houses.length-1];
    }

    public  static int maxVal2(int[] houses){

        if(houses.length == 0) return 0;

        opts = maxVal2Rec(houses, houses.length -1);

        return Math.max(opts.)

    }


    public static opts maxVal2Rec(int[] houses, int curIndex){

        if(curIndex == 0){
            return  new opts(houses[0], 0);
        }

        opts prev = maxVal2(houses, curIndex-1);

        int with = houses[curIndex] + prev.without; //Since previous index cannot be included
        int without = Math.max(prev.without, prev.with);// if current index is not included , then it will be max of prev with and without

        return new opts(with,without);


    }


}



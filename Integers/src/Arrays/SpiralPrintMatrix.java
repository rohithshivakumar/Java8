package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Print  a 2d matrix in spiral form .
 Let us show you some examples to clarify what we mean.

 Example 1:

 Input:
 1    2   3   4
 5    6   7   8
 9   10  11  12
 13  14  15  16
 Output:
 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10


 Input:
 1   2   3   4  5   6
 7   8   9  10  11  12
 13  14  15 16  17  18
 Output:
 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 */
public class SpiralPrintMatrix {

    public ArrayList<Integer> spiralPrint(int m, int n, int[][] a) {


        ArrayList<Integer> res = new ArrayList<>();
        int i, k = 0, l = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */
        while (k < m && l < n)
        {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i)
            {
                res.add(a[k][i]);
                System.out.print(a[k][i]+" ");
            }
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < m; ++i)
            {
                res.add(a[i][n-1]);
                System.out.print(a[i][n-1]+" ");
            }
            n--;

            // Print the last row from the remaining rows */
            if ( k < m)
            {
                for (i = n-1; i >= l; --i)
                {
                    res.add(a[m-1][i]);
                    System.out.print(a[m-1][i]+" ");
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (l < n)
            {
                for (i = m-1; i >= k; --i)
                {
                    res.add(a[i][l]);
                    System.out.print(a[i][l]+" ");
                }
                l++;
            }
        }
        return res;

    }
}

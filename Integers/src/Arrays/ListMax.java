package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *You are given a list of size , initialized with zeroes. You have to perform  operations on the list and output the maximum of final values of all the  elements in the list. For every operation, you are given three integers ,  and  and you have to add value  to all the elements ranging from index  to (both inclusive).

 Input Format
 First line will contain two integers  and  separated by a single space.
 Next  lines will contain three integers ,  and  separated by a single space.
 Numbers in list are numbered from  to .

 Output Format
 A single line containing maximum value in the updated list.

 Sample Input #00

 5 3
 1 2 100
 2 5 100
 3 4 100
 Sample Output #00

 200

 */
public class ListMax {

    public static long getMax(int size , int count , String[] data) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        String line;
        String[] split ;

        int[] arr = new int[size+1];
        for(int i = 0 ; i <= size ; i++){
            arr[i] = 0;
        }
        long[] aArr = new long[size + 1];
        long[] bArr = new long[size + 1];
        //using 0th index for nothing
        int j =0;
        while( j < count){

            line = data[j];
            split = line.split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            long k = Integer.parseInt(split[2]);

            aArr[a] += k ;
            bArr[b] += k ;
            j++;
        }

        //find max
        long max = Long.MIN_VALUE;
        long sum = 0;

        for(int i =1; i <= size; i++){
            sum += aArr[i];
            if(sum > max){
                max = sum;
            }

            sum -= bArr[i];
        }

        System.out.println(max);
        return max;
    }


}

package Arrays;

import java.util.*;

/**
 * Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array.
 More formally,

 G[i] for an element A[i] = an element A[j] such that
 j is minimum possible AND
 j > i AND
 A[j] > A[i]
 Elements for which no greater element exist, consider next greater element as -1.

 Example:

 Input : A : [4, 5, 2, 10]
 Output : [5, 10, 10, -1]

 Example 2:

 Input : A : [3, 2, 1]
 Output : [-1, -1, -1]
 */
public class NextGreater {

    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {

        Integer[] inp = a.toArray(new Integer[a.size()]);
        Integer[] g = new Integer[a.size()];
        for(int i=0 ; i < a.size(); i++){
            g[i] = -1;
        }

        for(int i=0 ; i < a.size(); i++){
            for(int j = i+1; j < a.size(); j++){
                if(inp[j] > inp[i]){
                    g[i] = inp[j];
                    break;
                }

            }
        }

        return new ArrayList<>(Arrays.asList(g));
    }
}

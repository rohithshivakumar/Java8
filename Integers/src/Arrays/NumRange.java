package Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by arjun on 7/5/16.
 */
public class NumRange {
    public static int numRange(ArrayList<Integer> a, int b, int c) {
        if(a == null || a.size() == 0) {
            return 0;
        }


        int count = 0;
        int cSum = 0;

        for(int i=0; i < a.size() ; i++){
            cSum = a.get(i);
            if(cSum >=b && cSum <c){
                count++;
            }
            for(int j = i+1 ; j < a.size(); j++){

                int sum = cSum + a.get(j);
                if( sum > c){
                    cSum = 0;
                    break;
                }

                cSum = sum;

                if(cSum >= b){
                    count++;
                }
            }

        }

        return count;

    }
}

package Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by arjun on 7/5/16.
 */
public class Wave {
    public static ArrayList<Integer> wave(ArrayList<Integer> A) {

        Collections.sort(A);
        for(int i=0 ; i <= A.size()-2 ; i= i+2){

            System.out.println(i);
            Collections.swap(A, i, i+1);

        }

        return A;
    }
}

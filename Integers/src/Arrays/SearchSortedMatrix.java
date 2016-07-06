package Arrays;

import java.util.ArrayList;

/**
 * Created by arjun on 7/4/16.
 */
public class SearchSortedMatrix {

    public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int row = 0;
        int col =a.get(0).size()-1;

        while(row < a.size() && col >= 0){
            if(a.get(row).get(col) == b){
                return 1;
            }else if (a.get(row).get(col) > b){
                col--;
            }else{
                row++;
            }
        }

        return 0;

    }
}

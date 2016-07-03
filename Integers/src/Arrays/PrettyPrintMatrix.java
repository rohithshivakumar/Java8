package Arrays;
import java.util.*;

/**
 * Print concentric rectangular pattern in a 2d matrix.
 Let us show you some examples to clarify what we mean.

 Example 1:

 Input: A = 4.
 Output:

 4 4 4 4 4 4 4
 4 3 3 3 3 3 4
 4 3 2 2 2 3 4
 4 3 2 1 2 3 4
 4 3 2 2 2 3 4
 4 3 3 3 3 3 4
 4 4 4 4 4 4 4
 Example 2:

 Input: A = 3.
 Output:

 3 3 3 3 3
 3 2 2 2 3
 3 2 1 2 3
 3 2 2 2 3
 3 3 3 3 3
 The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

 You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 */
public class PrettyPrintMatrix {
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {


        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int size = (2 * a) - 1;

        Integer[][] op = new Integer[size][size];

        int layer = size -1;
        int num =a;
        int start =0;

        while(layer >= size/2){
            int off = start;
            for(int i =off ; i <=layer; i++) {

                op[off][i] = num;
                op[layer][i] = num;
            }

            for(int i = off+1 ; i < layer; i++) {


                op[i][off] = num;
                op[i][layer] = num;
            }

            layer--;
            start++;
            num--;
        }


        for(int i =0; i< size; i++){
            res.add(new ArrayList<Integer>(Arrays.asList(op[i])));
        }
        return res;

    }

    private void prettyPrint(int a , int off, Integer[][] op){
        if(a == 0) return;

        for(int i = off; i<= a; i++){

            op[off][i] = a;
            op[a][i] = a;
            op[i][off] = a;
            op[i][a] = a;
        }

        /*for(int i = off ; i < a -1; i++){
            ArrayList<Integer> row = op.get(i);
            if(row == null){
                row = new ArrayList<Integer>();
            }
            row.add(a-1, a);
            row.add(off, a);

        }*/

        prettyPrint(a -1 ,off+1,op);


    }


}

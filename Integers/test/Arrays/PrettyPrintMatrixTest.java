package Arrays;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by araja on 7/2/16.
 */
public class PrettyPrintMatrixTest {
    @Test
    public void prettyPrint() throws Exception {
        PrettyPrintMatrix matTest = new PrettyPrintMatrix();
        ArrayList<ArrayList<Integer>> op = matTest.prettyPrint(7);

        for(int i = 0 ; i< op.size() ; i ++){
            ArrayList<Integer> o = op.get(i);
            for(int j =0 ; j< o.size() ;j++){
                System.out.print(o.get(j) + " ");
            }
            System.out.println();
        }

    }

}
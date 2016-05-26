package RecursionAndDynamicProgramming;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * Child has to climb stairs and can do 1,2 or 3 steps at a time. Write a program given number of steps
 * how many ways a the child can get there */
public class ChildAndSteps {

    private static HashMap<Integer,BigInteger> table = new HashMap<>();

    public static BigInteger countRTopDown(int n){
        if(n < 0) {
            return BigInteger.ZERO;
        }
        if( n == 0){
            return BigInteger.ONE;
        }
        BigInteger count = BigInteger.ZERO;
        count = count.add(countRTopDown(n-1));
        count = count.add(countRTopDown(n-2));
        count = count.add(countRTopDown(n-3));

        return  count;
    }

    public static BigInteger countRTopDownWithTable(int n){
        if(n < 0) {
            return BigInteger.ZERO;
        }
        if( n == 0){
            return BigInteger.ONE;
        }
        if(table.containsKey(n)){
            return table.get(n);
        }
        BigInteger count = BigInteger.ZERO;
        count = count.add(countRTopDownWithTable(n-1));
        count = count.add(countRTopDownWithTable(n-2));
        count = count.add(countRTopDownWithTable(n-3));
        table.put(n,count);

        return  count;
    }

    public static BigInteger countBottomUp(int n){
        if(n < 0) {
            return BigInteger.ZERO;
        }
        BigInteger[] mem = new BigInteger[n+1];
        for(int i=0; i<= n; i++){
            mem[i] = BigInteger.ZERO;
        }

        mem[0] = BigInteger.ONE;
        mem[1] = BigInteger.ONE;
        mem[2] = BigInteger.valueOf(2);

       for(int i=3; i<= n; i++){
           mem[i] = mem[i].add(mem[i-1]);
           mem[i] = mem[i].add(mem[i-2]);
           mem[i] = mem[i].add(mem[i-3]);

       }

        return  mem[n];
    }
}

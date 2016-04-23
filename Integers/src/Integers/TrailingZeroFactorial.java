package Integers;

/**
 * Created by arjun_000 on 4/13/2016.
 */
public class TrailingZeroFactorial {

    public static int trailingZerosOfFactorial(int num){
        int count =0;
        for(int i=2 ; i<=num;i++){
            count += factorsOf5(i);
        }
        return count;
    }

    private static int factorsOf5(int number) {
        int count=0;
        while(number%5 == 0){
            count++;
            number = number/5;
        }
        return count;
    }

    public static int trailingZerosFactNewApproach(int num){
        int count =0;
        if(num < 0)return -1;
        for(int i=5 ; num/i > 0; i*=5){
            count += num/i;
        }
        return count;
    }
}

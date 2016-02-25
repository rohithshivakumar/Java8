package Integers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Given a number, return the closest palindrome
 *
 * Clarifications
 * 1. It is an integer
 * 2. num < 0 invalid
 * 3. single number is always a palindrome
 * 4. out of 2 equidistant palindrome, return the lowest in value. Ex For 131 ..121 & 141 are palindromes, we should return
 * 121
 * 5. If given num is palindrome, return the next closest palindrome and not the input
 */

public class NearestPalindromeEnhanced {

    private static Logger log = Logger.getLogger("NearestPalindromeEnhanced");

    public static void main(String args[]) {
        try {
            int num = 123456;
            String numStr = String.valueOf(num);

            NearestPalindromeEnhanced nearPalindrome = new NearestPalindromeEnhanced();
            StringBuilder sb = nearPalindrome.eval(new StringBuilder(numStr));
            System.out.println(sb.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            log.log(Level.SEVERE,"Exception in main()");
        }
    }

    public boolean isPalindrome(String str) {
        boolean isPalindrome = true;
        int length;
        try {
            if(null != str) {
                length = str.length();
                for(int i = 0, j = length-1; i < length/2; i++, j--) {
                    if(str.charAt(i) != str.charAt(j)) {
                        isPalindrome = false;
                        break;
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            log.log(Level.SEVERE,"Exception in isPalindrome()");
        }
        return isPalindrome;
    }

    public StringBuilder eval(StringBuilder str) {
        StringBuilder temp = new StringBuilder(str);
        try {
            if(null != temp) {
                for(int i = 0, j = temp.length() - 1; i < temp.length()/2; i++,j--) {
                    char begin = temp.charAt(i);
                    char end = temp.charAt(j);
                    if(begin != end) {
                        int beginInt = Character.getNumericValue(begin);
                        int endInt = Character.getNumericValue(end);
                        int diff;
                        if(beginInt > endInt) {
                            diff = beginInt - endInt;
                        }
                        else {
                            diff = endInt - beginInt;
                        }

                        int valToAdd = getValToAdd(i,diff);
                        String tempStr = temp.toString();
                        int tempInt = Integer.valueOf(tempStr);
                        tempInt = tempInt + valToAdd;

                        tempStr = String.valueOf(tempInt);
                        if(isPalindrome(tempStr)) {
                            temp = new StringBuilder(tempStr);
                            break;
                        }
                        temp = new StringBuilder(tempStr);
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            log.log(Level.SEVERE,"Exception in eval()");
        }
        return temp;
    }

    private int getValToAdd(int pos, int diff) {
        int valToAdd = 0;
        try {
            if(pos == 0) {
                valToAdd = diff;
            }
            else {
                for(int i = 0; i <= pos; i++) {
                    if(i == 0) {
                        valToAdd = diff;
                    }
                    else {
                        valToAdd = valToAdd * 10;
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            log.log(Level.SEVERE,"Exception in getValToAdd()");
        }
        return valToAdd;
    }
}

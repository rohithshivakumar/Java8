package Integers;

import java.util.ArrayList;
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
            int num = 654321;
            String numStr = String.valueOf(num);

            ArrayList<String> testCases = new ArrayList<>();
            testCases.add("102");
            testCases.add("131");
            testCases.add("54647");
            testCases.add("654321");

            NearestPalindromeEnhanced nearPalindrome = new NearestPalindromeEnhanced();

            for(String testCase : testCases) {
                StringBuilder sb = nearPalindrome.transformUtil(new StringBuilder(testCase),true);
                System.out.println(sb.toString());
                String valAdd = sb.toString();

                sb = nearPalindrome.transformUtil(new StringBuilder(numStr),false);
                System.out.println(sb.toString());
                String valSub = sb.toString();

                if(nearPalindrome.isPalindrome(valAdd))
                    System.out.println("Nearest palindrome is : " + valAdd);

                if(nearPalindrome.isPalindrome(valSub))
                    System.out.println("Nearest palindrome is : " + valSub);
            }
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

    /**
     * Transform the given number.
     * Transformation steps :
     *  1) Find the difference between the digits on same mirrored position determined by the mid point of the given number
     *  2) Based on their positions on the number (Decimal places - units, tenth, hundredth ....), get their values
     *     multiplied by their decimal place
     *  3) based on the sign to add or not, the number is added to the original number or subtracted
     * @param str : the number to whom the nearest palindrome has to be found
     * @param toAdd : true means add, else subtract
     * @return
     */
    public StringBuilder transformUtil(StringBuilder str, boolean toAdd) {
        StringBuilder temp = new StringBuilder(str);
        try {
            if(null != temp) {
                int i = 0, j = temp.length() - 1;
                while(i < temp.length()/2) {
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

                        int valToAdd = getValToAddOrSubtract(i, diff);
                        String tempStr = temp.toString();
                        int tempInt = Integer.valueOf(tempStr);
                        if(toAdd)
                            tempInt = tempInt + valToAdd;
                        else
                            tempInt = tempInt - valToAdd;

                        tempStr = String.valueOf(tempInt);
                        if(isPalindrome(tempStr)) {
                            temp = new StringBuilder(tempStr);
                            break;
                        }
                        temp = new StringBuilder(tempStr);
                    }
                    i++;
                    j--;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            log.log(Level.SEVERE,"Exception in eval()");
        }
        return temp;
    }

    private int getValToAddOrSubtract(int pos, int diff) {
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
            log.log(Level.SEVERE,"Exception in getValToAddOrSubtract()");
        }
        return valToAdd;
    }
}

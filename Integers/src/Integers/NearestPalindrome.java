package Integers;

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

public class NearestPalindrome {

    public static boolean isPalindrome(Integer num)throws Exception{
        String number = num.toString();
        int i =0;
        int j = number.length()-1;
        while(i<=j){
            if(number.toCharArray()[i] != number.toCharArray()[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

    public static int getNearestPalindrome(int number)throws Exception{
        //Validation
        if(!isValidInput(number)){
            throw  new IllegalArgumentException("Input number not valid");
        }

        //First go increasing

        int nextNum = number+1;

        while (nextNum <= Integer.MAX_VALUE){
            if(isPalindrome(nextNum)){
                break;
            }

            nextNum++;
        }

        //Second go decreasing
        int beforeNum = number-1;
        while (beforeNum >= 0){
            if(isPalindrome(beforeNum)){
                break;
            }
            beforeNum--;
        }

        //Compare distance from the actual number , return the minimum
        if((number - beforeNum) <= (nextNum -number)){
            return beforeNum;
        }
        return nextNum;
    }

    private static boolean isValidInput(int number) {
        if(number < 0) return false;
        return true;
    }

    public static int getClosestPalindrome(int number) throws Exception {
        int closestPalindrome = 0;
        String closestPalindromeStr;
        try {
            //Validation
            if(!isValidInput(number)){
                throw  new IllegalArgumentException("Input number not valid");
            }

            String numStr = String.valueOf(number);

            if(isAll9s(numStr)) {
                closestPalindromeStr = "1";
                for(int i = 1; i < numStr.length(); i++) {
                    closestPalindromeStr.concat("0");
                }
                closestPalindromeStr.concat("1");
            }
            else {
                closestPalindromeUtil(numStr);
            }
        }
        catch (Exception e) {
            System.out.println("getClosestPalindrome() threw Exception. " +  e);
            throw e;
        }
        return closestPalindrome;
    }

    private static boolean isAll9s(String num) throws Exception {
        try {
            for(int i = 0; i < num.length(); i++) {
                if(num.charAt(i) != '9') {
                    return false;
                }
            }
        }
        catch (Exception e) {
            System.out.println("isAll9s() threw Exception. " +  e);
            throw e;
        }
        return true;
    }

    private static int closestPalindromeUtil(String numStr) throws Exception {
        StringBuilder sb = new StringBuilder(numStr);
        try {
            int mid = numStr.length() / 2;
            boolean leftSmaller = false;
            int i = mid - 1;
            int j = (sb.length() % 2) == 1 ? mid + 1: mid;

            while (i >= 0 && numStr.charAt(i) == numStr.charAt(j)){
                i--;
                j++;
            }

            if( i < 0 || numStr.charAt(i) < numStr.charAt(j))
                leftSmaller = true;

            while (i >= 0) {
                sb.setCharAt(j,sb.charAt(i));
                j++;
                i--;
            }

            if(leftSmaller == true) {
                int carry = 1;
                i = mid - 1;

                if(sb.length() % 2 == 1) {
                    Character c = numStr.charAt(mid);
                    int numVal = Character.getNumericValue(c);
                    numVal += carry;
                    carry = numVal / 10;
                    numVal = numVal % 10;
                    sb.setCharAt(mid, (char) numVal);
                    j = mid + 1;
                }
                else {
                    j = mid;
                }

                while (i >= 0) {
                    Character c = numStr.charAt(i);
                    int numVal = Character.getNumericValue(c);
                    numVal += carry;
                    carry = numVal / 10;
                    numVal = numVal % 10;
                    sb.setCharAt(i, (char) numVal);
                    sb.setCharAt(j++,sb.charAt(i--));
                }
            }
        }
        catch (Exception e) {
            System.out.println("closestPalindromeUtil() threw Exception. " +  e);
            throw e;
        }
        return Integer.parseInt(sb.toString());
    }
}

package Integers;

import sun.applet.Main;

import java.util.Stack;

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

    public int getNearestPalindrome(int number)throws Exception{
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
        if((number - beforeNum) < (nextNum -number)){
            return beforeNum;
        }
        return nextNum;
    }

    private boolean isValidInput(int number) {
        if(number < 0) return false;
        return true;
    }

}

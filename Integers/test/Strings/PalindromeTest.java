package Strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by araja on 7/2/16.
 */
public class PalindromeTest {
    @Test
    public void isPalindrome() throws Exception {

        Palindrome p = new Palindrome();
        assertEquals(1,p.isPalindrome("A man, a plan, a canal: Panama"));
        assertEquals(0,p.isPalindrome("race a car"));


    }

}
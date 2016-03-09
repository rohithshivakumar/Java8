package Integers;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 2/15/2016.
 */
public class NearestPalindromeTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testIsPalindrome() throws Exception {
        assertTrue(NearestPalindrome.isPalindrome(101));
        assertTrue(NearestPalindrome.isPalindrome(54745));
        assertFalse(NearestPalindrome.isPalindrome(100));
        assertFalse(NearestPalindrome.isPalindrome(1000));
    }

    @org.junit.Test
    public void testGetNearestPalindrome() throws Exception {
        int num = NearestPalindrome.getNearestPalindrome(99);
        assertEquals(num,101);
        num = NearestPalindrome.getNearestPalindrome(131);
        assertEquals(num,121);
        num = NearestPalindrome.getNearestPalindrome(54647);
        assertEquals(num,54645);

        num = NearestPalindrome.getClosestPalindrome(1);
        assertEquals(num,0);
        num = NearestPalindrome.getClosestPalindrome(9);
        assertEquals(num,8);
        num = NearestPalindrome.getClosestPalindrome(99);
        assertEquals(num,101);
        num = NearestPalindrome.getClosestPalindrome(131);
        assertEquals(num,141);
        num = NearestPalindrome.getClosestPalindrome(54647);
        assertEquals(num,54645);
    }
}
package Strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 3/8/2016.
 */
public class GameOfThronesTest {

    @Test
    public void testIsAnagramStringPalindrome() throws Exception {
        assertTrue(GameOfThrones.isAnagramStringPalindrome("aaabbbb"));
        assertFalse(GameOfThrones.isAnagramStringPalindrome("cdefghmnopqrstuvw"));
        assertTrue(GameOfThrones.isAnagramStringPalindrome("cdcdcdcdeeeef"));
    }
}
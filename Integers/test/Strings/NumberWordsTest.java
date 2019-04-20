package Strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by arjun_000 on 3/8/2016.
 */
public class NumberWordsTest {

    @Test
    public void testConvertNumber() throws Exception {

        assertEquals(955,NumberWords.convertNumberToWord("Nine Hundred Fifty Five"));
        assertEquals(5800000, NumberWords.convertNumberToWord("five million eight hundred thousand"));
        assertEquals(100, NumberWords.convertNumberToWord("one hundred"));
        assertEquals(100, NumberWords.convertNumberToWord("hundred"));
        assertEquals(1050, NumberWords.convertNumberToWord("thousand fifty"));
        assertEquals(2019, NumberWords.convertNumberToWord("two thousand nineteen"));
        assertEquals(2019, NumberWords.convertNumberToWord("twenty nineteen"));
        //assertEquals(3100, NumberWords.convertNumberToWord("three thousand hundred"));
    }
}
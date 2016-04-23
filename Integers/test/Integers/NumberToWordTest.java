package Integers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 4/23/2016.
 */
public class NumberToWordTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConvertNumberToWord() throws Exception {
        String word = NumberToWord.convertNumberToWord(0);
        System.out.println(word);
        assertTrue(word.toLowerCase().contains("zero"));
        word = NumberToWord.convertNumberToWord(126);
        System.out.println(word);
        assertTrue(word.toLowerCase().contains("one hundred twenty six"));
        word = NumberToWord.convertNumberToWord(4500);
        System.out.println(word);
        assertTrue(word.toLowerCase().contains("four thousand five hundred "));
        word = NumberToWord.convertNumberToWord(45001);
        System.out.println(word);
        assertTrue(word.toLowerCase().contains("forty five thousand one"));
        word = NumberToWord.convertNumberToWord(646283676);
        System.out.println(word);
        assertTrue(word.toLowerCase().contains("six hundred forty six million two hundred eighty three thousand six hundred seventy six "));
        word = NumberToWord.convertNumberToWord(-646283676);
        System.out.println(word);
        assertTrue(word.toLowerCase().contains("negative six hundred forty six million two hundred eighty three thousand six hundred seventy six"));

    }
}
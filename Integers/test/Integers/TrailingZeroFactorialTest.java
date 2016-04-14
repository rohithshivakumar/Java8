package Integers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 4/13/2016.
 */
public class TrailingZeroFactorialTest {

    @Test
    public void testTrailingZerosOfFactorial() throws Exception {

        assertTrue("Trailing zeros should be 1", TrailingZeroFactorial.trailingZerosOfFactorial(5)==1);
        assertTrue("Trailing zeros should be 3", TrailingZeroFactorial.trailingZerosOfFactorial(19)==3);
    }

    @Test
    public void testTrailingZerosFactNewApproach() throws Exception {
        assertTrue("Trailing zeros should be 1", TrailingZeroFactorial.trailingZerosFactNewApproach(5)==1);
        assertTrue("Trailing zeros should be 3", TrailingZeroFactorial.trailingZerosFactNewApproach(19)==3);
    }

    @Test
    public void testCompareResultsFrom2Approaches() throws Exception {

        assertTrue("Trailing zeros should be 1", TrailingZeroFactorial.trailingZerosOfFactorial(5)
                == TrailingZeroFactorial.trailingZerosFactNewApproach(5));
        assertTrue("Trailing zeros should be 3", TrailingZeroFactorial.trailingZerosOfFactorial(19) ==
                TrailingZeroFactorial.trailingZerosFactNewApproach(19));
    }
}
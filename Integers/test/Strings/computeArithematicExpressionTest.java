package Strings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 5/15/2016.
 */
public class computeArithematicExpressionTest {
    computeArithematicExpression computeArithematicExpression;

    @Before
    public void setUp() throws Exception {

        computeArithematicExpression = new computeArithematicExpression();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCompute() throws Exception {
        double val = computeArithematicExpression.compute("4+5");
        System.out.println(val);
        assertTrue(val==9);

        val = computeArithematicExpression.compute("2-6-7*8/2+5");
        System.out.println(val);
        assertTrue(val== -27);

        val = computeArithematicExpression.compute("-7-9");
        System.out.println(val);
        assertTrue(val== -16);

        val = computeArithematicExpression.compute("-7*9/5+2");
        System.out.println(val);
        assertTrue(val== -10.2);

    }
}
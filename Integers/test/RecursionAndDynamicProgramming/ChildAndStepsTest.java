package RecursionAndDynamicProgramming;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 5/25/2016.
 */
public class ChildAndStepsTest {

    @Test
    public void testCountRTopDown() throws Exception {
         BigInteger result =  ChildAndSteps.countRTopDown(4);
        System.out.println("Result is : "+ result.intValue());
        assertEquals(7,result.intValue());
        result =  ChildAndSteps.countRTopDown(5);
        System.out.println("Result is : "+ result.intValue());
        assertEquals(13,result.intValue());
        result =  ChildAndSteps.countRTopDown(6);
        System.out.println("Result is : "+ result.intValue());
        assertEquals(24,result.intValue());
    }

    @Test
    public void testCountBottomUp() throws Exception {
        BigInteger result =  ChildAndSteps.countBottomUp(4);
        System.out.println("Result is : "+ result.intValue());
        assertEquals(7,result.intValue());
        result =  ChildAndSteps.countBottomUp(5);
        System.out.println("Result is : "+ result.intValue());
        assertEquals(13,result.intValue());
        result =  ChildAndSteps.countBottomUp(6);
        System.out.println("Result is : "+ result.intValue());
        assertEquals(24,result.intValue());

    }

    @Test
    public void testCountRTopDownWithTable() throws Exception {
        BigInteger result =  ChildAndSteps.countRTopDownWithTable(4);
        System.out.println("Result is : "+ result.intValue());
        assertEquals(7,result.intValue());
        result =  ChildAndSteps.countRTopDownWithTable(5);
        System.out.println("Result is : "+ result.intValue());
        assertEquals(13,result.intValue());
        result =  ChildAndSteps.countRTopDownWithTable(6);
        System.out.println("Result is : "+ result.intValue());
        assertEquals(24,result.intValue());
    }

    @Test
    public void testCountWithComparison() throws Exception {
        BigInteger result =  ChildAndSteps.countRTopDownWithTable(4);
        System.out.println("Result is : "+ result.intValue());
        assertEquals(ChildAndSteps.countBottomUp(4).intValue(),result.intValue());
        result =  ChildAndSteps.countRTopDownWithTable(5);
        System.out.println("Result is : "+ result.intValue());
        assertEquals(ChildAndSteps.countBottomUp(5).intValue(),result.intValue());
        result =  ChildAndSteps.countRTopDownWithTable(6);
        System.out.println("Result is : "+ result.intValue());
        assertEquals(ChildAndSteps.countBottomUp(6).intValue(),result.intValue());
    }
}
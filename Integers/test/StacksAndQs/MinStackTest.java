package StacksAndQs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 6/23/2016.
 */
public class MinStackTest {

    @Test
    public void testMin() throws Exception {

        MinStack minStack = new MinStack();
        minStack.push(3);
        assertEquals(3,minStack.min());
        minStack.push(5);
        assertEquals(3,minStack.min());
        minStack.push(1);
        assertEquals(1,minStack.min());
        minStack.push(7);
        assertEquals(1,minStack.min());
        minStack.pop();
        assertEquals(1,minStack.min());
        minStack.pop();
        assertEquals(3,minStack.min());

    }
}
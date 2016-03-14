package Strings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 3/8/2016.
 */
public class PangramTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsPangramNoExtraSpace() throws Exception {

    }

    @Test
    public void testIsPangramExtraSpace() throws Exception {
        assertTrue(Pangram.isPangramExtraSpace("The quick brown fox jumps over the lazy dog"));
        assertFalse(Pangram.isPangramExtraSpace("I am a FBI agent"));
        assertFalse(Pangram.isPangramExtraSpace(""));
    }
}
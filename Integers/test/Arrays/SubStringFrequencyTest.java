package Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 6/2/2016.
 */
public class SubStringFrequencyTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindSubStrings() throws Exception {
        assertEquals(1, SubStringFrequency.findSubStrings("abcde",5,2,4,26));
        assertEquals(3, SubStringFrequency.findSubStrings("ababab",6,2,3,4));

    }

}
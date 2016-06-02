package Strings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Rohith Shivakumar on 6/1/2016.
 */
public class MissingWordsTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsPangramExtraSpace() throws Exception {
        String s = "My name is Rohith Shivakumar";
        String t = "name is Rohith";
        List<String> missingWords = new ArrayList<String>();
        missingWords.add("My");
        missingWords.add("Shivakumar");
        assertEquals(MissingWords.missingWords(s, t), missingWords);
    }
}

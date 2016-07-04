package Arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by araja on 7/3/16.
 */
public class SearchRotatedArrayTest {
    @Test
    public void rotatedArraySearch() throws Exception {

        List<Integer> rArr = new ArrayList<>((Arrays.asList(new Integer[]{4,5,6,7,0,1,2})));
        SearchRotatedArray test= new SearchRotatedArray();
        assertEquals(test.RotatedArratSearch(rArr,5,false), test.RotatedArratSearch(rArr,5,false));

    }

}
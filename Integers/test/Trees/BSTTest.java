package Trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 6/18/2016.
 */
public class BSTTest {

    @Test
    public void testInsert() throws Exception {

        BST tree = new BST("5,3,12,1,2,7,9");
        List<Integer> order = tree.inOrderBST();
        assertArrayEquals(new Integer[]{1,2,3,5,7,9,12}, order.toArray());

    }
}
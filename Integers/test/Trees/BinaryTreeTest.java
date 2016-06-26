package Trees;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by araja on 6/25/16.
 */
public class BinaryTreeTest {
    @Test
    public void buildTree() throws Exception {
        String treeStr = "1,2,4,#,#,5,#,#,3,6,#,#,7,#,#";
        BinaryTree tree = new BinaryTree("1,2,4,#,#,5,#,#,3,6,#,#,7,#,#");
        assertArrayEquals(treeStr.split(","),tree.PreOrderTraversal().toArray());


    }

    @Test
    public void preOrderTraversal() throws Exception {

    }

}
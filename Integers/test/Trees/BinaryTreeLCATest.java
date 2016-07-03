package Trees;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by araja on 6/25/16.
 */
public class BinaryTreeLCATest {

    @Test
    public void getLCA() throws Exception {
        //Create Tree
        BinaryTree tree = new BinaryTree("1,2,4,#,#,5,#,#,3,6,#,#,7,#,#");

        BinaryTreeLCA treeLCA = new BinaryTreeLCA();
        TreeNode lca = treeLCA.getLCA(tree.getRoot(),tree.getNode(2),tree.getNode(4));
        assertEquals(lca.data, 2);
        lca = treeLCA.getLCA(tree.getRoot(),tree.getNode(2),tree.getNode(6));
        assertEquals(lca.data, 1);

        lca = treeLCA.getLCA(tree.getRoot(),tree.getNode(2),tree.getNode(14));
        assertNull(lca);

    }

}
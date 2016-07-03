package Trees;

/**
 * Given a binary tree root and 2 nodes in that tree , find the Lowest Common Ancestor of given 2 nodes.
      a
    /   \
   b     c
  / \   / \
 d   e f   g

 Ex: root = a , nod1 = d, node2 = f return a
 root =a , n1=d , n2=e  return b

 Trace:

 Test cases

 root = null
 root = a , n1 = d, n2 = f

 a, d,f
 b,d,f
 d,d,f -> return d
 e,f,f  -> return null
 return d
 c ,d,f
 f,d,f -> return f
 g,d,f -> return null

 return f

 both left & right are not null , hence LCA = a
 a
 /   \
 b     c
 / \   / \
 d   e f   g

 root = a , n1 = x, n2 = f

 a, x,f
 b,x,f
 d,x,f
 null, x, f -> return null;
 null,x, f -> return null
 return right if d which is null
 e,f,f  -> return null
 return null
 c ,d,f
 f,d,f -> return f
 g,d,f -> return null

 return f

 Asked in n2g4n1yc
 */
public class BinaryTreeLCA {

    TreeNode getLCA(TreeNode root, TreeNode n1, TreeNode n2){
       if(!validateNode(root, n1) || !validateNode(root, n2)){
            return null;
       }
        return getLCACore(root, n1,n2);

    }

    private boolean validateNode(TreeNode root, TreeNode node) {
        if(root == null) return false;

        if(root == node)return true;
        return validateNode(root.left,node) ||
                validateNode(root.right, node);
    }

    TreeNode getLCACore(TreeNode root, TreeNode n1, TreeNode n2){

        if(root == null){
            return null;
        }

        if( n1 == root || n2 == root){
            return root;
        }

        TreeNode left = getLCACore(root.left, n1,n2);
        TreeNode right = getLCACore(root.right, n1, n2);

        if( left != null && right != null){
            return root;
        }else if ( left != null){
            return left;
        }else{
            return right;
        }
    }

}

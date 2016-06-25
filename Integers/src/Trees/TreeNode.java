package Trees;

/**
 *Class for Tree Node
 */
public class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data){
        this.data = data;
        left = null;
        right = null;
    }
}

package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary tree implementation with building a tree and writing it using preorder traversal
 */
public class BinaryTree {
    private class Result{
        TreeNode node;
        Integer currentIndex;

        public Result(TreeNode node ,Integer currentIndex) {
            this.currentIndex = currentIndex;
            this.node=node;
        }


    }

    private TreeNode<Integer> root;

    public TreeNode getNode(int value){

        TreeNode node = getNodeCore(getRoot(),value);
        return node;
    }

    private TreeNode getNodeCore(TreeNode<Integer> root, int value) {
        if(root == null){
            return null;
        }
        if(root.data == value)return root;
        TreeNode node = getNodeCore(root.left,value);
        if(node == null){
            node = getNodeCore(root.right, value);
        }
        return node;
    }

    private boolean checkNode( TreeNode node) {
        return checkNodeCore(getRoot(),node);
    }

    private boolean checkNodeCore(TreeNode<Integer> root, TreeNode node) {
        if(root == null){
            return false;
        }
        if(root == node)return true;
        return checkNodeCore(root.left,node) ||
                checkNodeCore(root.right, node);
    }

    public Result buildTree(String[] numbers, Integer currentIndex){
        if(currentIndex >= numbers.length) return null;
        if(numbers[currentIndex].equalsIgnoreCase("#")){
            currentIndex++;
            return new Result(null,currentIndex);
        }

        TreeNode<Integer> node = new TreeNode(Integer.parseInt(numbers[currentIndex]));
        currentIndex++;
        Result left = buildTree(numbers,currentIndex);
        node.left = left.node;
        Result right = buildTree(numbers,left.currentIndex);
        node.right = right.node;

       return new Result(node,right.currentIndex);
    }

    public BinaryTree(String values){
        if(values == null || values == ""){
            throw new IllegalArgumentException("Input is empty");
        }
        String[] numbers = values.split(",");
        Result r  = buildTree(numbers,0);
        root = r.node;
    }

    public TreeNode<Integer> getRoot() {
        return root;
    }

    public List<String> PreOrderTraversal(){
        List<String> inorderList = new ArrayList<>();
        PreOrder(root, inorderList);

        for(String data : inorderList){
            System.out.print(data + " ");
        }
        return inorderList;

    }

    private void PreOrder(TreeNode node, List<String> list){
        if(node == null) {
            list.add("#");
            return;
        }
        list.add(((Integer) node.data).toString());
        PreOrder(node.left,list);
        PreOrder(node.right,list);

    }
}

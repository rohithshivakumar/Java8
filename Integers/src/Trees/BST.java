package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arjun_000 on 6/18/2016.
 */
public class BST {
    private TreeNode<Integer> root;

    public void insert(Integer data){
        if(root == null){
            root = new TreeNode<Integer>(data);
            return;
        }
        insertNode(root,data);
    }

    public BST(String values){
        if(values == null || values == ""){
            throw new IllegalArgumentException("Input is empty");
        }
        String[] numbers = values.split(",");
        for(String num: numbers){
            insert(Integer.parseInt(num));
        }
    }

    private void  insertNode(TreeNode node, Integer data){
        if(data.compareTo((Integer) node.data) < 0){
            //insert left
            if(node.left == null ){
                node.left = new TreeNode(data);
                return;
            }
            insertNode(node.left, data);

        }

        if(data.compareTo((Integer) node.data) >= 0){
            //insert left
            if(node.right == null ){
                node.right = new TreeNode(data);
                return;
            }
            insertNode(node.right, data);

        }
    }

    public TreeNode<Integer> getRoot() {
        return root;
    }

    public List<Integer> inOrderBST(){
        List<Integer> inorderList = new ArrayList<>();
        inOrder(root, inorderList);

        for(Integer data : inorderList){
            System.out.print(data + " ");
        }
        return inorderList;

    }

    private void inOrder(TreeNode node, List<Integer> list){
        if(node == null) {
            return;
        }
        inOrder(node.left,list);
        list.add((Integer) node.data);
        inOrder(node.right,list);

    }
}

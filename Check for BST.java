/*
Given the root of a binary tree. Check whether it is a BST or not.
Note: We are considering that BSTs can not contain duplicate Nodes.
A BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/
class Solution {
    boolean isValid(Node root,Node min,Node max){
        if(root == null){
            return true;
        }
        
        if(min != null && min.data>= root.data){
            return false;
        }
        
        else if(max != null && max.data<=root.data){
            return false;
        }
        
        return isValid(root.left,min, root) && isValid(root.right, root,max);
    }
    boolean isBST(Node root) {
        // code here.
        if(isValid(root, null, null)){
            return true;
        }
        return false;
    }
}

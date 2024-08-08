/******************************************************************************
Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return true if it is a Sum Tree otherwise, return false.

A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree. 
An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.

*******************************************************************************/

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    int helper(Node root){
        //Base case
        if(root == null){
            return 0;
        }
        if(root.left == null & root.right == null){
            return root.data;
        }
        
        int left_sum = helper(root.left);
        int right_sum = helper(root.right);
        
        if(left_sum!=-1 && right_sum!=-1 && root.data == left_sum+right_sum){
            return root.data+left_sum+right_sum;
        }
        
        return -1;
    }
    boolean isSumTree(Node root) {
        // Your code here
        
        return helper(root)!=-1;
    }
}

/*
Given the root of a Binary Search Tree (BST) and two integers l and r, remove all the nodes whose values lie outside the range [l, r].

Note: The modified tree should also be BST and the sequence of the remaining nodes should not be changed.
*/
/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    Node removekeys(Node root, int l, int r) {
        // code here
        if(root == null) {
            return null;
        }
        
        root.left = removekeys(root.left, l, r);
        root.right = removekeys(root.right, l, r);
        
        if(root.data >= l && root.data <= r) {
            return root;
        }
        
        if(root.left != null) {
            return root.left;
        } else {
            return root.right;
        }
        
    }
}

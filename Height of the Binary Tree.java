/*
Given a binary tree, find its height.

The height of a tree is defined as the number of edges on the longest path from the root to a leaf node. A leaf node is a node that does not have any children.
*/
class Solution {
    // Function to find the height of a binary tree.

     int height(Node node) {
        // code here
        int ans = heightOfTree(node,0);
        return ans-1;
    }
    static int heightOfTree(Node root, int height){
        
        if(root==null) return height;
        
        int temp1=heightOfTree(root.left,height+1);
        int temp2=heightOfTree(root.right,height+1);
        
        height=Math.max(temp1,temp2);
        return height;
    }
}

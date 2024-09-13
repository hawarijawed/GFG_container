class Solution {
    // Function to convert a binary tree into its mirror tree.
    Node helper(Node node){
        if(node == null){
            return null;
        }
        
        Node left_node = helper(node.left);
        Node right_node = helper(node.right);
        node.left = right_node;
        node.right = left_node;
        return node;
    }
    void mirror(Node node) {
        // Your code here
        if(node == null){
            return;
        }
        
        Node root = helper(node);
    }
}

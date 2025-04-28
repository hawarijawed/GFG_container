/*
Given a binary tree with a value associated with each node. Your task is to select a subset of nodes such that the sum of their values is maximized, 
with the condition that no two selected nodes are directly connected that is, if a node is included in the subset, neither its parent nor its children can be included.
*/

class Solution {
    // Function to return the maximum sum of non-adjacent nodes.
    public int getMaxSum(Node root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] helper(Node node) {
        if (node == null)
            return new int[]{0, 0};

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        // If we include this node, we cannot include its children
        int include = node.data + left[1] + right[1];

        // If we exclude this node, we can include or exclude its children
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{include, exclude};
    }
}

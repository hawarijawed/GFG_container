/*
Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.

Note: The paths should be returned such that paths from the left subtree of any node are listed first, followed by paths from the right subtree.
*/

class Solution {
    public static void helper(Node root, ArrayList<Integer> lst, ArrayList<ArrayList<Integer>> res) {
        if (root == null) return;

        // Add current node to the path list
        lst.add(root.data);

        // If it's a leaf node, add the current path to result
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(lst));
        } else {
            // Recurse left and right
            helper(root.left, lst, res);
            helper(root.right, lst, res);
        }

        // Backtrack: remove the current node before returning
        lst.remove(lst.size() - 1);
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        ArrayList<Integer> lst = new ArrayList<>();
        helper(root, lst, res);
        return res;
        
    }
}

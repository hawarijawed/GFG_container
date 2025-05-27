/*
Given a preorder traversal of a BST, find the leaf nodes of the tree without building the tree.

*/
class Solution {
    int index = 0;
    
    public ArrayList<Integer> leafNodes(int[] preorder) {
        ArrayList<Integer> leaves = new ArrayList<>();
        findLeaves(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, leaves);
        return leaves;
    }

    private void findLeaves(int[] preorder, int min, int max, ArrayList<Integer> leaves) {
        if (index >= preorder.length) return;

        int val = preorder[index];
        if (val < min || val > max) return;

        index++;
        int currentIndex = index;

        // Process left subtree (values < val)
        findLeaves(preorder, min, val - 1, leaves);
        // Process right subtree (values > val)
        findLeaves(preorder, val + 1, max, leaves);

        // If no progress was made in left and right, it's a leaf
        if (index == currentIndex) {
            leaves.add(val);
        }
    }
}

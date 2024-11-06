/*
Given a binary tree, where every node value is a number. Find the sum of all the numbers that are formed from root to leaf paths.
The formation of the numbers would be like 10*parent + current (see the examples for more clarification).
*/
class Solution {

    public static void helper(Node root, int current_sum, int[] target){
        if(root == null){
       
            return;
        }
        current_sum = current_sum*10 + root.data;
        if(root.left == null && root.right == null){
            target[0] += current_sum;
        }
        helper(root.left, current_sum, target);
        helper(root.right, current_sum, target);
    }
    public static int treePathsSum(Node root) {
        // add code here.
        if(root == null) return 0;
        int current = 0;
        int [] target = {0};
        helper(root, current, target);
        return target[0];
        
    }
}

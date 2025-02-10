/*
Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. A path can start and end at any node within the tree but must always move downward (from parent to child).
*/
class Solution {
    public int sumK(Node root, int k) {
        // code here
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        
        return dfs(root, 0, k, prefixSum);
    }
    
    private int dfs(Node node, int currentSum, int k, HashMap<Integer, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }

        // Update the current sum with the node's value
        currentSum += node.data;

        // Check if there exists a previous sum such that currentSum - previousSum = k
        int pathCount = prefixSumCount.getOrDefault(currentSum - k, 0);

        // Update the prefix sum count
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // Recur for left and right subtrees
        pathCount += dfs(node.left, currentSum, k, prefixSumCount);
        pathCount += dfs(node.right, currentSum, k, prefixSumCount);

        // Backtrack by decrementing the current sum count
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return pathCount;
    }
}

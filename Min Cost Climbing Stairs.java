/*
Given an array of integers cost[] where cost[i] is the cost of the ith step on a staircase. Once the cost is paid, you can either climb one or two steps. 
Return the minimum cost to reach the top of the floor.
Assume 0-based Indexing. You can either start from the step with index 0, or the step with index 1.
*/
class Solution {
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        
        int n = cost.length;
        
        for(int i=2; i<n; i++){
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        
        return Math.min(cost[n-1], cost[n-2]);
        
    }
};

/*
Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized. 

Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.
*/
class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int dp[] = new int[W + 1];
        int n = val.length;
    
        for (int i = 0; i <= W; i++) {
            dp[i] = 0;
        }
    
        for (int i = 0; i < n; i++) {
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
            }
        }
    
        return dp[W];
        
    }
}

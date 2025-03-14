/*
Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ]. 
Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
Answers are guaranteed to fit into a 32-bit integer. 
*/
class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int [] dp = new int[sum + 1];
        dp[0] = 1;
        
        for(int coin: coins){
            for(int i=coin; i<=sum; i++){
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[sum];
    }
}

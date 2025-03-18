/*
Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.

Note: Each element must be in exactly one subset.
*/
class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        
        if(sum%2 != 0) return false;
        
        
        return isSubsetSum(arr, sum/2);
        
    }
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean [][]dp = new boolean[n+1][sum + 1];
        
        for(int i=0; i<n+1; i++){
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If the current element is greater than the sum, we can't include it
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Either we exclude the element or include it
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        
        return dp[n][sum];
    }
}

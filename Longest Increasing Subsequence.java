/*
Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).

A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.
*/
class Solution {
    static int lis(int arr[]) {
        // code here
        int n = arr.length; 
        if(n==0) return 0;
        
        int []dp = new int[n];
        
        for(int i=0; i<n; i++){
            dp[i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int res = 0;
        for(int i=0; i<n; i++){
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}

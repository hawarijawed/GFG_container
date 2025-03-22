/*
You are given an array arr[] which represents houses arranged in a circle, where each house has a certain value. A thief aims to maximize the total stolen value without robbing two adjacent houses.
Determine the maximum amount the thief can steal.

Note: Since the houses are in a circle, the first and last houses are also considered adjacent.
*/
class Solution {
    int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        if(n==1) return arr[0];
        
        int case1 = maxLinearValue(Arrays.copyOfRange(arr,0,n-1));
        int case2 = maxLinearValue(Arrays.copyOfRange(arr,1,n));
        
        return Math.max(case1, case2);
        
    }
    int maxLinearValue(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        
        // dp[i] will store the maximum value that can be robbed up to the i-th house.
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }
        
        return dp[n-1];
    }
}

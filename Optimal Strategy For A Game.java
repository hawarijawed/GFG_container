/*
You are given an integer array arr[] of size n(even). The array elements represent n coins of values v1, v2, ....vn.
You play against an opponent in an alternating way. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the coin's value.
You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.
*/

class Solution {
    public int maximumAmount(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int gap = 0; gap < n; gap++){
            for(int i = 0 ; i+gap < n; i++){
                int j = i+ gap;
                int x = (i + 2 <= j) ? dp[i+ 2][j] : 0;
                int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                int z = (i <= j - 2) ? dp[i][j - 2] : 0;
            
                dp[i][j] = Math.max(
                    arr[i] + Math.min(x, y),   // pick i
                    arr[j] + Math.min(y, z)    // pick j
                );
            }
            
        }
        return dp[0][n - 1];
    }
}


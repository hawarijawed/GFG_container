/*
Given n dice each with m faces. Find the number of ways to get sum x which is the summation of values on each face when all the dice are thrown.
*/

class Solution {
    static int noOfWays(int m, int n, int x) {
        // code here
        int[][] dp = new int[n + 1][x + 1];
        dp[0][0] = 1;  // 1 way to get sum 0 with 0 dice

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                for (int k = 1; k <= m; k++) {
                    if (j - k >= 0) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }

        return dp[n][x];
    }
};

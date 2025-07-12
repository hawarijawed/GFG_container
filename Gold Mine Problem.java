/*
Given a gold mine called mat[][]. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially, the miner can start from any row in the first column. From a given cell, the miner can move -

to the cell diagonally up towards the right
to the right
to the cell diagonally down towards the right
Find out the maximum amount of gold that he can collect until he can no longer move.
*/
class Solution {
    public int maxGold(int[][] mat) {
        // code here
        int n = mat.length;       // number of rows
    int m = mat[0].length;    // number of columns

    int[][] dp = new int[n][m];

    // Fill the last column with the gold values directly
    for (int i = 0; i < n; i++) {
        dp[i][m - 1] = mat[i][m - 1];
    }

    // Traverse the matrix from second last column to the first
    for (int j = m - 2; j >= 0; j--) {
        for (int i = 0; i < n; i++) {
            int right = dp[i][j + 1];

            int rightUp = (i > 0) ? dp[i - 1][j + 1] : 0;

            int rightDown = (i < n - 1) ? dp[i + 1][j + 1] : 0;

            dp[i][j] = mat[i][j] + Math.max(right, Math.max(rightUp, rightDown));
        }
    }

    // The answer is the max value in the first column
    int maxGold = 0;
    for (int i = 0; i < n; i++) {
        maxGold = Math.max(maxGold, dp[i][0]);
    }

    return maxGold;
    }
}

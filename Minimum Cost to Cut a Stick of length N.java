/*
You are given a wooden stick of length n, labeled from 0 to n. You are also given an integer array cuts[], where each element cuts[i] represents a position along the stick at which you can make a cut.
Each cut costs an amount equal to the length of the stick being cut at that moment. After performing a cut, the stick is divided into two smaller sticks.
You can perform the cuts in any order. Your task is to determine the minimum total cost required to perform all the cuts.
*/
class Solution {
    public int minCutCost(int n, int[] cuts) {
        // code here
        int m = cuts.length;

    // Create extended array with boundaries 0 and n
    int[] c = new int[m + 2];
    c[0] = 0;
    c[m + 1] = n;

    // Copy and sort the cuts
    for (int i = 0; i < m; i++) {
        c[i + 1] = cuts[i];
    }
    Arrays.sort(c);

    // DP table
    int[][] dp = new int[m + 2][m + 2];

    // len is the interval length (gap between i and j)
    for (int len = 2; len < m + 2; len++) {
        for (int i = 0; i + len < m + 2; i++) {
            int j = i + len;
            dp[i][j] = Integer.MAX_VALUE;

            // Try every cut k between i and j
            for (int k = i + 1; k < j; k++) {
                int cost = c[j] - c[i] + dp[i][k] + dp[k][j];
                dp[i][j] = Math.min(dp[i][j], cost);
            }

            // If no cuts inside, cost should stay 0
            if (dp[i][j] == Integer.MAX_VALUE) {
                dp[i][j] = 0;
            }
        }
    }

    return dp[0][m + 1];
    }
}

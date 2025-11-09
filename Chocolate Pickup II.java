/*
You are given a square matrix mat[][] of size n × n, where each cell represents either a blocked cell or a cell containing some chocolates. If mat[i][j] equals -1, then the cell is blocked and cannot be visited. Otherwise, mat[i][j] represents the number of chocolates present in that cell.
The task is to determine the maximum number of chocolates a robot can collected by starting from the top-left cell (0, 0), moving to the bottom-right cell (n-1, n-1), and then returning back to (0, 0).
While moving from (0, 0) to (n-1, n-1), the robot can move only in the right (i, j+1) or downward (i+1, j) directions. On the return journey from (n-1, n-1) to (0, 0), it can move only in the left (i, j-1) or upward (i-1, j) directions.

Note: After collecting chocolates from a cell (i, j), that cell becomes empty, meaning mat[i][j] becomes 0 for next visit. If there is no valid path from (0, 0) to (n-1, n-1) or for the return trip, the result should be 0.
*/
class Solution {
    public int chocolatePickup(int[][] grid) {
        // code here
        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];
        return Math.max(0, helper(grid, 0, 0, 0, dp));
        
    }
    
    private int helper(int[][] grid, int r1, int c1, int r2, Integer[][][] dp) {
        int n = grid.length;
        int c2 = r1 + c1 - r2; // because steps are same

        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
                grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        if (r1 == n-1 && c1 == n-1)
            return grid[r1][c1];

        if (dp[r1][c1][r2] != null)
            return dp[r1][c1][r2];

        int chocolates = grid[r1][c1];
        if (r1 != r2 || c1 != c2)
            chocolates += grid[r2][c2];

        int best = Math.max(
                Math.max(helper(grid, r1+1, c1, r2+1, dp), helper(grid, r1+1, c1, r2, dp)),
                Math.max(helper(grid, r1, c1+1, r2+1, dp), helper(grid, r1, c1+1, r2, dp))
        );

        dp[r1][c1][r2] = chocolates + best;
        return dp[r1][c1][r2];
    }
}

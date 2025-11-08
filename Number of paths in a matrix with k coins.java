/*
You are given a matrix mat[][] of size n x m, where each of its cells contains some coins. Count the number of ways to collect exactly k coins while moving from the top left cell of the matrix to the bottom right cell.
From a cell (i, j), you can only move to cell (i+1, j) or (i, j+1).

Note: It is guaranteed that the answer will not exceed 32-bit integer limits.
*/
class Solution {
    public int numberOfPath(int[][] mat, int k) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int [][][]dp = new int[n][m][k+1];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return countWays(0, 0, 0, mat, dp, k);
    }
    
    public int countWays(int i, int j, int sum, int[][] mat, int[][][] dp, int k){
        if(i >= mat.length || j >= mat[0].length){
            return 0;
        }
    
        if(i == mat.length - 1 && j == mat[0].length - 1){
            return (sum + mat[i][j] == k) ? 1 : 0;
        }
        
        if(dp[i][j][sum] != -1) return dp[i][j][sum];
    
        int right = 0, down = 0;
        if(sum + mat[i][j] <= k) {
            right = countWays(i, j + 1, sum + mat[i][j], mat, dp, k);
            down  = countWays(i + 1, j, sum + mat[i][j], mat, dp, k);
        }

        dp[i][j][sum] = right + down;
        return dp[i][j][sum];
    }

}

/*
There is a standard numeric keypad on a mobile phone. You can press the current button or any button that is directly above, below, to the left, or to the right of it. 
For example, if you press 5, then pressing 2, 4, 6, or 8 is allowed. However, diagonal movements and pressing the bottom row corner buttons (* and #) are not allowed.


Given an integer n, determine how many unique sequences of length n can be formed by pressing buttons on the keypad, starting from any digit.
*/

class Solution {
    public int getCount(int n) {
        // code here
        int[][] keyPad = {{1,2,3}, {4,5,6}, {7,8,9}, {-1,0,-1}};
        int[][][] dp = new int[4][3][n+1];
        for(int[][] row : dp) for(int[] row1 : row) Arrays.fill(row1, -1);
        int ans = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                ans += solve(keyPad, i, j, n, dp);
            }
        }
        return ans;
    }
    
    private int solve(int[][] keyPad, int i, int j, int n, int[][][] dp){
        if(i < 0 || j < 0 ||  i == 4 || j == 3 || keyPad[i][j] == -1) return 0;
        if(n == 1) return 1;
        if(dp[i][j][n] != -1) return dp[i][j][n];
        int self = solve(keyPad, i, j, n-1, dp);
        int left = solve(keyPad, i, j-1, n-1, dp);
        int right = solve(keyPad, i, j+1, n-1, dp);
        int upper = solve(keyPad, i-1, j, n-1, dp);
        int lower = solve(keyPad, i+1, j, n-1, dp);
        
        return dp[i][j][n] = self + left + right + upper + lower;
    }
}


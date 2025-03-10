/*
Given two strings s1 and s2. Return the minimum number of operations required to convert s1 to s2.
The possible operations are permitted:

Insert a character at any position of the string.
Remove any character from the string.
Replace any character from the string with any other character.
*/
class Solution {
    public int editDistance(String s1, String s2) {
        // Code here
        int m = s1.length();
        int n = s2.length();
        
        int [][]dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++){
            dp[i][0] = i;
        }
        for(int i=0; i<=n; i++){
            dp[0][i] = i;
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
}

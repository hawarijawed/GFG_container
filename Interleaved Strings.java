/*
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
Interleaving of two strings s1 and s2 is a way to mix their characters to form a new string s3, while maintaining the relative order of characters from s1 and s2. Conditions for interleaving:

1. Characters from s1 must appear in the same order in s3 as they are in s1.
2. Characters from s2 must appear in the same order in s3 as they are in s2.
3. The length of s3 must be equal to the combined length of s1 and s2.
*/
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // code here
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 + n2 != s3.length()) return false;

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
            }
        }

        return dp[n1][n2];
    }
    
   
}

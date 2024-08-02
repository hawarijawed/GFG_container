/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
    public int editDistance(String str1, String str2) {
        // Code here
        int m = str1.length();
        int n = str2.length();

        // Create a 2D array to store results of subproblems
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty
                if (i == 0) {
                    dp[i][j] = j; // Insert all characters of second string
                }
                // If second string is empty
                else if (j == 0) {
                    dp[i][j] = i; // Remove all characters of first string
                }
                // If characters are the same, no operation is needed
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If characters are different, consider all possibilities
                    dp[i][j] = 1 + Math.min(
                            Math.min(dp[i - 1][j],    // Remove
                                     dp[i][j - 1]),   // Insert
                            dp[i - 1][j - 1]         // Replace
                    );
                }
            }
        }

        // dp[m][n] contains the minimum number of operations required
        return dp[m][n];
    }
}
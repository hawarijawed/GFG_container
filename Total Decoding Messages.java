/*
A message containing letters A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

You are given a string digits. You have to determine the total number of ways that message can be decoded.
*/
class Solution {
    public int countWays(String digits) {
        // code here
        if (digits == null || digits.length() == 0) {
            return 0;
        }
        
        int n = digits.length();
        
        int[] dp = new int[n + 1];
        dp[0] = 1;  
        
        dp[1] = digits.charAt(0) != '0' ? 1 : 0;
        
        for (int i = 2; i <= n; i++) {
            // Check if the current single digit is valid
            if (digits.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            
            // Check if the last two digits form a valid number between 10 and 26
            int twoDigit = Integer.parseInt(digits.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
        
    }
}

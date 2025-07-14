/*
You are given a binary string s consisting only of characters '0' and '1'. Your task is to split this string into the minimum number of non-empty substrings such that:

Each substring represents a power of 5 in decimal (e.g., 1, 5, 25, 125, ...).
No substring should have leading zeros.
Return the minimum number of such pieces the string can be divided into.
Note: If it is not possible to split the string in this way, return -1.
*/
class Solution {
    public int cuts(String s) {
        // code here
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0; // Empty string requires 0 cuts

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);

                if (isValidPowerOfFive(sub) && dp[j] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[j] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n];
    }
    
    // Helper function to check if a binary string is a valid power of 5
    private boolean isValidPowerOfFive(String s) {
        if (s.charAt(0) == '0') return false; // no leading zeros
    
        int num = 0;
        try {
            num = Integer.parseInt(s, 2); // convert binary to decimal
        } catch (NumberFormatException e) {
            return false; // number too big for int
        }

        // Check if num is a power of 5
        while (num > 1) {
            if (num % 5 != 0) return false;
            num /= 5;
        }

        return num == 1;
    }
}

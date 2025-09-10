/*
Given a string s, return the lexicographically largest string that can be obtained by swapping at most one pair of characters in s.
*/
class Solution {
    public String largestSwap(String s) {
        // code here
        char[] chars = s.toCharArray();
        int n = chars.length;

        // Step 1: Store the last index of each digit (0–9)
        int[] lastIndex = new int[10];
        for (int i = 0; i < n; i++) {
            lastIndex[chars[i] - '0'] = i;
        }

        // Step 2: Traverse the string
        for (int i = 0; i < n; i++) {
            int currentDigit = chars[i] - '0';

            // Look for a larger digit (from 9 down to currentDigit + 1)
            for (int d = 9; d > currentDigit; d--) {
                if (lastIndex[d] > i) {
                    // Found a better digit to swap
                    int j = lastIndex[d];
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;

                    return new String(chars);  // Only one swap allowed
                }
            }
        }

        // No better swap found
        return s;
    }
}

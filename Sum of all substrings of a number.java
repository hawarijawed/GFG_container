/*
Given an integer s represented as a string, the task is to get the sum of all possible sub-strings of this string.

Note: The number may have leading zeros.
It is guaranteed that the total sum will fit within a 32-bit signed integer.
*/
class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int n = s.length();
        int totalSum = 0;
        int prev = Character.getNumericValue(s.charAt(0));
        totalSum = prev;

        for (int i = 1; i < n; i++) {
            int num = Character.getNumericValue(s.charAt(i));
            // Using long to avoid intermediate overflow
            prev = (int)(num * (i + 1L) + 10L * prev);
            totalSum += prev;
        }

        return totalSum;
    }
}

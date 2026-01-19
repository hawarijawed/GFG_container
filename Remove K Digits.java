/*
Given a non-negative integer s represented as a string and an integer k, remove exactly k digits from the string so that the resulting number is the smallest possible, while maintaining the relative order of the remaining digits.

Note : The resulting number must not contain any leading zeros.
If the resulting number is an empty string after the removal, return "0".
*/
class Solution {
    public String removeKdig(String s, int k) {
        // code here
        Stack<Integer> stack = new Stack<>();
        
        // If k is equal to the length of s, return "0" since all digits are removed.
        if (k == s.length()) return "0";
        
        // Process each digit of the string
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - '0';
            
            // Remove digits from the stack while the current digit is smaller
            // than the top of the stack and k is greater than 0
            while (!stack.isEmpty() && stack.peek() > val && k > 0) {
                stack.pop();
                k--;
            }
            
            stack.push(val);
        }
        
        // Remove the remaining k digits if needed (in case the digits are in increasing order)
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // Build the result string from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) ('0' + stack.pop()));
        }
        
        // Reverse the string to get the correct order
        sb.reverse();
        
        // Remove leading zeros
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        
        // If the string is empty after removing leading zeros, return "0"
        if (i == sb.length()) return "0";
        
        return sb.substring(i);
    }
}

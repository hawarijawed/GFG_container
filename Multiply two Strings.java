/*
Given two numbers as strings s1 and s2. Calculate their Product.
Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers. 
There can be zeros in the begining of the numbers. You don't need to specify '+' sign in the begining of positive numbers.
*/
class Solution {
    public String multiplyStrings(String s1, String s2) {
        // code here.
        // Handle empty strings
    if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return "0";

    // Determine sign of the result
    boolean isNegative = false;
    if (s1.charAt(0) == '-') {
        isNegative = !isNegative;
        s1 = s1.substring(1);
    }
    if (s2.charAt(0) == '-') {
        isNegative = !isNegative;
        s2 = s2.substring(1);
    }

    // Remove leading zeros
    s1 = removeLeadingZeros(s1);
    s2 = removeLeadingZeros(s2);

    // Handle multiplication with zero
    if (s1.equals("0") || s2.equals("0")) return "0";

    int m = s1.length(), n = s2.length();
    int[] result = new int[m + n];

    // Multiply each digit
    for (int i = m - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
            int digit1 = s1.charAt(i) - '0';
            int digit2 = s2.charAt(j) - '0';
            int product = digit1 * digit2;

            int p1 = i + j, p2 = i + j + 1;
            int sum = product + result[p2];

            result[p2] = sum % 10;
            result[p1] += sum / 10;
        }
    }

    // Convert result array to string
    StringBuilder sb = new StringBuilder();
    int i = 0;
    // Skip leading zeros
    while (i < result.length && result[i] == 0) i++;
    for (; i < result.length; i++) {
        sb.append(result[i]);
    }

    // Add negative sign if needed
    if (isNegative) sb.insert(0, '-');

    return sb.toString();
    }
    private String removeLeadingZeros(String s) {
    int i = 0;
    while (i < s.length() - 1 && s.charAt(i) == '0') {
        i++;
    }
    return s.substring(i);
    
}
}

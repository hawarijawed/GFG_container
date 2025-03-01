/*
Given an encoded string s, the task is to decode it. The encoding rule is :

k[encodedString], where the encodedString inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer, and encodedString contains only lowercase english alphabets.
Note: The test cases are generated so that the length of the output string will never exceed 105 .
*/
class Solution {
    static String decodeString(String s) {
        // code here
        Stack<String> strStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        
        StringBuilder currentStr = new StringBuilder();  // Holds the current decoded string
        int currentNum = 0;  // To hold the current number (k)
        
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                // If the character is a digit, update the currentNum (k)
                currentNum = currentNum * 10 + (ch - '0');
            } else if (ch == '[') {
                // If '[' is encountered, push the current number and string onto the stack
                countStack.push(currentNum);
                strStack.push(currentStr.toString());
                
                // Reset for the next part
                currentStr = new StringBuilder();
                currentNum = 0;
            } else if (ch == ']') {
                // If ']' is encountered, pop the stack and repeat the current string
                int repeatCount = countStack.pop();
                String previousStr = strStack.pop();
                
                // Repeat the current string 'repeatCount' times
                StringBuilder repeatedStr = new StringBuilder();
                for (int j = 0; j < repeatCount; j++) {
                    repeatedStr.append(currentStr);
                }
                
                // Concatenate the previous string with the repeated part
                currentStr = new StringBuilder(previousStr + repeatedStr.toString());
            } else {
                // If it's a character, simply append to the current string
                currentStr.append(ch);
            }
        }
        
        // The final result will be in currentStr
        return currentStr.toString();
    }
}

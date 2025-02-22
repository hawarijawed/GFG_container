/*
Given a string s consisting of opening and closing parenthesis '(' and ')'. Find the length of the longest valid parenthesis substring.

A parenthesis string is valid if:

For every opening parenthesis, there is a closing parenthesis.
The closing parenthesis must be after its opening parenthesis.
*/
class Solution {
    static int maxLength(String s) {
        // code here
        Stack<Integer> stack = new Stack<>();
        if(s.length() == 1) return 0;
        stack.push(-1);
        int n = s.length();
        int maxLen = 0;
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                stack.push(i);
                
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}

/*
Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
An input string is valid if:

         1. Open brackets must be closed by the same type of brackets.
         2. Open brackets must be closed in the correct order.
*/
class Solution {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
                continue;
            }
            if( stack.peek() == '(' && ch == ')' || 
                stack.peek() == '{' && ch == '}' ||
                stack.peek() == '[' && ch == ']'){
                    stack.pop();
                    continue;
                }
            
            stack.push(ch);
        }
        
        return stack.size()==0;
    }
}

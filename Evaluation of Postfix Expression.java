/*
You are given an array of strings arr that represents a valid arithmetic expression written in Reverse Polish Notation (Postfix Notation). Your task is to evaluate the expression and return an integer representing its value.

Key Details:

The valid operators are '+', '-', '*', and '/'.
Each operand is guaranteed to be a valid integer or another expression.
The division operation between two integers always rounds the result towards zero, discarding any fractional part.
No division by zero will occur in the input.
The input is a valid arithmetic expression in Reverse Polish Notation.
The result of the expression and all intermediate calculations will fit in a 32-bit signed integer.
*/
class Solution {
    public int evaluate(String[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            String token = arr[i];
            if(token.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            }
            else if(token.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if(token.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            }
            else if(token.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push((int)(b / a));
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}

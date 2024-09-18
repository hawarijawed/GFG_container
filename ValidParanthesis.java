
class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> stack = new Stack<>();
    
    for (int i = 0; i < x.length(); i++) {
        char ch = x.charAt(i);
        
        // Push opening brackets onto the stack
        if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch);
        } 
        // If it's a closing bracket, check for matching
        else if (ch == ')' || ch == ']' || ch == '}') {
            // Check if stack is empty or top of stack does not match
            if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                return false;
            }
        }
    }
    
    // If stack is empty, all brackets are balanced
    return stack.isEmpty();
    }
    
    static boolean isMatchingPair(char opening, char closing) {
    return (opening == '(' && closing == ')') ||
           (opening == '[' && closing == ']') ||
           (opening == '{' && closing == '}');
}
}

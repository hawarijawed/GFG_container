/*
Given a string of balanced expression s, check if it contains a redundant parenthesis or not. A set of parenthesis are redundant if the same sub-expression is surrounded by unnecessary or multiple brackets.
Note: Expression may contain + , - , *, and / operators. Given expression is valid and there are no white spaces present.
*/
class Solution {
    public static boolean checkRedundancy(String s) {
        // code here
        Stack<Character> st= new Stack<>();
        
        for(int x=0; x<s.length(); x++)
        {
            char ch= s.charAt(x);
            if(ch==')')
            {
                if(st.peek()=='(')
                    return true;
                char p= st.pop();
                while(!st.isEmpty() && p!='(')
                {
                    p=st.pop();
                }
            }
            else if(!Character.isLetter(ch))
                st.push(ch);
        }
        return false;
    }
}

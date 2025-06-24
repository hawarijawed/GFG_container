/*
Given a string s consisting of lowercase English letters and an integer k, your task is to remove exactly k characters from the string. The resulting string must be the largest possible in lexicographical  order, while maintain the relative order of the remaining characters.
*/
class Solution {
    public static String maxSubseq(String s, int k) {
        // code here
        int n = s.length();
        if(k==n){
            return "";
        }
        if(k==0){
            return s;
        }
        
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek() < ch){
                stack.pop();
                k--;
            }
            
            stack.push(ch);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
    }
}

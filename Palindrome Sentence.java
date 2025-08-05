/*
Given a single string s, the task is to check if it is a palindrome sentence or not.
A palindrome sentence is a sequence of characters, such as word, phrase, or series of symbols that reads the same backward as forward after converting all uppercase letters to 
lowercase and removing all non-alphanumeric characters (including spaces and punctuation).
*/
class Solution {
    public boolean isPalinSent(String s) {
        // code here
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        if(s.length()==1) return true;
        s = s.toLowerCase();
        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
                sb1.append(ch);
            }
        }
        
        if((sb1.toString()).equals(sb.reverse().toString())){
            return true;
        }
        
        return false;
    }
}

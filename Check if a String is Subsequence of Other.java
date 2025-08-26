/*
Given two strings s1 and s2. You have to check that s1 is a subsequence of s2 or not.
Note: A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements.
*/

//----------------- Recursive Approach -------------------//
class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // Recursive approach
        return helper(s1, s2, 0, 0);
    }
    
    public boolean helper(String s1, String s2, int i, int j){
        
        if(i>=s1.length()){
            return true;
        }
        if(j>=s2.length() && i<s1.length()) return false;
        if(s1.charAt(i) == s2.charAt(j)){
            return helper(s1, s2, i+1, j+1);
        }
        else{
            return helper(s1, s2, i, j+1);
        }
        
    }
};

//----------------------- Iterative Approach -----------------------//
class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // Recursive approach
        int i=0, j=0;
        for(j=0; j<s2.length(); j++){
            if(i<s1.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
            }
        }
        
        return i==s1.length();
    }
    
};

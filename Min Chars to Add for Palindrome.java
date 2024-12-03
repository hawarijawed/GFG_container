/*
Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.

Note: A palindrome string is a sequence of characters that reads the same forward and backward.
*/
class Solution {
    public static int[] computeLPS(String s){
        int n = s.length();
        
        int pre = 0;
        int suff = 1;
        
        int []lps = new int[n];
        
        while(suff < n){
            if(s.charAt(pre) == s.charAt(suff)){
                pre ++;
                lps[suff] = pre;
                suff ++;
            }
            else{
                if(pre == 0){
                    lps[suff] = 0;
                    suff ++;
                }
                else{
                    pre = lps[pre-1];
                }
            }
        }
        
        return lps;
    }
    public static int minChar(String s) {
        // Write your code here
        String reverse = new StringBuilder(s).reverse().toString();
        String concat = s + "#" + reverse;
        
        int []lps = computeLPS(concat);
        
        return s.length() - lps[lps.length - 1];
    }
}

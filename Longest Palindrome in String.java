/*
Given a string s, your task is to find the longest palindromic substring within s.

A substring is a contiguous sequence of characters within a string, defined as s[i...j] where 0 ≤ i ≤ j < len(s).

A palindrome is a string that reads the same forward and backward. More formally, s is a palindrome if reverse(s) == s.

Note: If there are multiple palindromic substrings with the same length, return the first occurrence of the longest palindromic substring from left to right.
*/
class Solution {
    static String expandAround(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
    static String longestPalindrome(String s) {
        // code here
        if(s.length()==0||s==null)return "";
        String longestPalin="";
        for(int i=0;i<s.length();i++){
            String pal1=expandAround(s,i,i+1);
            if(pal1.length()>longestPalin.length()){
                longestPalin=pal1;
            }
            String pal2=expandAround(s,i,i);
            if(pal2.length()>longestPalin.length()){
                longestPalin=pal2;
            }
        }
        return longestPalin;
    }
}

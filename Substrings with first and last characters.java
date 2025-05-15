/*
Given a string s consisting of lowercase characters, the task is to find the count of all substrings that start and end with the same character.
*/

class Solution {
    public int countSubstring(String s) {
        // code here
        int[] arr = new int[26];
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            arr[ch-'a']++;
        }
        
        int res = 0;
        for(int i=0; i<26; i++){
            int f = arr[i];
            res += f + f*(f-1)/2;
        }
        
        return res;
    }
}

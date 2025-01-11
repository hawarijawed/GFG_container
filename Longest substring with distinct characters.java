/*
Given a string s, find the length of the longest substring with all distinct characters. 
*/
class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        boolean[] arr = new boolean[26];
        
        int maxLen = Integer.MIN_VALUE;
        int l = 0, r=0;
        while(r < s.length()){
            while(arr[s.charAt(r)-'a'] == true){
                arr[s.charAt(l)-'a'] = false;
                l++;
            }
            arr[s.charAt(r) - 'a'] = true;
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        
        return maxLen;
    }
}

/*
Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic sub-string must be greater than or equal to 2.

Note: A substring is palindromic if it reads the same forwards and backwards.
*/

class Solution {
    public int countPS(String s) {
        // code here
        int count = 0;
        int n = s.length();
        
        for(int center = 0; center < 2*n-1; center++){
            int left = center/2;
            int right = left + center%2;
            
            while(left>=0 && right < n && s.charAt(left) == s.charAt(right)){
                if(right - left + 1 >= 2){
                    count++;
                }
                left--;
                right++;
            }
        }
        return count;
    }
    
}

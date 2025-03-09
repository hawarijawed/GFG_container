/*
Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic sub-string must be greater than or equal to 2. 
*/
class Solution {
    public int palCount(int left, int right, String s){
        int count = 0;
        while(left >=0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
            else break;
        }
        
        return count;
    }
    public int countPS(String s) {
        // code here
        int n = s.length();
        
        int oddCount = 0;
        int evenCount = 0;
        //Odd count
        for(int i=1; i<n; i++){
            oddCount += palCount(i-1, i+1, s);
        }
        
        //Even count
        for(int i=1; i<n; i++){
            evenCount += palCount(i-1, i, s);
        }
        
        return oddCount + evenCount;
    }
}
